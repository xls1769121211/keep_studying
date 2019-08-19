package com.xls.junit.serivce;

import com.xls.junit.dao.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl{
    @Autowired
    private userDao userDao1;

    public void saveUser(){
        userDao1.saveUser();
    }
}
