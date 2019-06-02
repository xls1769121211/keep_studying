package com.xls.spring_annotation_ioc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 注入bean
 * 1 构造方法
 * 2 set方法
 *
 */
@Component(value = "18888")
public class Bean18 {
    private Bean19 bean19;

    private Bean19 bean19_1;

    private String aaa;


    /**
        注入List<T> 如果spring上下文中存在T类型的bean 则默认填充到list中

     */
    private List<Bean19> bean19List;

    private List<String> stringList;

    public List<String> getStringList() {
        return stringList;
    }

    @Resource
    @Qualifier("stringList")
    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    /**
     * 注入Map<K,V> 与list相似，如果spring上下文中存在V类型的bean 则默认填充到map中,key是bean的id
     * @return
     */
    private Map<String,Bean19> bean19Map;

    public Map<String, Bean19> getBean19Map() {
        return bean19Map;
    }
    @Autowired
    public void setBean19Map(Map<String, Bean19> bean19Map) {
        this.bean19Map = bean19Map;
    }

    public List<Bean19> getBean19List() {
        return bean19List;
    }


    /**
     * list<T> 可以指定Qualifier 指明哪个bean到这个属性中 这样其他T类型的Bean不会加入到list中
     */
    @Autowired()
    public void setBean19List(List<Bean19> bean19List) {
        this.bean19List = bean19List;
    }

    public String getAaa() {
        return aaa;
    }

    /**
     * 简单属性 String ，或者integer可以直接使用@Value直接赋值
     * @param aaa
     */
    @Value("123456788")
    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    @Override
    public String toString() {
        return "Bean18{" +
                "bean19=" + bean19 +
                ", bean19_1=" + bean19_1 +
                ", aaa='" + aaa + '\'' +
                '}';
    }

    /**
     * 构造方法注入
     * @param bean19
     */
    @Autowired
    public Bean18(Bean19 bean19) {
        this.bean19 = bean19;
    }

    public Bean19 getBean19_1() {
        return bean19_1;
    }

    /**
     *  set方法注入 注入在set方法上
     * */
    @Autowired
    public void setBean19_1(Bean19 bean19_1) {
        this.bean19_1 = bean19_1;
    }

}
