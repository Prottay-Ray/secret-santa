package com.secretsanta.groupactivitiesservice.service;

public class CommunicatorService {

    //This class is responsible for making all communications between
    //multiple microservices and transacting the required details
    //to and from the other parts of the service layer

    public String getUniqueGroupName() {

        return "";

    }

    public Boolean isGroupNameAvailable(String customName) {

        return false;

    }

    public Boolean assignGroupName(String groupName) {

        if (isGroupNameAvailable("dfdf"))
        return true;
        return false;
    }

}
