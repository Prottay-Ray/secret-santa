package com.secretsanta.groupactivitiesservice.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WishlistCheckDTO {

    private String itemsName;
    private Double itemsPrice;
    private Integer priority;
    private Boolean isGifted;

}
