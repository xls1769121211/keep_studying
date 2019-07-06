package com.xls.users.service.Impl;

import com.xls.users.domain.User;
import com.xls.users.mapper.UserMapper;
import com.xls.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
   private UserMapper userMapper;

    @Override
    public void insertUser(User user) {
        this.userMapper.insertUser(user);
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> QueryAllUsers() {
        int i = 1;
        return this.userMapper.queryAllUsers();
    }
}
