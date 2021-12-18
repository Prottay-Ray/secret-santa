package com.secretsanta.groupnamegenerationservice.controller;

import com.secretsanta.groupnamegenerationservice.dto.AssignNameInputDTO;
import com.secretsanta.groupnamegenerationservice.dto.AssignNameOutputDTO;
import com.secretsanta.groupnamegenerationservice.dto.NameAvailableOutputDTO;
import com.secretsanta.groupnamegenerationservice.dto.RandomGroupNameDTO;
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

    @GetMapping("/groupname/generate/random")
    public ResponseEntity<RandomGroupNameDTO> getGroupName() {
        return new ResponseEntity<>(groupNameService.getGroupName(), HttpStatus.OK);
    }

    @PostMapping("/groupname/check")
    public ResponseEntity<NameAvailableOutputDTO> checkName(@RequestBody RandomGroupNameDTO groupNameDTO) {
        return new ResponseEntity<>(groupNameService.checkName(groupNameDTO), HttpStatus.FOUND);
    }

    @PostMapping("/groupname/assign")
    public ResponseEntity<AssignNameOutputDTO> assignGroupName(@RequestBody AssignNameInputDTO nameInputDTO) {
        return new ResponseEntity<>(groupNameService.assignGroupName(nameInputDTO), HttpStatus.CREATED);
    }
}
