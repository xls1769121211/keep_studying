package com.xls.user.userSupport;

import com.xls.user.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * 使用 Repository 的@Query注解实现查询和更新
 */
public interface UserRepositoryQueryAnnotation extends Repository<User,Integer>{

    //根据人员id查询 使用hql
    @Query("from User where id = ?1")
    User queryUserById(Integer id);

    //根据人员名称查询 使用hql
    @Query("from User where userName = ?1")
    List<User> queryUsersByNameByHql(String username);

    //根据人员名称查询 使用标准sql语句，需要设置nativeQuery为true标识使用标准sql
    @Query(value = "select * from t_user where user_name = ?",nativeQuery = true)
    List<User> queryUsersByNameBySql(String username);

    @Query("update User set userName = ?1 where id = ?2")
    @Modifying//真正去执行更新操作的注解
    void updateUserNameById(String username,Integer id);
}
