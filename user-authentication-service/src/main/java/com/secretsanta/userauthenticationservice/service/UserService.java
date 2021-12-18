package com.secretsanta.userauthenticationservice.service;

import com.secretsanta.userauthenticationservice.dto.LoginInputDTO;
import com.secretsanta.userauthenticationservice.dto.SignEmailDTO;
import com.secretsanta.userauthenticationservice.dto.SignupDTO;
import com.secretsanta.userauthenticationservice.entity.User;
import com.secretsanta.userauthenticationservice.exception.UserDoesNotExistException;
import com.secretsanta.userauthenticationservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public LoginInputDTO userSignUp(@RequestBody SignupDTO signupdto) {

        User user1 = new User();


        user1.setUserName(signupdto.getUserName());
        user1.setEmail(signupdto.getEmail());
        user1.setPassword(signupdto.getPassword());
        user1.setPhone(signupdto.getPhone());

        userRepository.save(user1);

        //userRepository.save(user1);

        LoginInputDTO loginInputDTO = new LoginInputDTO();
        modelMapper.map(user1, loginInputDTO);

        return loginInputDTO;

    }

    public LoginInputDTO userSignEmail(SignEmailDTO signEmailDTO) {
        //  if(userRepository.getById(signInEmailDTO.getEmail())signInEmailDTO.getEmail())

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