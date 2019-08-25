package com.xls.user.dao;

import com.xls.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 通过继承 JpaRepository<T,ID> 接口实现
 *T 操作的实体
 * ID 操作实体主键的类型
 *
 */
public interface UserRepository extends JpaRepository<User,Integer>{
}
