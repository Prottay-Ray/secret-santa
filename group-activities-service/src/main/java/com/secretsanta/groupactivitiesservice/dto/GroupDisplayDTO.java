package com.secretsanta.groupactivitiesservice.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class GroupDisplayDTO {
    private Long groupId;
    private String groupName;
  //  private String groupTitle;
    private String budgetDeadline;
    private String wishlistDeadline;
    private Double budgetAmount;
}
