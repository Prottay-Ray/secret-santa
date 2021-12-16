package com.secretsanta.groupactivitiesservice.dto;

import com.secretsanta.groupactivitiesservice.entity.UserEntity;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GiftDTO {

    private Long groupId;
    private Long userId;
    private List<WishlistItemDTO> wishlist;

}
