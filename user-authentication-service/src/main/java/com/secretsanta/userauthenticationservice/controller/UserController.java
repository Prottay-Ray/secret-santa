package com.secretsanta.userauthenticationservice.controller;

import com.secretsanta.userauthenticationservice.dto.LoginInputDTO;
import com.secretsanta.userauthenticationservice.dto.SignEmailDTO;
import com.secretsanta.userauthenticationservice.dto.SignupDTO;
import com.secretsanta.userauthenticationservice.service.UserService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //Mapping to enable user to sign up
    @PostMapping("/user-signup")
    public LoginInputDTO userSignUp(@RequestBody SignupDTO signup) throws Exception {
        return userService.userSignUp(signup);
    }

    //Mapping to enable user to sign in using email
    @PostMapping("/user-signin/email")
    public LoginInputDTO userSignEmail(@RequestBody SignEmailDTO signEmailDTO){
        return userService.userSignEmail(signEmailDTO);
    }

    //Mapping to enable user to sign in using username
    @PostMapping("/user-signin/username")
    public LoginInputDTO userSignUserName(@RequestBody SignEmailDTO signEmailDTO){
        return userService.userSignUserName(signEmailDTO);
    }
}
