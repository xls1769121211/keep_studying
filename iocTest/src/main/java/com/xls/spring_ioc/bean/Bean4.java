package com.xls.spring_ioc.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Bean4 {
    private Bean5 anotherBean;
    private String name;

    private Bean5 anotherBean2;
    private String name2;

    //
    private List<String> stringList;
    private List<Bean5> anotherBeanList;

    private Set<String> stringSet;
    private Set<Bean5> anotherBeanSet;

    private Map<String,String> stringMap;
    private Map<Bean5,Bean5> anotherBeanMap;

    private Properties properties;

    private List<Bean5> anotherList2;

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<Bean5> getAnotherBeanList() {
        return anotherBeanList;
    }

    public void setAnotherBeanList(List<Bean5> anotherBeanList) {
        this.anotherBeanList = anotherBeanList;
    }

    public Set<String> getStringSet() {
        return stringSet;
    }

    public void setStringSet(Set<String> stringSet) {
        this.stringSet = stringSet;
    }

    @Override
    public String toString() {
        return "Bean4{" +
                "anotherBean=" + anotherBean +
                ", name='" + name + '\'' +
                ", anotherBean2=" + anotherBean2 +
                ", name2='" + name2 + '\'' +
                ", stringList=" + stringList +
                ", anotherBeanList=" + anotherBeanList +
                ", stringSet=" + stringSet +
                ", anotherBeanSet=" + anotherBeanSet +
                ", stringMap=" + stringMap +
                ", anotherBeanMap=" + anotherBeanMap +
                ", properties=" + properties +
                ", anotherList2=" + anotherList2 +
                '}';
    }

    public Set<Bean5> getAnotherBeanSet() {
        return anotherBeanSet;
    }

    public void setAnotherBeanSet(Set<Bean5> anotherBeanSet) {
        this.anotherBeanSet = anotherBeanSet;
    }

    public Map<String, String> getStringMap() {
        return stringMap;
    }

    public void setStringMap(Map<String, String> stringMap) {
        this.stringMap = stringMap;
    }

    public Map<Bean5, Bean5> getAnotherBeanMap() {
        return anotherBeanMap;
    }

    public void setAnotherBeanMap(Map<Bean5, Bean5> anotherBeanMap) {
        this.anotherBeanMap = anotherBeanMap;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public List<Bean5> getAnotherList2() {
        return anotherList2;
    }

    public void setAnotherList2(List<Bean5> anotherList2) {
        this.anotherList2 = anotherList2;
    }

    public Bean5 getAnotherBean2() {
        return anotherBean2;
    }

    public void setAnotherBean2(Bean5 anotherBean2) {
        this.anotherBean2 = anotherBean2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public Bean4(Bean5 anotherBean, String name) {
        this.anotherBean = anotherBean;
        this.name = name;
    }

    public Bean5 getAnotherBean() {
        return anotherBean;
    }

    public void setAnotherBean(Bean5 anotherBean) {
        this.anotherBean = anotherBean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}