package com.secretsanta.userauthenticationservice.controller;

import com.secretsanta.userauthenticationservice.dto.LoginInputDTO;
import com.secretsanta.userauthenticationservice.dto.SignupDTO;
import com.secretsanta.userauthenticationservice.entity.User;
import com.secretsanta.userauthenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/user-signup")
            //make request body dto with everything other that userid
    public LoginInputDTO UserSignUp(@RequestBody SignupDTO signup){
        LoginInputDTO useradded=userService.UserSignUp(signup);
        return useradded;
    }
}
