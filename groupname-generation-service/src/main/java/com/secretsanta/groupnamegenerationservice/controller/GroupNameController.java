package com.secretsanta.groupnamegenerationservice.controller;

import com.secretsanta.groupnamegenerationservice.dto.*;
import com.secretsanta.groupnamegenerationservice.service.GroupNameService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupNameController {

    @Autowired
    private GroupNameService groupNameService;

    //Sends a random generated not taken groupname from list
    @GetMapping("/groupname/generate/random")
    public ResponseEntity<RandomGroupNameDTO> getGroupName() {
        return new ResponseEntity<>(groupNameService.getGroupName(), HttpStatus.OK);
    }

    //Checks if our groupname is unique or taken
    @PostMapping("/groupname/check")
    public ResponseEntity<NameAvailableOutputDTO> checkName(@RequestBody RandomGroupNameDTO groupNameDTO) {
        return new ResponseEntity<>(groupNameService.checkName(groupNameDTO), HttpStatus.FOUND);
    }

    //Assigns a group id if it is not taken
    @PostMapping("/groupname/assign")
    public ResponseEntity<AssignNameOutputDTO> assignGroupName(@RequestBody AssignNameInputDTO nameInputDTO) {
        return new ResponseEntity<>(groupNameService.assignGroupName(nameInputDTO), HttpStatus.CREATED);
    }

    //releases a group id if it is not taken
    @PostMapping("/groupname/release")
    public ResponseEntity<ReleaseNameOutputDTO> releaseGroupName(@RequestBody AssignNameInputDTO nameInputDTO) {
        return new ResponseEntity<>(groupNameService.releaseGroupName(nameInputDTO), HttpStatus.CREATED);
    }
}
