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
public class WishListCreationServiceImpl1 implements WishListCreationService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private WishlistItemRepository wishlistItemRepository;


    public boolean createWishlistForUser(Long userId, Long groupId, List<WishlistItemDTO> wishlistDTO) {
        Optional<UserEntity> user = userEntityRepository.findById(userId);

        if (user.isEmpty()) {
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
            wl.setUser(user.get());
            //save the entity to wishlist repo
            wl.setIsGifted(Boolean.FALSE);
            wl.setPriority(dto.getPriority());
            wishlistItemRepository.save(wl);
            user.get().addWishlistItem(wl);
            userEntityRepository.save(user.get());
            group.addWishlistItem(wl);
            groupRepository.save(group);
        }

        return true;
    }


    public List<WishlistItemDTO> seeGiftWishlist(Long santaId, Long groupId) {
        List<WishlistItem> searched=wishlistItemRepository.findWishlistItemsForSantaInGroup(santaId,groupId);
        List<WishlistItemDTO> listDTO=modelMapper.map(searched, new TypeToken<List<WishlistItemDTO>>() {}.getType());
        modelMapper.map(searched,listDTO);
        return listDTO;

    }
}
