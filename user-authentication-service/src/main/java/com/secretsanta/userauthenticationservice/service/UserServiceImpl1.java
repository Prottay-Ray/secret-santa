package com.secretsanta.userauthenticationservice.service;

import com.secretsanta.userauthenticationservice.dto.LoginInputDTO;
import com.secretsanta.userauthenticationservice.dto.SignEmailDTO;
import com.secretsanta.userauthenticationservice.dto.SignupDTO;
import com.secretsanta.userauthenticationservice.dto.UserCreatedDTO;
import com.secretsanta.userauthenticationservice.entity.User;
import com.secretsanta.userauthenticationservice.exception.UserCreationFailedException;
import com.secretsanta.userauthenticationservice.exception.UserDoesNotExistException;
import com.secretsanta.userauthenticationservice.repository.UserRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class UserServiceImpl1 implements UserService{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String isValidEmail(String email) {
        int at = email.indexOf('@');
        if (at < 5) return "Your email has less than 6 characters before @ sign";
        if (at != email.lastIndexOf('@')) return "Your email has 2 @ signs.";
        if(email.lastIndexOf('.') < at) return "Invalid domain name.";
        if(Character.isDigit(email.charAt(0))) return "A valid email cannot start with a digit.";
        return "";
    }

    public Boolean isValidMobile(String number) {

        Pattern mobNoPattern = Pattern.compile("[5-9][0-9]{9}");

        Matcher mobNoMatcher = mobNoPattern.matcher(number);
        return (mobNoMatcher.find() && mobNoMatcher.group().equals(number));

    }

    public LoginInputDTO userSignUp(SignupDTO signupdto) throws JSONException {

        User user1 = new User();



        user1.setUserName(signupdto.getUserName());
        user1.setEmail(signupdto.getEmail());
        user1.setPassword(signupdto.getPassword());
        user1.setPhone(signupdto.getPhone());

        userRepository.save(user1);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", user1.getUserId());
        jsonObject.put("userName", user1.getUserName());
        HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), headers);
        UserCreatedDTO createdDTO = restTemplate.postForObject("http://group-activities-service/group/create/user", request, UserCreatedDTO.class);
        assert createdDTO != null;
        if (!createdDTO.getIsCreated()) throw new UserCreationFailedException("Some error occured. User could not be created.");
        LoginInputDTO loginInputDTO = new LoginInputDTO();
        modelMapper.map(user1, loginInputDTO);

        return loginInputDTO;

    }

    public LoginInputDTO userSignEmail(SignEmailDTO signEmailDTO) {

        List<User> findIfMatchViaEmail= userRepository.findmatchsignupemail(signEmailDTO.getEmail(), signEmailDTO.getPassword());

        if (findIfMatchViaEmail.size() > 0) {
            LoginInputDTO result = new LoginInputDTO();
            modelMapper.map(findIfMatchViaEmail.get(0), result);
            return result;
        }

        else throw new UserDoesNotExistException("Something is incorrect");

    }


    public LoginInputDTO userSignUserName(SignEmailDTO signEmailDTO) {
        List<User> findIfMatchViaUserName = userRepository.findMatchSignInViaUserName(signEmailDTO.getUserName(),signEmailDTO.getPassword());

        if(findIfMatchViaUserName.size()>0){
            LoginInputDTO resultViaUserName=new LoginInputDTO();
            modelMapper.map(findIfMatchViaUserName.get(0),resultViaUserName);
            return resultViaUserName;
        }
        else throw new UserDoesNotExistException("Something is incorrect");
    }
}