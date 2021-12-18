package com.secretsanta.userauthenticationservice.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data

public class SignEmailDTO {
    private String password;
    private String userName;

    private String email;
}
