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

    @PostMapping("/user-signup")
            //make request body dto with everything other that userid
    public LoginInputDTO userSignUp(@RequestBody SignupDTO signup) throws JSONException {
        return userService.userSignUp(signup);
    }

    @PostMapping("/user-signin/email")
    public LoginInputDTO userSignEmail(@RequestBody SignEmailDTO signEmailDTO){
        return userService.userSignEmail(signEmailDTO);
    }


    @PostMapping("/user-signin/username")
    public LoginInputDTO userSignUserName(@RequestBody SignEmailDTO signEmailDTO){
        return userService.userSignUserName(signEmailDTO);
    }
}
