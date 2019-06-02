package com.xls.spring_ioc.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


/**
 * 测试bena的初始化和销毁 2种方式
 * 1.在xml中bean标签中添加 init-method destroy-method
 * 2.实现 InitializingBean, DisposableBean 接口
 */

public class Bean11 implements InitializingBean, DisposableBean {
    public void onInit(){
        System.out.println("Bean11.onInit");
    }
    public void onDestroy(){
        System.out.println("Bean11.onDestroy");
    }

    public void destroy() throws Exception {
        System.out.println("Bean11.destroy");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean11.afterPropertiesSet");
    }
}
