package com.secretsanta.groupactivitiesservice.entity;

import lombok.*;

import javax.persistence.*;


@Entity(name = "wishlistitems")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WishlistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishListId;
    private String itemsName;
    private double itemsPrice;
    private Boolean isGifted;
    private int Priority;

    @ManyToOne
    private GroupEntity group;

    @ManyToOne
    private UserEntity Santa;

    @ManyToOne
    private UserEntity user;

}

