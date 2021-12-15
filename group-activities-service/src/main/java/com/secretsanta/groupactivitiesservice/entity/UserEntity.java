package com.secretsanta.groupactivitiesservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class UserEntity {

        @Id
        private long userId;
        private String UserName;
        @OneToMany(mappedBy="User")

        //list of wishlist items
        private List<WishlistItem> wishlistitem = new ArrayList<>();

        @ManyToMany(mappedBy = "User")

        //for relation with grps
//changed
        private List<GroupEntity> groups = new ArrayList<>();
    }
}
