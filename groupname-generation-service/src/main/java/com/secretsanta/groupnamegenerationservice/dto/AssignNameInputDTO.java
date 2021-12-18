package com.secretsanta.groupnamegenerationservice.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssignNameInputDTO {

    private Long userId;
    private String groupName;

}
