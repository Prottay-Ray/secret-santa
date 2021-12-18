package com.secretsanta.groupnamegenerationservice.service;

import com.secretsanta.groupnamegenerationservice.dto.AssignNameInputDTO;
import com.secretsanta.groupnamegenerationservice.dto.AssignNameOutputDTO;
import com.secretsanta.groupnamegenerationservice.dto.NameAvailableOutputDTO;
import com.secretsanta.groupnamegenerationservice.dto.RandomGroupNameDTO;
import com.secretsanta.groupnamegenerationservice.entity.GroupName;
import com.secretsanta.groupnamegenerationservice.repository.GroupNameRepository;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupNameService {

    @Autowired
    private GroupNameRepository groupNameRepository;

    private static List<GroupName> groupNames = new ArrayList<>();

    public RandomGroupNameDTO getGroupName() {
        if (groupNames.isEmpty()) generateNames();
        return new RandomGroupNameDTO(groupNames.get(0).getGroupName());
    }



    public void generateNames() {
        List<GroupName> l = groupNameRepository.findAllByIsTakenEquals(false).subList(0, 100);
        if (l.size() > 0) groupNames.addAll(l);
        for (int i = 0; i < 100-l.size(); i++) {
            String s = RandomStringUtils.random(20, true, true);
            if (groupNameRepository.findByGroupNameEquals(s).size() == 0) {
                GroupName groupName = new GroupName();
                groupName.setGroupName(s);
                groupName.setIsTaken(false);

            }
        }
    }

    public AssignNameOutputDTO assignGroupName(AssignNameInputDTO nameInputDTO) {

        String nameInput = nameInputDTO.getGroupName();
        NameAvailableOutputDTO dto = checkName(new RandomGroupNameDTO(nameInput));
        boolean isAssigned = false;
        if (dto.getIsAvailable()) {
            GroupName g;
            if (dto.getInList()) {
                g = groupNames.get(dto.getListIndex());
                groupNames.remove(g);
            } else if (dto.getGroupId() != -1L){
                g = groupNameRepository.findById(dto.getGroupId()).get();
            }
            else {
                g = new GroupName();
            }
            g.setGroupName(nameInput);
            g.setIsTaken(Boolean.TRUE);
            g.setUserId(nameInputDTO.getUserId());
            isAssigned = true;
            groupNameRepository.save(g);
        }
        return new AssignNameOutputDTO(isAssigned);
    }

    public NameAvailableOutputDTO checkName(RandomGroupNameDTO groupNameDTO) {

        Boolean available = Boolean.TRUE;
        boolean inList = Boolean.FALSE;
        int index = -1, i = 0;
        Long groupId = -1L;
        String name = groupNameDTO.getGroupName();
        List<GroupName> g = groupNameRepository.findByGroupNameEquals(name);
        if (g.size() > 0 && g.get(0).getIsTaken()) {
            available = Boolean.FALSE;
        } else if (g.size() > 0){
            groupId = g.get(0).getGroupId();
        } else {
            for (GroupName group :
                    groupNames) {
                if (group.getGroupName().equals(groupNameDTO.getGroupName())) {
                    inList = Boolean.TRUE;
                    index = i;
                    break;
                }
                i++;
            }
        }

        return new NameAvailableOutputDTO(available, inList, index, groupId);

    }
}
