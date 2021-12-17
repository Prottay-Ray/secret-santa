package com.secretsanta.groupactivitiesservice.dto;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WishlistDTO {
    private Long wishListId;
    private String itemsName;
    private Double itemsPrice;
    private Integer priority;
}
