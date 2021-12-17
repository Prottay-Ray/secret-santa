package com.secretsanta.userauthenticationservice.dto;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data

public class LoginInputDTO {

    private Long phone;
    private String email;
    private String userName;
}
