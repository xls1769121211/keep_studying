package com.xls.spring_ioc.bean;

public class Bean13  extends ParentBean{
    private String attr5;

    public String getAttr5() {
        return attr5;
    }

    public void setAttr5(String attr5) {
        this.attr5 = attr5;
    }

    @Override
    public String toString() {
        return "Bean13{" +
                "attr5='" + attr5 + '\'' +
                "attr1='" + getAttr1() + '\'' +
                "attr2='" + getAttr2() + '\'' +
                "attr3='" + getAttr3() + '\'' +
                '}';
    }
}
