package com.xls.user.service;

import com.xls.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService{

    List<User> findAll();

    User findUserById(Integer id);

    void saveUser(User user);

    Page<User> findUserByPage(Pageable pageable) ;

}
