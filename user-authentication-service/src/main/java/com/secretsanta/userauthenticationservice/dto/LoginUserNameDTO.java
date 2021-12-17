package com.secretsanta.userauthenticationservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class SignupDTO {
    private String Password;
    private String UserName;
}