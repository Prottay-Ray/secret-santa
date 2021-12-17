package com.secretsanta.userauthenticationservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data

public class SignupDTO {
    private String Password;
    private String UserName;
    private Long Phone;
    private String Email;
}
