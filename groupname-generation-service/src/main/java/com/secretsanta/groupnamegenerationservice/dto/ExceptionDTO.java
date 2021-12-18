package com.secretsanta.groupnamegenerationservice.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExceptionDTO {

    private Date timestamp;
    private String message;
    private String description;

}
