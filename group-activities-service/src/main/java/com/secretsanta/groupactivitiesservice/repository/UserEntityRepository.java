package com.secretsanta.groupactivitiesservice.repository;

import com.secretsanta.groupactivitiesservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {


}
