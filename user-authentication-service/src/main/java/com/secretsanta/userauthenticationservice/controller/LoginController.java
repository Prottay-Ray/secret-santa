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
public class LoginController {


    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @PostMapping("/user-login/email")
    public boolean UserLoginviaEmail(@RequestBody LoginEmailDTO loginEmailDTO){
        boolean result = loginService.UserLoginviaEmail(loginEmailDTO);
        return result;
    }

    @PostMapping("/user-login/userName")
    public boolean UserLoginviaUserName(@RequestBody LoginUserNameDTO loginUserNameDTO){
        boolean result = loginService.UserLoginviaUserName(loginUserNameDTO);
        return result;
    }
}
