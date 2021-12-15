package com.secretsanta.groupactivitiesservice.controller;

import com.secretsanta.groupactivitiesservice.dto.GroupCreationDTO;
import com.secretsanta.groupactivitiesservice.dto.JoinGroupDTO;
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
    public ResponseEntity<GroupCreationDTO> createGroup(@PathVariable Long userId, @RequestBody GroupCreationDTO groupCreationDTO) throws Exception {
        GroupCreationDTO groupCreationDTO1 = groupActivitiesService.createGroup(userId, groupCreationDTO);
        return new ResponseEntity<>(groupCreationDTO1, HttpStatus.CREATED);
    }

    //Delete a group
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

}
