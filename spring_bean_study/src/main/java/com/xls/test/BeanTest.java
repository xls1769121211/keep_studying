package com.xls.test;

import com.xls.configuration.SpringConfiguration;
import com.xls.configuration.SpringConfiguration2;
import com.xls.configuration.SpringConfiguration3;
import com.xls.entry.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class BeanTest {
    public static void main(String[] args) {
        //test1();
         //test2();
        //test3();
        //test4();
        //test5();
       // test6();
        //test7();
        test8();
    }

    public static void test1(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        printBeanNames(annotationConfigApplicationContext);
    }

    public static void test4(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
       // printBeanNames(annotationConfigApplicationContext);
        Object myFactoryBean = annotationConfigApplicationContext.getBean("myFactoryBean");
        Object myFactoryBean1 = annotationConfigApplicationContext.getBean("&myFactoryBean");
        System.out.println(myFactoryBean.getClass());
        System.out.println(myFactoryBean1.getClass());
        System.out.println(myFactoryBean == myFactoryBean1);
    }

    public static void test2(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        System.out.println("容器完成创建。。。。。");
        Object user1 = annotationConfigApplicationContext.getBean("user1");

    }
    private  static  void printBeanNames(ApplicationContext context){
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }


    public static void test3(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        System.out.println("容器完成创建。。。。。");
        printBeanNames(annotationConfigApplicationContext);
        Map<String, User> beansOfType = annotationConfigApplicationContext.getBeansOfType(User.class);
        for (String key :
                beansOfType.keySet() ) {
            System.out.println(key);
        }

        //获取操作系统
        ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
        String property = environment.getProperty("os.name");

        System.out.println("操作系统---------》"+property);
    }

    public static void test5(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfiguration2.class);

        System.out.println("容器完成创建。。。。。");


        // annotationConfigApplicationContext.getBean("People1");
        annotationConfigApplicationContext.close();

    }

    public static void test6(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfiguration3.class);
        System.out.println("容器完成创建。。。。。");
        printBeanNames(annotationConfigApplicationContext);

    }


    /**
     * 代码手动设置激活环境参数
     */
    public static void test7(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();


        annotationConfigApplicationContext.getEnvironment().setActiveProfiles("test");

        annotationConfigApplicationContext.register(SpringConfiguration3.class);
        annotationConfigApplicationContext.refresh();

        System.out.println("容器完成创建。。。。。");
        printBeanNames(annotationConfigApplicationContext);

    }

    public static void test8(){
        Object trueee = true;
        Boolean inProject = (Boolean)trueee;
        System.out.println(inProject);


        Object i = 1;
        int ii = (int)i;
        System.out.println(ii);

    }



}
