package com.secretsanta.groupactivitiesservice.service;



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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class WishListActivitiesService {

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

    public List<GroupEntity> participantofgroup(Long userId) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if (userEntity.isEmpty()) throw new UserDoesNotExistException("This user does not exist.");
        return userEntity.get().getGroups();
    }

    public Boolean isGifted(Long userId){
       Optional<WishlistItem> wishListEntity = wishlistItemRepository.findById(userId);
        if(wishListEntity.get().getIsGifted()) return true;
        return false;
    }
}


