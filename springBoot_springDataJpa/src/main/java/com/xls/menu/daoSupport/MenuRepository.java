package com.xls.menu.daoSupport;

import com.xls.menu.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 通过继承 JpaRepository<T,ID> 接口实现
 *T 操作的实体
 * ID 操作实体主键的类型
 *
 */
public interface MenuRepository extends JpaRepository<Menu,Integer>{
}
