package com.secretsanta.groupactivitiesservice.controller;

import com.secretsanta.groupactivitiesservice.dto.*;
import com.secretsanta.groupactivitiesservice.entity.GroupEntity;
import com.secretsanta.groupactivitiesservice.service.GroupActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class GroupActivitiesController {

    @Autowired
    private GroupActivitiesService groupActivitiesService;

    //Create a Group by an user
    @PostMapping("/group/create/{userId}")
    public ResponseEntity<GroupEntity> createGroup(@PathVariable Long userId, @RequestBody GroupCreationDTO groupCreationDTO) throws Exception {
        GroupEntity groupCreationDTO1 = groupActivitiesService.createGroup(userId, groupCreationDTO);
        return new ResponseEntity<>(groupCreationDTO1, HttpStatus.CREATED);
    }

    //Delete a group by groupId
    @DeleteMapping("/group/{groupId}")
    public ResponseEntity<String> deleteGroup(@PathVariable Long groupId) {
        return new ResponseEntity<>(groupActivitiesService.deleteGroup(groupId), HttpStatus.OK);
    }

    //User joins a group
    @PutMapping("/group/join/{userId}")
    public ResponseEntity<Boolean> joinGroup(@PathVariable Long userId, @RequestBody JoinGroupDTO joinGroupDTO) {
        return new ResponseEntity<>(groupActivitiesService.joinGroup(userId, joinGroupDTO), HttpStatus.OK);
    }

    //System assigns santa to every user
    @GetMapping("/group/assign-santa/{groupId}")
    public ResponseEntity<Boolean> assignSanta(@PathVariable Long groupId) {
        return new ResponseEntity<>(groupActivitiesService.assignSanta(groupId), HttpStatus.OK);
    }

    //Santa gifts the best way within group budget
    @PutMapping("/group/{groupId}/santa/{santaId}/gift")
    public ResponseEntity<GiftReceivedDTO> giftBestWay(@PathVariable Long groupId, @PathVariable Long santaId) {
        return new ResponseEntity<>(groupActivitiesService.giftBestWay(groupId, santaId), HttpStatus.OK);
    }

    //Create a user by User Auth microservice
    @PostMapping("/group/create/user")
    public ResponseEntity<UserCreatedDTO> createUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(groupActivitiesService.createUser(userDTO), HttpStatus.CREATED);
    }
}
