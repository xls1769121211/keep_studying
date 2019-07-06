package com.xls.users.mapper;

import com.xls.users.domain.User;
import java.util.List;

public interface UserMapper {
    List<User> queryAllUsers();

    void insertUser(User user);
}
