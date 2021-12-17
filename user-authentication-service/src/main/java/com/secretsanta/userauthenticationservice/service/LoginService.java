package com.secretsanta.userauthenticationservice.service;

import com.secretsanta.userauthenticationservice.dto.LoginInputDTO;
import com.secretsanta.userauthenticationservice.dto.SignupDTO;
import com.secretsanta.userauthenticationservice.entity.User;
import com.secretsanta.userauthenticationservice.exception.GroupNotFoundException;
import com.secretsanta.userauthenticationservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private ModelMapper modelMapper;

    public boolean UserLoginviaEmail(LoginEmailDTO loginEmailDTO) {

        boolean flag = false;
        String email = userRepository.getEmail();
        String password = userRepository.getPassword();

        if(email.equals(loginEmailDTO.getEmail()) && password.equals(loginEmailDTO.getPassword())) flag = true;

        return flag;

    }

    public boolean UserLoginviaUserName(LoginUserNameDTO loginUserNameDTO) {

        boolean flag = false;
        String userName = userRepository.getUserName();
        String password = userRepository.getPassword();

        if(userName.equals(loginUserNameDTO.getUserName()) && password.equals(loginUserNameDTO.getPassword())) flag = true;

        return flag;

    }

}
