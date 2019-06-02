package com.xls.spring_ioc.bean;

public class Bean6 {
    private Bean7 bean7;

    public Bean7 getBean7() {
        return bean7;
    }

    public void setBean7(Bean7 bean7) {
        this.bean7 = bean7;
    }

    @Override
    public String toString() {
        return "Bean7{" +
                "bean7=" + bean7 +
                '}';
    }
}
