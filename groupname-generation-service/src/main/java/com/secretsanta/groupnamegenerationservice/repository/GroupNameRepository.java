package com.secretsanta.groupnamegenerationservice.repository;

import com.secretsanta.groupnamegenerationservice.entity.GroupName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupNameRepository extends JpaRepository<GroupName, Long> {

    List<GroupName> findByGroupNameEquals(String isTaken);

    List<GroupName> findAllByIsTakenEquals(Boolean isTaken);
}
