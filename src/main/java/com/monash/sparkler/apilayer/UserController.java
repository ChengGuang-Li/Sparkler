package com.monash.sparkler.apilayer;


import com.monash.sparkler.entity.User;
import com.monash.sparkler.servicelayer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

   //User Post API
    @PostMapping
    public void resigterNewUser(@RequestBody User user){

        userService.addNewUser(user);
    }

    //User Delete API
    
    @DeleteMapping(path = "{userId}")
    public  void deleteUserByUid(@PathVariable("userId") Long id){
        userService.deleteUserByUid(id);
    }
   
    //User Update API
    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Long userId,
                           @RequestParam(required = false) String userName,
                           @RequestParam(required = false) String password,
                           @RequestParam(required = false) LocalDate dob,
                           @RequestParam(required = false) String email,
                           @RequestParam(required = false) String phoneNumber
                           ){

        userService.updateUser(userId,userName,password,dob,email,phoneNumber);

     }
}
