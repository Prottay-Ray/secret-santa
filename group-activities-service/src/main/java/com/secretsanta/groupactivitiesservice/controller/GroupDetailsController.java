package com.secretsanta.groupactivitiesservice.controller;

import com.secretsanta.groupactivitiesservice.dto.GroupDisplayDTO;
import com.secretsanta.groupactivitiesservice.service.GroupDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")

public class GroupDetailsController {
    @Autowired
    private GroupDetailsService groupDetailsService;

    //to display all the groups details of a user
    @GetMapping("/group/details/{groupId}")
    public ResponseEntity<GroupDisplayDTO> getAllGroupDetails(@PathVariable Long groupId){
        GroupDisplayDTO display = groupDetailsService.getAllGroupDetails(groupId);
        return new ResponseEntity<>(display, HttpStatus.ACCEPTED);
    }
}
