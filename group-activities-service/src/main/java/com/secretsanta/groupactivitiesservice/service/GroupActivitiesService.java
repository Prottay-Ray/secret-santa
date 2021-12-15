package com.secretsanta.groupactivitiesservice.service;

import com.secretsanta.groupactivitiesservice.dto.GroupCreationDTO;
import com.secretsanta.groupactivitiesservice.entity.GroupEntity;
import com.secretsanta.groupactivitiesservice.entity.UserEntity;
import com.secretsanta.groupactivitiesservice.exception.GroupNameUnavailableException;
import com.secretsanta.groupactivitiesservice.exception.UserDoesNotExistException;
import com.secretsanta.groupactivitiesservice.repository.GroupRepository;
import com.secretsanta.groupactivitiesservice.repository.UserEntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

@Service
public class GroupActivitiesService extends ModelMapper{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserEntityRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private CommunicatorService communicatorService;

    @Autowired
    private GroupEntity group;

    //Utility function to convert Date from String type to Date type
    public Date toDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        return formatter.parse(date);
    }

    public GroupCreationDTO createGroup(Long userId, GroupCreationDTO groupCreationDTO) throws Exception {

        Optional<UserEntity> user = userRepository.findById(userId);

        // Checking if the userId is valid
        if(user.isEmpty()) throw new UserDoesNotExistException("The user does not exist!");

        // Check if the given group name is available
        if(!communicatorService.isGroupNameAvailable(groupCreationDTO.getGroupName()))
            throw new GroupNameUnavailableException("The group name is already taken!");

        // Clearing the group object before reuse
        group.clearGroupObject();

        // map the details from dto to group object
        modelMapper.map(groupCreationDTO, group);

        // Add user to the group and set the deadlines
        group.addUser(user.get());
        group.setBudgetDeadline(toDate(groupCreationDTO.getBudgetDeadline()));
        group.setWishlistDeadline(toDate(groupCreationDTO.getWishlistDeadline()));

        groupRepository.save(group);

        //Add group to the user
        user.get().addGroup(group);
        userRepository.save(user.get());

        return groupCreationDTO;

    }
}
