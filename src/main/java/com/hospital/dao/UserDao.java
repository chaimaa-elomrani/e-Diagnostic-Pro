package com.hospital.dao;

import com.hospital.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;


public class UserDao {

    private final EntityManager entityManager ;

    public UserDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public boolean addUser(User user){
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
            return true ;
        } catch (RuntimeException e) {
            if(transaction.isActive()){
                transaction.rollback();
            }
            return false ;
        }
    }


    public User findByEmail(String email){
        List<User> users = entityManager
                .createQuery("select u from users where email = :email",
                        User.class)
                .setParameter("email", email)
                .getResultList();
        if(users.isEmpty()){
            return null ;
        }
        return users.get(0);
    }


}