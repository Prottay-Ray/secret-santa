package com.secretsanta.groupactivitiesservice.repository;

import com.secretsanta.groupactivitiesservice.entity.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistItemRepository extends JpaRepository <WishlistItem, Long> {
}
