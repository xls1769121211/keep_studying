package com.xls.user.userSupport;

import com.xls.user.domain.User;
import org.springframework.data.repository.Repository;

import java.util.List;

/** jpa Repository 基于
 * 使用方法名查询数据库中的数据
 */
public interface UserRepositoryName extends Repository<User,Integer>{

    /**
     *   使用方法名查询数据库中的数据
     *   方法名以findBy 开头
     *   符合驼峰式命名规则
     */
    //默认相等规则
    List<User> findByUserName(String username);

    List<User> findByUserNameAndAge(String username,Integer age);

    List<User> findByUserNameLike(String username);
}
