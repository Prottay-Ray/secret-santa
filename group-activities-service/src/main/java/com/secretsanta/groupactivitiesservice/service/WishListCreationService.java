package com.secretsanta.groupactivitiesservice.service;

import com.secretsanta.groupactivitiesservice.dto.GroupDisplayDTO;
import com.secretsanta.groupactivitiesservice.dto.WishlistDTO;
import com.secretsanta.groupactivitiesservice.dto.WishlistItemDTO;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WishListCreationService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private GroupRepository groupRepository;

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
    public boolean createwishlistforuser(Long userId, Long groupId, List<WishlistItemDTO> wishlistDTO) {
        Optional<UserEntity> userdetails = userEntityRepository.findById(userId);

        if (userdetails.isEmpty()) {
            throw new UserDoesNotExistException("User doesn't exist");
        }

        GroupEntity group;

        group = groupRepository.findById(groupId).orElse(null);
        if (group == null) throw new GroupNotFoundException("This group does not exist!");

        for (WishlistItemDTO dto : wishlistDTO) {
            //convert the input dto to entity
            WishlistItem wl = new WishlistItem();
            modelMapper.map(dto, wl);

            //setting the group of the santa
            wl.setGroup(group);
            //add user to entity
            wl.setUser(userdetails.get());
            //save the entity to wishlist repo
            wl.setIsGifted(Boolean.FALSE);
            wl.setPriority(wl.getPriority());
            wishlistItemRepository.save(wl);
            userdetails.get().addWishlistItem(wl);
            userEntityRepository.save(userdetails.get());
            group.addWishlistItem(wl);
            groupRepository.save(group);
        }

        return true;
    }


    public List<WishlistItemDTO> listsantasees(Long santaId, Long groupId) {
        List<WishlistItem> searchiftwo=wishlistItemRepository.findWishlistItemsForSantaInGroup(santaId,groupId);
        List<WishlistItemDTO> wlistDTO=modelMapper.map(searchiftwo, new TypeToken<List<WishlistItemDTO>>() {}.getType());
        modelMapper.map(searchiftwo,wlistDTO);
        return wlistDTO;

    }
}
