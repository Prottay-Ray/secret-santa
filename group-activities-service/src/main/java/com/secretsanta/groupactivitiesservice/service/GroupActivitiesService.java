package com.secretsanta.groupactivitiesservice.service;

import com.secretsanta.groupactivitiesservice.dto.*;
import com.secretsanta.groupactivitiesservice.entity.GroupEntity;

public interface GroupActivitiesService {

    GroupEntity createGroup(Long userId, GroupCreationDTO groupCreationDTO) throws Exception;

    String deleteGroup(Long groupId);

    Boolean joinGroup(Long userId, JoinGroupDTO joinGroupDTO);

    Boolean assignSanta(Long groupId);

    GiftReceivedDTO giftBestWay(Long groupId, Long userId);

    UserCreatedDTO createUser(UserDTO userDTO);

}
