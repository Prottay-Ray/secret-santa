package com.secretsanta.groupactivitiesservice.controller;


import com.secretsanta.groupactivitiesservice.entity.GroupEntity;
import com.secretsanta.groupactivitiesservice.service.WishListActivitiesService;
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
    public ResponseEntity<List<GroupEntity>> participantofgroup(@PathVariable Long userId){
        return new ResponseEntity<>(wishListActivitiesService.participantofgroup(userId), HttpStatus.OK);
    }

    @GetMapping("group/is-gifted/{userId}")
    public ResponseEntity<Boolean> isGifted(@PathVariable Long userId){
        return new ResponseEntity<>(wishListActivitiesService.isGifted(userId) ,HttpStatus.OK);
    }
}
