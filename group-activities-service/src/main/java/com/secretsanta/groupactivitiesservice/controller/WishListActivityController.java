package com.secretsanta.groupactivitiesservice.controller;


import com.secretsanta.groupactivitiesservice.entity.GroupEntity;
import com.secretsanta.groupactivitiesservice.service.WishListActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class WishListActivityController {
    @Autowired
    private WishListActivitiesService wishListActivitiesService;

    @GetMapping("group/participant-of-group/{userId}")
    public ResponseEntity<GroupEntity> participantofgroup(@PathVariable Long userId){
        return new ResponseEntity<GroupEntity>((GroupEntity) wishListActivitiesService.participantofgroup(userId), HttpStatus.OK);
    }

    @GetMapping("group/is-gifted/{userId}")
    public ResponseEntity<Boolean> isGifted(@PathVariable Long userId){
        return new ResponseEntity<>(wishListActivitiesService.isGifted(userId) ,HttpStatus.OK);
    }
}
