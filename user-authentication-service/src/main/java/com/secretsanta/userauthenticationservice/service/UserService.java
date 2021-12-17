package com.secretsanta.userauthenticationservice.service;

import com.secretsanta.userauthenticationservice.dto.LoginInputDTO;
import com.secretsanta.userauthenticationservice.dto.SignupDTO;
import com.secretsanta.userauthenticationservice.entity.User;
import com.secretsanta.userauthenticationservice.exception.GroupNotFoundException;
import com.secretsanta.userauthenticationservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public LoginInputDTO UserSignUp(@RequestBody SignupDTO signupdto) {

        User user1=new User();


        user1.setUserName(signupdto.getUserName());
        user1.setEmail(signupdto.getEmail());
        user1.setPassword(signupdto.getPassword());
        user1.setPhone(signupdto.getPhone());

        userRepository.save(user1);

        //userRepository.save(user1);

        LoginInputDTO loginInputDTO=new LoginInputDTO();
        modelMapper.map(user1,loginInputDTO);

        return loginInputDTO;

    }

}
