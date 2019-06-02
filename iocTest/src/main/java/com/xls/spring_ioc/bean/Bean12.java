package com.xls.spring_ioc.bean;

public class Bean12 extends ParentBean {
    private String attr4;

    public String getAttr4() {
        return attr4;
    }

    public void setAttr4(String attr4) {
        this.attr4 = attr4;
    }

    @Override
    public String toString() {
        return "Bean12{" +
                "attr4='" + attr4 + '\'' +
                "attr1='" + getAttr1() + '\'' +
                "attr2='" + getAttr2() + '\'' +
                "attr3='" + getAttr3() + '\'' +
                '}';
    }
}
