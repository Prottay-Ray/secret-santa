package com.secretsanta.groupactivitiesservice.dto;

import lombok.*;

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
