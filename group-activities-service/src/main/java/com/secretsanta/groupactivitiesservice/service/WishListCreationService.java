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

//    @Autowired
//    private UserEntity user;

    @Autowired
    private WishlistItemRepository wishlistItemRepository;
//item1
    //priorit
    //name
    //price
    //item2
    //priorit
    //name
    //price
    //owning table date should be saved there
    public WishlistDTO createwishlistforuser(Long userId, List<WishlistDTO> wishlistDTO) {
        Optional<UserEntity> userdetails=userEntityRepository.findById(userId);

        if(userdetails.isEmpty()){
            throw new UserDoesNotExistException("User doesn't exist");
        }

        for(int i=0;i<wishlistDTO.size();i++){
            //convert the input dto to entity
            WishlistItem wl=new WishlistItem();
            modelMapper.map(wishlistDTO.get(i),wl);
            //add user to entity
            wl.setUser(userdetails.get());
            //save the entity to wishlist repo

            wishlistItemRepository.save(wl);
        }

        WishlistDTO wlDTO=new WishlistDTO();
        modelMapper.map(userdetails.get(),wlDTO);
        return wlDTO;
    }


}
