package com.secretsanta.groupactivitiesservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private String UserName;
    private long UserId;
    @OneToMany(mappedBy="User")

    //list of wishlist items
    private List<wishlistItem> wishlistitem =new ArrayList<>();

    @ManyToMany(mappedBy = "User")

    //for relation with grps

    private List<Groups> groups=new ArrayList<>();
}
