package com.secretsanta.groupactivitiesservice.controller;


import com.secretsanta.groupactivitiesservice.dto.GiftCheckDTO;
import com.secretsanta.groupactivitiesservice.dto.WishlistCheckDTO;
import com.secretsanta.groupactivitiesservice.entity.GroupEntity;
import com.secretsanta.groupactivitiesservice.service.WishListActivitiesService;
import com.secretsanta.groupactivitiesservice.service.WishListActivitiesServiceImpl1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WishListActivityController {

    @Autowired
    private WishListActivitiesService wishListActivitiesService;

    // See all groups with which the user is attached
    @GetMapping("group/participant-of-group/{userId}")
    public ResponseEntity<List<GroupEntity>> participantOfGroup(@PathVariable Long userId){
        return new ResponseEntity<>(wishListActivitiesService.participantOfGroup(userId), HttpStatus.OK);
    }

    @PutMapping("group/is-gifted/user/{userId}/group/{groupId}")
    public ResponseEntity<List<WishlistCheckDTO>> isGifted(@PathVariable Long userId, @PathVariable Long groupId, @RequestBody GiftCheckDTO giftCheckDTO) {
        return new ResponseEntity<>(wishListActivitiesService.isGifted(userId, groupId, giftCheckDTO) ,HttpStatus.OK);
    }
}
