package com.xls.user.service.Impl;

import com.xls.user.dao.UserRepository;
import com.xls.user.domain.User;
import com.xls.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSerivceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    @Cacheable(value = "users")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Cacheable(value = "users")
    public User findUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.get();
    }

    /**
     * 	//@CacheEvict(value="users",allEntries=true) 清除缓存中以users缓存策略缓存的对象
     * @param user
     */
    @Override
    @CacheEvict(value="users",allEntries=true)
    public void saveUser(User user) {
        userRepository.save(user);
    }


    /**
     * @Cacheable作用：把方法的返回值添加到Ehcache中做缓存
     * Value属性：指定一个Ehcache配置文件中的缓存策略，如果么有给定value，name则表示使用默认的缓存策略。
     * Key属性：给存储的值起个名称。在查询时如果有名称相同的，那么则知己从缓存中将数据返回
     * @param pageable
     * @return
     */
    @Override
    @Cacheable(value="users")
    public Page<User> findUserByPage(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }



}
