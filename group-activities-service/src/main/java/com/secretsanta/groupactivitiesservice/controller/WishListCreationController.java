package com.secretsanta.groupactivitiesservice.controller;

import com.secretsanta.groupactivitiesservice.dto.WishlistItemDTO;
import com.secretsanta.groupactivitiesservice.service.WishListCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WishListCreationController {
    @Autowired
    WishListCreationService wishListCreationService;

    //to make new wishlist and add wishlist to user
    @PostMapping("/group/wishlist/{userId}/group/{groupId}")
    public ResponseEntity<Boolean> createWishlistForUser(@PathVariable Long userId, @PathVariable Long groupId, @RequestBody List<WishlistItemDTO> wishlistDTO){
        return new ResponseEntity<>(wishListCreationService.createWishlistForUser(userId, groupId, wishlistDTO), HttpStatus.CREATED);
    }

    //to see wishlist of the santa's child
    @GetMapping("/group/wishlist/{userId}/{groupId}")
    public ResponseEntity<List<WishlistItemDTO>> seeGiftWishlist(@PathVariable Long userId, @PathVariable Long groupId){
        return new ResponseEntity<>(wishListCreationService.seeGiftWishlist(userId,groupId), HttpStatus.FOUND);
    }
}
