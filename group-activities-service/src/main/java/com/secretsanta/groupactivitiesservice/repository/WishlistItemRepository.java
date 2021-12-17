package com.secretsanta.groupactivitiesservice.repository;

import com.secretsanta.groupactivitiesservice.entity.UserEntity;
import com.secretsanta.groupactivitiesservice.entity.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistItemRepository extends JpaRepository <WishlistItem, Long> {

//    List<WishlistItem> findWishlistItemsByGroup_GroupIdEquals(Long groupId);

   @Query("SELECT W FROM wishlistitems W WHERE W.Santa.userId = :santaId AND W.group.groupId = :groupId")
   List<WishlistItem> findWishlistItemsForSantaInGroup(@Param("santaId") Long santaId, @Param("groupId") Long groupId);
}
