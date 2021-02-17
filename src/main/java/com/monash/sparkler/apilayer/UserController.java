package com.monash.sparkler.apilayer;


import com.monash.sparkler.entity.User;
import com.monash.sparkler.servicelayer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "sparkler/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //User GET API
   @GetMapping
    public List<User> getAllUsers(){

     return userService.getUsers();
   }

}
