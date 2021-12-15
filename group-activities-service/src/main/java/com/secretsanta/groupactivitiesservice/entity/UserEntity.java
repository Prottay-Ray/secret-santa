package com.secretsanta.groupactivitiesservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

        @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
        private List<WishlistItem> wishlistitem = new ArrayList<>();

//        @ManyToMany(mappedBy = "User")

        //for relation with grps
//changed
        @ManyToMany(fetch = FetchType.LAZY)
        private List<GroupEntity> groups = new ArrayList<>();

        public boolean addGroup(GroupEntity group) {
            return groups.add(group);
    }
}
