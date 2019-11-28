package com.xls.configuration;

import com.xls.Conditionnal.LinuxConditional;
import com.xls.Conditionnal.WindowsConditional;
import com.xls.entry.Dog;
import com.xls.entry.People;
import com.xls.entry.User;
import org.springframework.context.annotation.*;


/**
 * Spring 配置类
 * 练习bean的生命周期 lifecycle
 *  初始化------------>使用------------->销毁
 *  1.使用@Bean中的 initMethod 和 destroyMethod 分别指定bean中的2个方法  @Bean(initMethod = "initP" ,destroyMethod = "destroyP")
 *  2.bean实现InitializingBean和DisposableBean，在重写方法中写逻辑 执行 invokeInitMethods 先执行InitializingBean的afterPropertiesSet，
 *    然后执行invokeCustomInitMethod bean自定义的初始化方法 initMethod
 *  3 在bean的方法中加入 @PreConstruct 初始化  @PreDestroy 销毁
 *  4 使用BeanPostProcessor   postProcessBeforeInitialization 在bean初始化设置属性之前 postProcessAfterInitialization 在bean初始化设置属性之 后
 */
@Configuration
public class SpringConfiguration2{

//    @Bean(initMethod = "initP" ,destroyMethod = "destroyP")
//    //@Scope("prototype")
//    public People People1(){
//        return  new People("aaa",15);
//    }

    @Bean
    public Dog dog(){
        return  new Dog();
    }
}
