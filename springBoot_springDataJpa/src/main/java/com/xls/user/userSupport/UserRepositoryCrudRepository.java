package com.xls.user.userSupport;

import com.xls.user.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * 使用CrudRepository实现数据的增删查改
 */
public interface UserRepositoryCrudRepository extends CrudRepository<User,Integer>{
}
