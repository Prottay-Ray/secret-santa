package com.secretsanta.groupactivitiesservice.entity;

import com.secretsanta.groupactivitiesservice.dto.WishlistDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

    @Entity(name = "users")
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


        @ManyToMany(fetch = FetchType.LAZY)
        private List<GroupEntity> groups = new ArrayList<>();

        public boolean addGroup(GroupEntity group) {
            return groups.add(group);
        }

        public boolean removeGroup(GroupEntity group) {
            return groups.remove(group);
        }

        public boolean addWishlistItem(WishlistItem item) {
            return wishlistitem.add(item);
        }

        public boolean removeWishlist(WishlistItem item) {
            return wishlistitem.remove(item);
        }
     //public boolean addWishlist(WishlistDTO wishlist){return wishlistitem.add(wishlist);}
}
