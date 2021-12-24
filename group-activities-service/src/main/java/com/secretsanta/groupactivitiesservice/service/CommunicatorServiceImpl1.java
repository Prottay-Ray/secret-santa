package com.secretsanta.groupactivitiesservice.service;

import com.secretsanta.groupactivitiesservice.dto.AssignNameOutputDTO;
import com.secretsanta.groupactivitiesservice.dto.NameAvailableOutputDTO;
import com.secretsanta.groupactivitiesservice.dto.ReleaseNameOutputDTO;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class CommunicatorServiceImpl1 implements CommunicatorService {

    //This class is responsible for making all communications between
    //multiple microservices and transacting the required details
    //to and from the other parts of the service layer

    @Autowired
    private RestTemplate restTemplate;

    public String getUniqueGroupName() {

        return "";

    }

    public Boolean isGroupNameAvailable(String customName) throws JSONException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("groupName", customName);
        HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), headers);
        NameAvailableOutputDTO createdDTO = restTemplate.postForObject("http://groupname-generation-service/groupname/check", request, NameAvailableOutputDTO.class);

        assert createdDTO != null;
        return createdDTO.getIsAvailable();

    }

    public Boolean assignGroupName(Long userId, String groupName) throws JSONException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", userId);
        jsonObject.put("groupName", groupName);
        HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), headers);
        AssignNameOutputDTO createdDTO = restTemplate.postForObject("http://groupname-generation-service/groupname/assign", request, AssignNameOutputDTO.class);

        assert createdDTO != null;
        return createdDTO.getIsAssigned();
    }

    public Boolean releaseGroupName(String groupName) throws JSONException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", "");
        jsonObject.put("groupName", groupName);
        HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), headers);
        ReleaseNameOutputDTO createdDTO = restTemplate.postForObject("http://groupname-generation-service/groupname/release", request, ReleaseNameOutputDTO.class);

        assert createdDTO != null;
        return createdDTO.getIsReleased();
    }

}
