package com.hospital.dao;

import com.hospital.entity.User;
import com.hospital.enums.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;


public class UserDao {

    private final EntityManager entityManager ;

    public UserDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public boolean save(User user){
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


    public Optional<User> findByEmail(String email){
        List<User> users = entityManager
                .createQuery("select u from User u where u.email = :email",
                        User.class)
                .setParameter("email", email)
                .getResultList();
        if(users.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(users.get(0));
    }


    public Optional<User> findById(Long id ){
        List<User> users = entityManager
                .createQuery("select u from User u where u.id= :id",
                        User.class)
                .setParameter("id", id)
                .getResultList();

        if(users.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(users.get(0));
    }

    public List<User> findByRole(Role role){
        return  entityManager
                .createQuery("select u from User u where u.role = :role",
                        User.class)
                .setParameter("role", role)
                .getResultList();

    }

    public List<User> findAll(){
        return  entityManager
                .createQuery("select u from User u ",
                        User.class)
                .getResultList();

    }




}