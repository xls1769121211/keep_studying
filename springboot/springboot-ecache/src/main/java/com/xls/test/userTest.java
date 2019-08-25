package com.xls.test;

import com.xls.App;
import com.xls.user.domain.User;
import com.xls.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class userTest{
    @Autowired
    private UserService userService;

    @Test
    public void testFindAll(){
        System.out.println("第一次查询=====================");
        List<User> users = userService.findAll();
        System.out.println(users);
        System.out.println("第二次查询=====================");
        List<User> users2 = userService.findAll();
        System.out.println(users2);
    }

    @Test
    public void testFindById(){
        System.out.println("第一次查询=====================");
        User user = userService.findUserById(7);
        System.out.println(user);
        System.out.println("第二次查询=====================");
        User user2 = userService.findUserById(7);
        System.out.println(user2);
    }

    /**
     * 测试清除缓存
     */
    @Test
    public void testSaveUser(){


        System.out.println("第一次查询=====================");
        List<User> users = userService.findAll();
        System.out.println(users);

        User user = new User();
        user.setUserName("刘");
        user.setCity("上海");
        user.setAge(18);
        userService.saveUser(user);

        System.out.println("第二次查询=====================");
        List<User> users2 = userService.findAll();
        System.out.println(users2);
    }

    /**
     *
     */
    @Test
    public void testPage(){
        Pageable pageable = new PageRequest(0, 2);
        //第一次查询
        System.out.println(this.userService.findUserByPage(pageable).getTotalElements());

        //第二次查询
        System.out.println(this.userService.findUserByPage(pageable).getTotalElements());

        //第三次查询
        pageable = new PageRequest(1, 2);
        System.out.println(this.userService.findUserByPage(pageable).getTotalElements());



    }


}
