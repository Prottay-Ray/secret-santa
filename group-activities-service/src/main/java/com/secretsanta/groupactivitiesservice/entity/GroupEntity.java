package com.secretsanta.groupactivitiesservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    private String groupName;
    private String groupTitle;
    private Date budgetDeadline;
    private Double budgetAmount;
    private Date wishlistDeadline;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
    @JsonIgnore
    private List<UserEntity> users = new ArrayList<>();

    public Boolean addUser(UserEntity user) {
        return users.add(user);
    }

    public void clearGroupObject() {

        users.clear();
        groupId = 0l;
        budgetDeadline = wishlistDeadline = null;
        groupTitle = groupName = "";
        budgetAmount = 0.0;

    }
}
