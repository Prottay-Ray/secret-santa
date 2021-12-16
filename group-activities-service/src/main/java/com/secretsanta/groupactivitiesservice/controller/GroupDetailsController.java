package com.secretsanta.groupactivitiesservice.controller;

import com.secretsanta.groupactivitiesservice.dto.GroupDisplayDTO;
import com.secretsanta.groupactivitiesservice.entity.GroupEntity;
import com.secretsanta.groupactivitiesservice.service.GroupDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController

public class GroupDetailsController {
    @Autowired
    private GroupDetailsService groupDetailsService;

    @GetMapping("/group/create/{grpId}")
    public ResponseEntity<GroupDisplayDTO> getAllGrpDetails(@PathVariable Long grpId){
        GroupDisplayDTO displaygrp = groupDetailsService.getAllGrpDetails(grpId);
        return new ResponseEntity<>(displaygrp, HttpStatus.ACCEPTED);
    }
}
