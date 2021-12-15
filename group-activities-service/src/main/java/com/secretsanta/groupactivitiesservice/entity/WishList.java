package com.secretsanta.groupactivitiesservice.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishListId;
    private String itemsName;
    private double itemsPrice;
    private int Priority;
    private UserEntity Santa;

}

