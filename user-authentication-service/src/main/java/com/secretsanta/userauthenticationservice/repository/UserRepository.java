package com.secretsanta.userauthenticationservice.repository;

import com.secretsanta.userauthenticationservice.dto.LoginInputDTO;
import com.secretsanta.userauthenticationservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //this is for checking if email and password is a match and list of the user where it matches
    @Query("SELECT W FROM User W WHERE W.email = :userEmail AND W.password = :userPassword")
    List<User> findmatchsignupemail(@Param("userEmail") String userEmail, @Param("userPassword") String userPassword);

    //this is for checking if username and password is a match and list of the user where it matches

    @Query("SELECT W FROM User W WHERE W.userName =:userName And W.password = :userPassword")
    List<User> findMatchSignInViaUserName(@Param("userName") String userName,@Param("userPassword") String userPassword);

}