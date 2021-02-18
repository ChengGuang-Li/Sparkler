package com.monash.sparkler.repository;

import com.monash.sparkler.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

//Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //find user by user name

    @Query("SELECT u FROM User u WHERE u.userName = :userName")
    Optional<User> findUsersByUserName(@Param("userName") String userName);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findUsersByEmail(@Param("email") String email);
}
