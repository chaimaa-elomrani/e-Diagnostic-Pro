package com.hospital.service;

import com.hospital.dao.UserDao;
import com.hospital.entity.User;
import com.hospital.enums.Role;
import com.hospital.security.PasswordHasher;

import java.util.Optional;


public class AuthenticationService {

    private final UserDao userDao ;

    public AuthenticationService(UserDao userDao){
        this.userDao = userDao;
    }

    public Optional<User> login(String email , String password){

        Optional<User> foundUser = userDao.findByEmail(email);

        if(foundUser.isEmpty()){
            return Optional.empty();
        }
        User user = foundUser.get();

        if(!PasswordHasher.matches(password, user.getPassword())){
            return Optional.empty();
        }
        return Optional.of(user);
    }



    public boolean signUp(
            String name ,
            String email ,
            String password ,
            Role role){

        if(userDao.findByEmail(email).isPresent()){
            return false;
        }

        if(name == null || name.isBlank()
                || email == null || email.isBlank()
                ||password == null || password.isBlank()
                 ||role == null || name.isBlank()){
            return false ;
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(PasswordHasher.hash(password));
        user.setRole(role);

        return userDao.save(user);

    }


}