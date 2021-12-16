package com.secretsanta.groupactivitiesservice.service;

import com.secretsanta.groupactivitiesservice.dto.*;
import com.secretsanta.groupactivitiesservice.entity.GroupEntity;
import com.secretsanta.groupactivitiesservice.entity.UserEntity;
import com.secretsanta.groupactivitiesservice.entity.WishlistItem;
import com.secretsanta.groupactivitiesservice.exception.GroupNameUnavailableException;
import com.secretsanta.groupactivitiesservice.exception.GroupNotFoundException;
import com.secretsanta.groupactivitiesservice.exception.UserDoesNotExistException;
import com.secretsanta.groupactivitiesservice.repository.GroupRepository;
import com.secretsanta.groupactivitiesservice.repository.UserEntityRepository;
import com.secretsanta.groupactivitiesservice.repository.WishlistItemRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class GroupActivitiesService extends ModelMapper{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserEntityRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private WishlistItemRepository wishlistItemRepository;

    @Autowired
    private CommunicatorService communicatorService;

    @Autowired
    private GroupEntity group;

    //Utility function to convert Date from String type to Date type
    public Date toDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        return formatter.parse(date);
    }

    //Utility function to check if user is valid then return the user
    public UserEntity checkUser(Long userId) {

        Optional<UserEntity> user = userRepository.findById(userId);

        // Checking if the userId is valid
        if(user.isEmpty()) throw new UserDoesNotExistException("The user does not exist!");

        return user.get();

    }

    //Utility function to check if group is valid then return the group
    public GroupEntity checkGroup(Long groupId) {

        Optional<GroupEntity> groupEntity = groupRepository.findById(groupId);

        if (groupEntity.isEmpty()) throw new GroupNotFoundException("This Group does not exist!");

        return groupEntity.get();

    }

    public GroupCreationDTO createGroup(Long userId, GroupCreationDTO groupCreationDTO) throws Exception {

        UserEntity user = checkUser(userId);

        // Check if the given group name is available
        if(!communicatorService.isGroupNameAvailable(groupCreationDTO.getGroupName()))
            throw new GroupNameUnavailableException("The group name is already taken!");

        // Clearing the group object before reuse
        group.clearGroupObject();

        // map the details from dto to group object
        modelMapper.map(groupCreationDTO, group);

        // Add user to the group and set the deadlines
        group.addUser(user);
        group.setBudgetDeadline(toDate(groupCreationDTO.getBudgetDeadline()));
        group.setWishlistDeadline(toDate(groupCreationDTO.getWishlistDeadline()));

        groupRepository.save(group);

        //Add group to the user
        user.addGroup(group);
        userRepository.save(user);

        return groupCreationDTO;

    }

    public String deleteGroup(Long groupId) {

        Optional<GroupEntity> groupEntity = groupRepository.findById(groupId);
        if (groupEntity.isEmpty()) throw new GroupNotFoundException("This group does not exist.");

        try {
            groupRepository.delete(groupEntity.get());
            return "Group Deleted Successfully!";
        } catch (Exception e) {
            return "Group could not be deleted. Some error occured.";
        }
    }

    public Boolean joinGroup(Long userId, JoinGroupDTO joinGroupDTO) {

        UserEntity user = checkUser(userId);

        group = groupRepository.findGroupEntityByGroupNameEquals(joinGroupDTO.getGroupName());

        if (group == null) throw new GroupNotFoundException("This group does not exist!");

        group.addUser(user);
        groupRepository.save(group);

        user.addGroup(group);
        userRepository.save((user));

        return true;

    }

    public Boolean assignSanta(Long groupId) {

        Optional<GroupEntity> groupEntity = groupRepository.findById(groupId);
        if (groupEntity.isEmpty()) throw new GroupNotFoundException("This group does not exist.");

        //Getting all the wishlist items of a particular group
        List<WishlistItem> wishlistItems = groupEntity.get().getWishlist();

        //Getting all the users associated with the group
        List<UserEntity> users = groupEntity.get().getUsers();
        Map<UserEntity, UserEntity> userMap = new HashMap<>();

        int l = users.size();

        int a = 1 + (int) (Math.random()*(l - 1));

        for (int i = 0; i < l-a; i++) {
            userMap.put(users.get(i), users.get(i + a));
        }
        for (int i = l - a; i < l; i++) {
            userMap.put(users.get(i), users.get(i - (l - a)));
        }
        for (WishlistItem wishlistItem : wishlistItems) {
            wishlistItem.setSanta(userMap.get(wishlistItem.getUser()));
        }

        return true;

    }


    public GiftReceivedDTO giftBestWay(Long groupId, Long userId) {

        UserEntity user = checkUser(userId);    //The user is the santa

        group = checkGroup(groupId);    //The group of santa

        List<WishlistItem> list = wishlistItemRepository.findWishlistItemsBySantaUserIdEqualsAndGroup_GroupId(userId, groupId);

        for (WishlistItem item :
                list) {
            item.setIsGifted(true);
        }
        
        List<WishlistItemDTO> sendList = modelMapper.map(list, new TypeToken<List<WishlistItemDTO>>() {}.getType());

        return new GiftReceivedDTO(user.getUserName(), list.get(0).getUser().getUserName(), sendList);
    }
}
