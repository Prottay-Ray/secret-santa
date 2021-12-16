package com.secretsanta.groupactivitiesservice.controller;

import com.secretsanta.groupactivitiesservice.dto.GroupCreationDTO;
import com.secretsanta.groupactivitiesservice.dto.GroupDisplayDTO;
import com.secretsanta.groupactivitiesservice.dto.WishlistDTO;
import com.secretsanta.groupactivitiesservice.service.WishListCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WishListCreationController {
    @Autowired
    WishListCreationService wishListCreationService;

    @PostMapping("/group/wishlist/{userId}")
    public ResponseEntity<WishlistDTO> createwishlistforuser(@PathVariable Long userId,@RequestBody List<WishlistDTO> wishlistDTO){
        WishlistDTO wishlistcreationforuser=wishListCreationService.createwishlistforuser(userId,wishlistDTO);
        return new ResponseEntity<>(wishlistcreationforuser, HttpStatus.CREATED);
    }

}
