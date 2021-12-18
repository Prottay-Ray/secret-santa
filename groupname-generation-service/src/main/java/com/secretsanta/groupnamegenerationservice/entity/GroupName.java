package com.secretsanta.groupnamegenerationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "groupname")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    // Randomly generated groupName has length 20
    private String groupName;
    private Boolean isTaken;
    private Long userId;

}
