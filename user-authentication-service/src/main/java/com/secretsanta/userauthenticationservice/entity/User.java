package com.secretsanta.userauthenticationservice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private Long phone;
    private String password;

    @Column(unique = true)
    private String email;
    private String userName;
}
