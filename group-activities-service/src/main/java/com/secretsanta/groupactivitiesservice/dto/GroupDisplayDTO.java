package com.secretsanta.groupactivitiesservice.dto;

import com.secretsanta.groupactivitiesservice.entity.UserEntity;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class GroupDisplayDTO {
//    private Long groupId;
    private String groupName;
    private String groupTitle;
    private String budgetDeadline;
    private String wishlistDeadline;
    private Double budgetAmount;
    private Date dateOfCreation;
    private List<UserEntity> users;
}
