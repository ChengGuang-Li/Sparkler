package com.monash.sparkler.repository;

import com.monash.sparkler.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MembershipRepository extends JpaRepository<Membership,Integer> {

    @Query("SELECT m FROM Membership m WHERE m.m_name = :membershipName")
    Optional<Membership> findMembershipBymembershipName(@Param("membershipName") String membershipName);
}
