package com.xls.test2;

public class KeyPerson extends  Thread{

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i <10; i++) {
            System.out.println(name+"发动第"+i+"次攻击----------");
        }
    }
}
