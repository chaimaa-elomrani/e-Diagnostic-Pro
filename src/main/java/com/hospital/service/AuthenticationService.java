package com.hospital.service;

import com.hospital.dao.UserDao;
import com.hospital.entity.User;

import java.util.Optional;


public class AuthenticationService {

    private final UserDao userDao ;

    public AuthenticationService(UserDao userDao){
        this.userDao = userDao;
    }

    public Optional<User> login(String email , String password){

        Optional<User> Optionaluser = userDao.findByEmail(email);

        if(Optionaluser.isEmpty()){
            return Optional.empty();
        }

        User user = Optionaluser.get();

        if(!user.getPassword().equals(password)){
            return Optional.empty();
        }
        return Optional.of(user);
    }



}