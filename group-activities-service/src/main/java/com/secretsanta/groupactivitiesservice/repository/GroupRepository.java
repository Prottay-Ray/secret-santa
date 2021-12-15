package com.secretsanta.groupactivitiesservice.repository;

import com.secretsanta.groupactivitiesservice.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
}
