package com.hse.gandzha.homemedicine.repository;

import com.hse.gandzha.homemedicine.entity.UserInfo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomUserRepositoryImpl implements  CustomUserRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserInfo merge(UserInfo userInfo) {
        return entityManager.merge(userInfo);
    }
}
