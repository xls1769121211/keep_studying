package com.xls.users.service;

import com.xls.users.domain.User;

import java.util.List;

public interface UserService{
    List<User> QueryAllUsers();

    void insertUser(User user);
}
