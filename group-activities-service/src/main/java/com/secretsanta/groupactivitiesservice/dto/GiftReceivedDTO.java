package com.secretsanta.groupactivitiesservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
public class GiftReceivedDTO {

    private String Santa;
    private String giftRecipient;
    List<WishlistItemDTO> giftList = new ArrayList<>();

}
