package com.monash.sparkler.servicelayer;

import com.monash.sparkler.repository.UserRepository;
import com.monash.sparkler.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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


    public void addNewUser(User user) {

        //check user name is taken or not
        Optional<User> userByUserName = userRepository.findUsersByUserName(user.getUserName());
        if(userByUserName.isPresent()){

            throw new IllegalStateException("User Name is taken");
        }

        //if user name is not taken, user will be saved
        userRepository.save(user);
    }

    public void deleteUserByUid(Long id) {

        boolean userExist = userRepository.existsById(id);
        if(userExist){

            userRepository.deleteById(id);
        }else{

            throw new IllegalStateException("user with id" + id + "does not exists!!");
        }
    }

    @Transactional
    public void updateUser(Long userId, String userName,String password, LocalDate dob, String email, String phoneNumber) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException(" user with id" + userId + "does not exist"));

        if(userName != null && userName.length() > 0 && !Objects.equals(user.getUserName(),userName)){

            Optional<User> userOptional = userRepository.findUsersByUserName(userName);
            if(userOptional.isPresent()){
                throw new IllegalStateException("user name is taken");
            }

            user.setUserName(userName);
        }

        if(email != null && email.length() > 0 && !Objects.equals(user.getEmail(),email)){
            Optional<User> userOptional = userRepository.findUsersByEmail(email);
            if(userOptional.isPresent()){

               throw new IllegalStateException("email is taken");
            }
            user.setEmail(email);
        }

        if(phoneNumber != null && phoneNumber.length() > 0 && !Objects.equals(phoneNumber,user.getPhoneNumber())){
           user.setPhoneNumber(phoneNumber);
        }

        if(password != null && password.length() > 0 && !Objects.equals(password,user.getPassword())){

            user.setPassword(password);
        }

        if(dob != null && !Objects.equals(dob,user.getDob())){
            user.setDob(dob);
        }


    }
}
