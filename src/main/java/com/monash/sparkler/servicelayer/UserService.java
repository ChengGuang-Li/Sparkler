package com.monash.sparkler.servicelayer;

import com.monash.sparkler.repository.UserRepository;
import com.monash.sparkler.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){

      return userRepository.findAll();
    }



}
