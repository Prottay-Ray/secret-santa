package com.secretsanta.groupactivitiesservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class CommunicatorService {

    //This class is responsible for making all communications between
    //multiple microservices and transacting the required details
    //to and from the other parts of the service layer

    @Autowired
    private RestTemplate restTemplate;

    public String getUniqueGroupName() {

        return "";

    }

    public Boolean isGroupNameAvailable(String customName) {

        return true;

    }

    public Boolean assignGroupName(String groupName) {

        return true;
    }

}
