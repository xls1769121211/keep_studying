package com.xls.user.userSupport;

import com.xls.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 使用JpaSpecificationExecutor
 * 这个类 是单独的类没有继承jpa的Repository，所以一般和JpaRepository一起使用
 *
 */
public interface UserRepositoryJpaSpecificationExecutor extends JpaSpecificationExecutor<User>, JpaRepository<User,Integer>{
}
