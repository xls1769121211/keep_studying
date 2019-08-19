package com.xls.test;

import com.xls.App;
import com.xls.user.domain.User;
import com.xls.user.impl.BBBB;
import com.xls.user.userSupport.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class userTest{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepositoryName userRepositoryName;
    @Autowired
    private UserRepositoryQueryAnnotation userRepositoryQueryAnnotation;
    @Autowired
    private UserRepositoryCrudRepository userRepositoryCrudRepository;

    @Autowired
    private UserRepositoryPagingAndSorting userRepositoryPagingAndSorting;

    @Autowired
    private BBBB bbbb;

    @Autowired
    private UserRepositoryJpaSpecificationExecutor userRepositoryJpaSpecificationExecutor;


    @Test
    public void testSaveUser(){
        User user  = new User();
        user.setUserName("刘二斤半牛皮！");
        user.setAge(14);
        user.setCity("上海");

        userRepository.save(user);
    }

    @Test
    public void testFindByName(){
        List<User> users = userRepositoryName.findByUserName("刘二斤半牛皮！");
        System.out.println(users);
        bbbb.printAAA();
    }

    @Test
    public void testFindByNameAndAge(){
        List<User> users = userRepositoryName.findByUserNameAndAge("刘二斤半牛皮！",14);
        System.out.println(users);
    }

    @Test
    public void testFindByNameLike(){
        List<User> users = userRepositoryName.findByUserNameLike("%刘%");
        System.out.println(users);
    }

    @Test
    public void testQueryUsersByNameByHql(){
        List<User> users = userRepositoryQueryAnnotation.queryUsersByNameByHql("刘二斤半牛皮！");
        System.out.println(users);
    }

    @Test
    public void testQueryUsersByNameBySql(){
        List<User> users = userRepositoryQueryAnnotation.queryUsersByNameBySql("刘二斤半牛皮！");
        System.out.println(users);
    }

    /**
     *更新用户
     * @Test 和@Transactional一起使用会导致食物自动回滚 使用@RollBack 设置事务不回滚
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testUpdateUserNameById(){
        userRepositoryQueryAnnotation.updateUserNameById("刘二斤半",1);
    }

    /**
     * 使用CrudRepository 实现增删查改
     */

    //增加
    @Test
    public void testCrudRepositorySaveUser(){
        User user = new User();
        user.setUserName("刘二斤半牛");
        user.setAge(22);
        user.setCity("郑州");
        userRepositoryCrudRepository.save(user);
    }

    //查询
    @Test
    public void testCrudRepositoryQueryAll(){
        List<User> users = (List<User>) userRepositoryCrudRepository.findAll();
        System.out.println(users);
    }


    //修改

    @Test
    public void testCrudRepositoryUpdateUser(){
        User user = new User();
        user.setId(3);
        user.setUserName("刘牛");
        user.setAge(2);
        user.setCity("州");
        userRepositoryCrudRepository.save(user);
    }

    //删除
    @Test
    public void testCrudRepositoryDeleteUser(){
        userRepositoryCrudRepository.deleteById(3);
    }

    /**
     * 使用PagingAndSorting 实现分页和排序查询
     */
    //排序
    @Test
    public void testPagingAndSortingS(){
        //Order对象定义了排序规则
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");

        Sort sort = new Sort(order);
        List<User> users = (List<User>) userRepositoryPagingAndSorting.findAll(sort);
        System.out.println(users);
    }

      //分页

    @Test
    public void testPagingAndSortingP(){
        Pageable pageable = new PageRequest(0,2);
        Page<User> all = userRepositoryPagingAndSorting.findAll(pageable);
        System.out.println("总页数"+all.getTotalPages());
        System.out.println("总个数"+all.getTotalElements());
        List<User> users = all.getContent();
        System.out.println(users);
    }

    //分页加排序
    @Test
    public void testPagingAndSortingPAndS(){
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");

        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(0,2,sort);
        Page<User> all = userRepositoryPagingAndSorting.findAll(pageable);
        System.out.println("总页数"+all.getTotalPages());
        System.out.println("总个数"+all.getTotalElements());
        List<User> users = all.getContent();
        System.out.println(users);
    }


    /**
     * 测试
     * JpaSpecificationExecutor 单个查询条件
     */

    @Test
    public void testJpaSpecificationExecutor1(){
        Specification specification = new Specification(){

            /**
             *
             * @param root 对实体类属性的封装主要用来获区实体字段
             * @param criteriaQuery 封装了查询中的的部分信息 select where order等
             * @param criteriaBuilder 构建查询条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate =  criteriaBuilder.equal(root.get("userName"),"刘牛");
                return predicate;
            }
        };

        List users = userRepositoryJpaSpecificationExecutor.findAll(specification);
        System.out.println(users);
    }


    /**
     * 测试
     * JpaSpecificationExecutor 多个查询条件
     */

    @Test
    public void testJpaSpecificationExecutor2(){
        Specification specification = new Specification(){

            /**
             *
             * @param root 对实体类属性的封装主要用来获区实体字段
             * @param criteriaQuery 封装了查询中的的部分信息 select where order等
             * @param criteriaBuilder 构建查询条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {



                Predicate predicate = criteriaBuilder.or( criteriaBuilder.and(criteriaBuilder.equal(root.get("userName"),"刘牛")),
                        criteriaBuilder.and(criteriaBuilder.equal(root.get("id"),1)));
                return predicate;
            }
        };

        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");

        Sort sort = new Sort(order);

        List users = userRepositoryJpaSpecificationExecutor.findAll(specification,sort);
        System.out.println(users);
    }

}
