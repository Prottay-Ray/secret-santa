package com.secretsanta.groupactivitiesservice.service;

import com.secretsanta.groupactivitiesservice.dto.GroupDisplayDTO;
import com.secretsanta.groupactivitiesservice.entity.GroupEntity;
import com.secretsanta.groupactivitiesservice.exception.GroupNotFoundException;
import com.secretsanta.groupactivitiesservice.repository.GroupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupDetailsService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupEntity group;
    @Autowired
    private ModelMapper modelMapper;


    public GroupDisplayDTO getAllGrpDetails(Long grpId) {
        Optional<GroupEntity> groupdetails=groupRepository.findById(grpId);

        if(groupdetails.isEmpty()){
            throw new GroupNotFoundException("Group not found");

        }

        GroupDisplayDTO groupDisplayDTO=new GroupDisplayDTO();
        modelMapper.map(groupdetails.get(),groupDisplayDTO);
        return groupDisplayDTO;

    }
}
