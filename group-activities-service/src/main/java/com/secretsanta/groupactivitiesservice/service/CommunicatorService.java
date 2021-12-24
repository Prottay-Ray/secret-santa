package com.secretsanta.groupactivitiesservice.service;

import org.json.JSONException;

public interface CommunicatorService {

    Boolean isGroupNameAvailable(String customName) throws JSONException;

    Boolean assignGroupName(Long userId, String groupName) throws JSONException;

    Boolean releaseGroupName(String groupName) throws JSONException;


}
