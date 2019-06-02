package com.xls.spring_ioc.test;

import com.xls.spring_ioc.bean.Bean11;
import org.junit.Test;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试bena的初始化和销毁 2种方式
 * 1.在xml中bean标签中添加 init-method destroy-method
 * 2.实现 InitializingBean, DisposableBean 接口
 */
public class TestBeanInitAndDestroy  {
    @Test
    public void Test(){
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("spring-init-destroy.xml");
       Bean11 bean11 = (Bean11) context.getBean("bean11");
        context.close();
    }

}
