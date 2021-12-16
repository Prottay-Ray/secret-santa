package com.secretsanta.groupactivitiesservice.service;

import com.secretsanta.groupactivitiesservice.dto.GroupDisplayDTO;
import com.secretsanta.groupactivitiesservice.dto.WishlistDTO;
import com.secretsanta.groupactivitiesservice.entity.GroupEntity;
import com.secretsanta.groupactivitiesservice.entity.UserEntity;
import com.secretsanta.groupactivitiesservice.entity.WishlistItem;
import com.secretsanta.groupactivitiesservice.exception.UserDoesNotExistException;
import com.secretsanta.groupactivitiesservice.repository.UserEntityRepository;
import com.secretsanta.groupactivitiesservice.repository.WishlistItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishListCreationService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private UserEntity user;

    @Autowired
    private WishlistItemRepository wishlistItemRepository;

    public WishlistDTO createwishlistforuser(Long userId, List<WishlistDTO> wishlistDTO) {
        Optional<UserEntity> userdetails=userEntityRepository.findById(userId);

        if(userdetails.isEmpty()){
            throw new UserDoesNotExistException("User doesn't exist");
        }





        user.addWishlist((WishlistItem) wishlistDTO);
        userEntityRepository.save(user);

        WishlistDTO wishlistnewDTO=new WishlistDTO();
        modelMapper.map(userdetails.get(),wishlistnewDTO);
        return wishlistnewDTO;
    }

//for creation of wishlist

}
