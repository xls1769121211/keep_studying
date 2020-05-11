package com.xls.test;

import org.junit.Test;

/**
 * @description:
 * @author: xingliushan
 * @createDate: 2020/5/11
 * @version: 1.0
 */
public class testSynchronizedRead{
    /**
     * 使用 synchronized 读取的时候的现象
     *
     * 两个或者多个线程的读操作是顺序执行的
     */
    public static void  main( String [] args){

        new Thread(new Runnable(){
            @Override
            public void run() {
                read111(Thread.currentThread());
            }
        }).start();


        new Thread(new Runnable(){
            @Override
            public void run() {
                read111(Thread.currentThread());
            }
        }).start();

    }


    private static synchronized void read111(Thread thread){
        System.out.println("start time:" + System.currentTimeMillis());
        for (int i = 0; i < 5; i++) {
            try {

                System.out.println( Thread.currentThread() == thread );
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.getName() + ":正在进行读操作……");
        }
        System.out.println(thread.getName() + ":读操作完毕！");
        System.out.println("end time:" + System.currentTimeMillis());
//        for (int i = 0; i < 5; i++) {
//            try {
//                Thread.sleep(20);
//                System.out.println(thread.getName()+"第"+i+"次读取======");
//            }catch (Exception e){
//
//            }
//        }
    }
}
