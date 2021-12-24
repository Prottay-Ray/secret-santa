package com.secretsanta.groupactivitiesservice.service;

import com.secretsanta.groupactivitiesservice.dto.WishlistItemDTO;

import java.util.List;

public interface WishListCreationService {

    boolean createWishlistForUser(Long userId, Long groupId, List<WishlistItemDTO> wishlistDTO);

    List<WishlistItemDTO> seeGiftWishlist(Long santaId, Long groupId);

}
