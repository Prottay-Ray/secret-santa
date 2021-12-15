package com.secretsanta.groupactivitiesservice.dto;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupCreationDTO {

    private String groupName;
    private String groupTitle;
    private String budgetDeadline;
    private String wishlistDeadline;
    private Double budgetAmount;

}
