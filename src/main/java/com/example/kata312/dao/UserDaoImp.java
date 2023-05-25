package com.example.kata312.dao;

import com.example.kata312.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getById(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    public boolean add(User user) {
        entityManager.persist(user);
        return true;
    }

    public User findByEmail(String email) {
        Query query = entityManager.createQuery("select u from User u left join fetch u.roles where u.email=:username", User.class);
        query.setParameter("username", email);
        return (User) query.getSingleResult();
    }

    @Override
    public void removeUser(Integer id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}