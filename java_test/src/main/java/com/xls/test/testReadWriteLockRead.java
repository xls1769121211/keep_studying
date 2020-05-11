package com.xls.test;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description:
 * @author: xingliushan
 * @createDate: 2020/5/11
 * @version: 1.0
 */
public class testReadWriteLockRead{
    /**
     * 使用 ReadWriteLockRead 读取的时候的现象
     *
     * 两个或者多个线程的读操作是并行操作，耗时缩短
     */
    public static void  main( String [] args){

        final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        new Thread(new Runnable(){
            @Override
            public void run() {
                read111(Thread.currentThread(),reentrantReadWriteLock);
            }
        }).start();


        new Thread(new Runnable(){
            @Override
            public void run() {
                read111(Thread.currentThread(),reentrantReadWriteLock);
            }
        }).start();

    }


    private static  void read111(Thread thread,ReentrantReadWriteLock reentrantReadWriteLock){

        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.readLock().lock();
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

        lock.readLock().unlock();
    }
}
