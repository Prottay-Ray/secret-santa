package com.secretsanta.groupactivitiesservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    @Column(unique = true)
    private String groupName;
    private String groupTitle;
    private Date budgetDeadline;
    private Double budgetAmount;
    private Date wishlistDeadline;
    private Date dateOfCreation;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<WishlistItem> wishlist = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
    @JsonIgnore
    private List<UserEntity> users = new ArrayList<>();

    public Boolean addUser(UserEntity user) {
        return users.add(user);
    }

    public Boolean addWishlistItem(WishlistItem item) {
        return wishlist.add(item);
    }

    public void clearGroupObject() {

        users.clear();
        wishlist.clear();
        groupId = 0l;
        budgetDeadline = wishlistDeadline = null;
        groupTitle = groupName = "";
        budgetAmount = 0.0;

    }
}
