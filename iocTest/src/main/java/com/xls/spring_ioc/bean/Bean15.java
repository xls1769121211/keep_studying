package com.xls.spring_ioc.bean;

public class Bean15{
    private String attr7;
    private String attr1;
    private String attr2;
    private String attr3;

    public String getAttr7() {
        return attr7;
    }

    public void setAttr7(String attr7) {
        this.attr7 = attr7;
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    public String getAttr3() {
        return attr3;
    }

    @Override
    public String toString() {
        return "Bean15{" +
                "attr7='" + attr7 + '\'' +
                ", attr1='" + attr1 + '\'' +
                ", attr2='" + attr2 + '\'' +
                ", attr3='" + attr3 + '\'' +
                '}';
    }

    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }
}
