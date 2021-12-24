package com.secretsanta.groupactivitiesservice.service;



import com.secretsanta.groupactivitiesservice.dto.GiftCheckDTO;
import com.secretsanta.groupactivitiesservice.dto.WishlistCheckDTO;
import com.secretsanta.groupactivitiesservice.entity.GroupEntity;
import com.secretsanta.groupactivitiesservice.entity.UserEntity;
import com.secretsanta.groupactivitiesservice.entity.WishlistItem;
import com.secretsanta.groupactivitiesservice.exception.GroupNotFoundException;
import com.secretsanta.groupactivitiesservice.exception.UserDoesNotExistException;
import com.secretsanta.groupactivitiesservice.repository.GroupRepository;
import com.secretsanta.groupactivitiesservice.repository.UserEntityRepository;
import com.secretsanta.groupactivitiesservice.repository.WishlistItemRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WishListActivitiesServiceImpl1 implements WishListActivitiesService{

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


    public List<GroupEntity> participantOfGroup(Long userId) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if (userEntity.isEmpty()) throw new UserDoesNotExistException("This user does not exist.");
        return userEntity.get().getGroups();
    }

    public List<WishlistCheckDTO> isGifted(Long userId, Long groupId, GiftCheckDTO giftCheckDTO){

        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if (userEntity.isEmpty()) throw new UserDoesNotExistException("This user does not exist.");
        Optional<GroupEntity> group = groupRepository.findById(groupId);
        if (group.isEmpty()) throw new GroupNotFoundException("This group does not exist.");
        List<WishlistItem> list1;

        if (giftCheckDTO.getAsSanta()) {
            list1 =  wishlistItemRepository.findGiftStatus(userId, groupId);
        } else {
            list1 =  wishlistItemRepository.findGiftStatusUser(userId, groupId);
        }

        return modelMapper.map(list1, new TypeToken<List<WishlistCheckDTO>>() {}.getType());

    }
}


