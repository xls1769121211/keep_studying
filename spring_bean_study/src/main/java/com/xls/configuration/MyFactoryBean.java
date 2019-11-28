package com.xls.configuration;

import com.xls.entry.Pen;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Pen>{
    public Pen getObject() throws Exception {
        return new Pen();
    }

    //是否获取类类型
    public Class<?> getObjectType() {
        return Pen.class;
    }

    //是否是单例模式
    public boolean isSingleton() {
        return true;
    }
}
