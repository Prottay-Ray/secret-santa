package com.secretsanta.groupactivitiesservice.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WishlistItemDTO {

    private String itemsName;
    private Double itemsPrice;
    private Integer priority;

}
