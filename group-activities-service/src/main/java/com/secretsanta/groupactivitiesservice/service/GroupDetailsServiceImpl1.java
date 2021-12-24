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
public class GroupDetailsServiceImpl1 implements GroupDetailsService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ModelMapper modelMapper;


    public GroupDisplayDTO getAllGroupDetails(Long groupId) {
        Optional<GroupEntity> groupDetails=groupRepository.findById(groupId);

        if(groupDetails.isEmpty()){
            throw new GroupNotFoundException("Group not found");

        }

        GroupDisplayDTO groupDisplayDTO=new GroupDisplayDTO();
        modelMapper.map(groupDetails.get(),groupDisplayDTO);
        return groupDisplayDTO;

    }
}
