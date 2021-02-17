package com.monash.sparkler.repository;

import com.monash.sparkler.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
