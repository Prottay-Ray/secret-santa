package com.secretsanta.userauthenticationservice.controller;

import com.secretsanta.userauthenticationservice.dto.LoginInputDTO;
import com.secretsanta.userauthenticationservice.dto.SignEmailDTO;
import com.secretsanta.userauthenticationservice.dto.SignupDTO;
import com.secretsanta.userauthenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/user-signup")
            //make request body dto with everything other that userid
    public LoginInputDTO userSignUp(@RequestBody SignupDTO signup){
        LoginInputDTO userAdded=userService.userSignUp(signup);
        return userAdded;
    }

    @PostMapping("/user-signin/email")
    public LoginInputDTO userSignEmail(@RequestBody SignEmailDTO signEmailDTO){
        LoginInputDTO userSignInEmail=userService.userSignEmail(signEmailDTO);
        return userSignInEmail;
    }


    @PostMapping("/user-signin/username")
    public LoginInputDTO userSignUserName(@RequestBody SignEmailDTO signEmailDTO){
        LoginInputDTO userSignInUserName=userService.userSignUserName(signEmailDTO);
        return userSignInUserName;
    }
}
