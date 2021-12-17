package com.secretsanta.userauthenticationservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignupDTO {

    private String password;
    private String userName;
    private Long phone;
    private String email;

}
