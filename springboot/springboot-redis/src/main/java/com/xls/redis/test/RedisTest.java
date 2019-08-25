package com.xls.redis.test;

import com.xls.redis.App;
import com.xls.redis.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class RedisTest{
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 添加一个字符串
     */
    @Test
    public void testSet(){
        this.redisTemplate.opsForValue().set("key", "xlsxlsllsl");
    }

    /**
     * 获取一个字符串
     */
    @Test
    public void testGet(){
        String value = (String)this.redisTemplate.opsForValue().get("key");

        System.out.println(value);
    }

    /**
     * 测试保存一个实体
     */
    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUserName("张三");
        user.setPassWord("123456");
        user.setAge(19);
        //重新设置序列化器
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

        this.redisTemplate.opsForValue().set("user_11",user);
    }

    /**
     * 测试获取一个实体
     */
    @Test
    public void testGetUser(){
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        Object user_11 = this.redisTemplate.opsForValue().get("user_11");

        System.out.println(user_11);
    }

}
