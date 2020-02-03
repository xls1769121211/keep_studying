package com.xls.spring.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 增加数据
     */

    public void insert(){
        String sql = "insert into user (username,age) VALUES (?,?);";
        String userName = UUID.randomUUID().toString();
        int age = (int)Math.random() * 10;
        jdbcTemplate.update(sql,userName,age);
    }

}
