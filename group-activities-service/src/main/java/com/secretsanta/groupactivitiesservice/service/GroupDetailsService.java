package com.secretsanta.groupactivitiesservice.service;

import com.secretsanta.groupactivitiesservice.dto.GroupDisplayDTO;

public interface GroupDetailsService {

    GroupDisplayDTO getAllGroupDetails(Long groupId);

}
