package com.monash.sparkler.servicelayer;


import com.monash.sparkler.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository){
        this.serviceRepository = serviceRepository;
    }

    public List<com.monash.sparkler.entity.Service> getAllServices(){
        return serviceRepository.findAll();
    }




}
