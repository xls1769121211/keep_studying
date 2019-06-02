package com.xls.spring_annotation_ioc.bean;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用注解
 * 自定义实现 spring bean的作用域
 * 实现 org.springframework.beans.factory.config.Scope 接口
 * 模拟 实现双例模式
 */
public class MyCustomScope implements Scope {
    //用两个map来实现
    private Map<String,Object> map1 = new ConcurrentHashMap<String, Object>();
    private Map<String,Object> map2 = new ConcurrentHashMap<String, Object>();

    public Object get(String s, ObjectFactory<?> objectFactory) {
        if (!map1.containsKey(s)){
            Object o = objectFactory.getObject();
            map1.put(s,o);
            return o;
        }
        if (!map2.containsKey(s)){
            Object o = objectFactory.getObject();
            map2.put(s,o);
            return o;
        }
        Object o = null;
        int i = new Random().nextInt(2);
        if (i == 0){
            o = map1.get(s);
        }else{
            o = map2.get(s);
        }
        return  o;
    }

    public Object remove(String s) {
       if (map1.containsKey(s)){
           Object o = map1.get(s);
           map1.remove(s);
           return  o;
       }
        if (map2.containsKey(s)){
            Object o = map2.get(s);
            map2.remove(s);
            return  o;
        }
        return  null;
    }

    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    public Object resolveContextualObject(String s) {
        return null;
    }

    public String getConversationId() {
        return null;
    }
}
