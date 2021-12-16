package com.secretsanta.groupactivitiesservice.controller;

import com.secretsanta.groupactivitiesservice.dto.GroupCreationDTO;
import com.secretsanta.groupactivitiesservice.dto.GroupDisplayDTO;
import com.secretsanta.groupactivitiesservice.dto.WishlistDTO;
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
    @PostMapping("/group/wishlist/{userId}")
    public  boolean createwishlistforuser(@PathVariable Long userId,@RequestBody List<WishlistDTO> wishlistDTO){
        boolean wishlistcreationforuser=wishListCreationService.createwishlistforuser(userId,wishlistDTO);
        return wishlistcreationforuser;
    }

    //to see wishlist of the santas child
    @GetMapping("/group/wishlist/{userId}/{groupId}")
    public List<WishlistDTO> listsantasees(@PathVariable Long userId,@PathVariable Long groupId){
        List<WishlistDTO> wishlistDTO=wishListCreationService.listsantasees(userId,groupId);
        return wishlistDTO;
    }
}
