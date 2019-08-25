package com.xls.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

@Component(value = "myadapt")
public class MyAdt extends AdaptableJobFactory{

    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    //重写生成任务详情的对象的方法，并加入到spring ioc容器中

    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object o =  super.createJobInstance(bundle);
        //加入到spring容器中 使用autowireCapableBeanFactory
        autowireCapableBeanFactory.autowireBean(o);
        return o;
    }

}
