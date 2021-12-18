package com.secretsanta.groupnamegenerationservice.service;

import com.secretsanta.groupnamegenerationservice.dto.*;
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

        List<GroupName> l = groupNameRepository.findAllByIsTakenEquals(false);
        if (l.size() > 0 && l.size() <= 100) groupNames.addAll(l);
        else if(l.size() > 0) l = l.subList(0, 100);
        for (int i = 0; i < 100-l.size(); i++) {
            String s = RandomStringUtils.random(20, true, true);
            if (groupNameRepository.findByGroupNameEquals(s).size() == 0) {
                GroupName groupName = new GroupName();
                groupName.setGroupName(s);
                groupName.setIsTaken(false);
                groupNames.add(groupName);
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

    public ReleaseNameOutputDTO releaseGroupName(AssignNameInputDTO nameInputDTO) {

        String nameInput = nameInputDTO.getGroupName();
        List<GroupName> g = groupNameRepository.findByGroupNameEquals(nameInput);
        g.get(0).setIsTaken(false);
        groupNameRepository.save(g.get(0));
        return new ReleaseNameOutputDTO(true);

    }
}
