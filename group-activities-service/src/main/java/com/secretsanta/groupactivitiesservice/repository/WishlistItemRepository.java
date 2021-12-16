package com.secretsanta.groupactivitiesservice.repository;

import com.secretsanta.groupactivitiesservice.entity.UserEntity;
import com.secretsanta.groupactivitiesservice.entity.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistItemRepository extends JpaRepository <WishlistItem, Long> {

    List<WishlistItem> findWishlistItemsByGroup_GroupIdEquals(Long groupId);

    List<WishlistItem> findWishlistItemsBySantaUserIdEqualsAndGroup_GroupId(Long santaId, Long groupId);
}
