package com.secretsanta.userauthenticationservice.service;

import com.secretsanta.userauthenticationservice.dto.LoginInputDTO;
import com.secretsanta.userauthenticationservice.dto.SignEmailDTO;
import com.secretsanta.userauthenticationservice.dto.SignupDTO;

public interface UserService {

    LoginInputDTO userSignUp(SignupDTO signupdto) throws Exception;

    LoginInputDTO userSignEmail(SignEmailDTO signEmailDTO);

    LoginInputDTO userSignUserName(SignEmailDTO signEmailDTO);

}
