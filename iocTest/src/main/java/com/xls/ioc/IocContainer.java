package com.xls.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *手动实现 Ioc
 * 约定
 * 所有的bean的生命周期由IoC管理
 * 所有倚赖的bean通过构造方法进行注入
 * 被依赖的bean需要优先创建
 *
 * 1创建bean
 * 2保存bean
 * 3获取bean
 * 4每一个bean产生一个与之相对应的id
 */
public class IocContainer {
    private Map<String,Object> beans = new ConcurrentHashMap<String, Object>();
    //获取bean
    public Object getBean(String beanId){
        return  beans.get(beanId);
    }
    //设置bean 需要bean的类，beanId，所依赖的beanId
    public void setBean(Class<?> clazz ,String beanId,String... dependBeanIds){
        //设置构造方法需要参数
        Object[] paramValue = new Object[dependBeanIds.length];
        for (int i = 0; i < dependBeanIds.length; i++) {
            paramValue[i] = beans.get(dependBeanIds[i]);
        }

        //实例化Bean
        //得到所有的构造方法
        Object bean = null;
        for (Constructor<?> constructor : clazz.getConstructors()) {
            try {
                bean = constructor.newInstance(paramValue);
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
        }

        //保存到map中
        if (bean == null){
            throw new RuntimeException("初始化bean失败，找不到"+clazz.getName()+"相应的构造方法");
        }
        beans.put(beanId,bean);
    }
}
