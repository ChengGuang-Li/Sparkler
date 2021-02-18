package com.monash.sparkler.repository;

import com.monash.sparkler.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ServiceRepository  extends JpaRepository<Service,Integer> {

    @Query("SELECT s FROM Service s WHERE s.s_name = :serviceName")
    Optional<Service> findServiceByserviceName(@Param("serviceName") String serviceName);


}
