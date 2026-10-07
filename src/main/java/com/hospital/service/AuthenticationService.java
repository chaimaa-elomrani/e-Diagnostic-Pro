package com.hospital.service;

import com.hospital.dao.UserDao;
import com.hospital.entity.User;
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



}