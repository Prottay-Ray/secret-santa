package com.secretsanta.userauthenticationservice.dto;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data

public class LoginInputDTO {

    private Long Phone;

    private String Email;
    private String UserName;
}