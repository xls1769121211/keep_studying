package com.xls.test;

import com.xls.App;
import com.xls.Car.Car;
import com.xls.Car.CarRepository;
import com.xls.menu.daoSupport.MenuRepository;
import com.xls.menu.domain.Menu;
import com.xls.user.domain.User;
import com.xls.user.userSupport.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * spring  事务的传播行为 : 描述一个被事务修饰的方法，嵌套在其他方法中的时候事务的传播方式
 *
 *  7种传播方式
 *  Propagation.REQUIRED 默认的传播规则，如果当前没有事务，就创建一个事务，如果当前存在事务，就加入到这个事务中
 *
 *  Propagation.SUPPORTS  支持当前事务，如果当前没有事务，就以非事务方式执行
 *
 *  Propagation.MANDATORY  支持当前事务，如果当前没有事务，抛出异常
 *
 *  Propagation.REQUIRES_NEW  新建事务，如果当前有事务，则挂起当前事务
 *
 *  Propagation.NOT_SUPPORTED  以非事务方式执行，如果当前有事务，则挂起当前事务
 *
 *  Propagation.NEVER  以非事务方式执行，如果当前有事务，抛出异常
 *
 *  Propagation.NESTED  如果当前存在事务，则在事务中执行，如果当前没有事务，则执行与Propagation.REQUIRED类似
 *
 *
 * @description:
 * @author: xingliushan
 * @createDate: 2020/4/27
 * @version: 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class SpringTransactionTest{



    @Autowired
    private CarRepository carRepository;

    /*****************     Propagation.REQUIRED 默认的传播规则，如果当前没有事务，就创建一个事务，如果当前存在事务，就加入到这个事务中                 ***************/


    /**
     *  Propagation.REQUIRED 默认的传播规则 测试
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void methodA(){
        Car car = new Car();
        car.setCity("上海");
        carRepository.save(car);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void methodB(){
        Car car = new Car();
        car.setCity("广州");
        carRepository.save(car);
        throw new RuntimeException();
    }

    /**
     * test方法没有开启事务
     * 方法A,B 会自己创建一个事务执行，互不影响
     */
    @Test
   // @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void testRequired(){
        this.methodA();
        this.methodB();
        //throw new RuntimeException();
    }

    /**
     * test方法开启事务
     * 外围方法开启事务的情况下Propagation.REQUIRED修饰的内部方法会加入到外围方法的事务中，
     * 所有Propagation.REQUIRED修饰的内部方法和外围方法均属于同一事务，只要一个方法回滚，整个事务均回滚。
     */
    @Test
     @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void testRequired2(){
        this.methodA();
        this.methodB();
        //throw new RuntimeException();
    }



    /*****************           Propagation.REQUIRES_NEW  新建事务，如果当前有事务，则挂起当前事务                 ***************/



    /**
     *  Propagation.REQUIRES_NEW  测试
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void methodC(){
        Car car = new Car();
        car.setCity("上海1");
        carRepository.save(car);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void methodD(){
        Car car = new Car();
        car.setCity("广州1");
        carRepository.save(car);
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void methodE(){
        Car car = new Car();
        car.setCity("深圳");
        carRepository.save(car);
        throw new RuntimeException();
    }

    /**
     * 在外围方法开启事务的情况下Propagation.REQUIRES_NEW修饰的内部方法依然会单独开启独立事务，
     * 且与外部方法事务也独立，内部方法之间、内部方法和外部方法事务均相互独立，互不干扰。
     */
    @Test
   // @Transactional(propagation = Propagation.REQUIRED)
    public void testRequired4(){

        //this.methodA();
        this.methodC();
        this.methodD();

        throw new RuntimeException();
    }





    /*****************           Propagation.REQUIRES_NEW  新建事务，如果当前有事务，则挂起当前事务                 ***************/



}
