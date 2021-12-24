package com.secretsanta.groupactivitiesservice.service;

import com.secretsanta.groupactivitiesservice.dto.GiftCheckDTO;
import com.secretsanta.groupactivitiesservice.dto.WishlistCheckDTO;
import com.secretsanta.groupactivitiesservice.entity.GroupEntity;

import java.util.List;

public interface WishListActivitiesService {

    List<GroupEntity> participantOfGroup(Long userId);

    List<WishlistCheckDTO> isGifted(Long userId, Long groupId, GiftCheckDTO giftCheckDTO);

}
