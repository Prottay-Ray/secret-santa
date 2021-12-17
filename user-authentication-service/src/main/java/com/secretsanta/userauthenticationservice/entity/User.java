package com.secretsanta.userauthenticationservice.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserId;

    private Long Phone;
    private String Password;

    @Column(unique = true)
    private String Email;
    private String UserName;

    public User(Long phone, String password, String email, String userName) {
        this.Phone=phone;
        this.Password=password;
        this.Email=email;
        this.UserName=userName;
    }
}
