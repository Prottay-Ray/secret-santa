package com.secretsanta.groupactivitiesservice.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WishlistItemDTO {

    private String itemsName;
    private double itemsPrice;
    private int Priority;

}
