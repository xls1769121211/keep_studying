package com.xls.user.userSupport;

import com.xls.user.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 实现查询 结果分页和排序
 */
public interface UserRepositoryPagingAndSorting extends PagingAndSortingRepository<User,Integer>{
}
