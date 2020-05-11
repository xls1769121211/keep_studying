package com.xls.test;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description:
 * @author: xingliushan
 * @createDate: 2020/5/11
 * @version: 1.0
 */
public class testReentrantReadWriteLockReadAndWrite{

  static  final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    /**
     * 使用 ReadWriteLockRead 同时读取和写入的时候的现象
     *
     * 读锁和写锁互斥
     * 读写锁的实现必须确保写操作对读操作的内存影响。换句话说，一个获得了读锁的线程必须能看到前一个释放的写锁所更新的内容，读写锁之间为互斥
     *
     *
     *
     * 使用 ReadWriteLockRead 同时写入的时候的现象
     * 写锁互斥
     *
     */
    public static void  main( String [] args){


        new Thread(new Runnable(){
            @Override
            public void run() {
               // read111(Thread.currentThread(),reentrantReadWriteLock);
               write111(Thread.currentThread(),reentrantReadWriteLock);
            }
        }).start();


        new Thread(new Runnable(){
            @Override
            public void run() {
                write111(Thread.currentThread(),reentrantReadWriteLock);
            }
        }).start();

    }


    private static  void read111(Thread thread,ReentrantReadWriteLock reentrantReadWriteLock){

        reentrantReadWriteLock.readLock().lock();

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


        reentrantReadWriteLock.readLock().unlock();
    }


    private static  void write111(Thread thread,ReentrantReadWriteLock reentrantReadWriteLock){

        reentrantReadWriteLock.writeLock().lock();

        System.out.println("start time:" + System.currentTimeMillis());
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println( Thread.currentThread() == thread );
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.getName() + ":正在进行写操作……");
        }
        System.out.println(thread.getName() + ":写操作完毕！");
        System.out.println("end time:" + System.currentTimeMillis());

        reentrantReadWriteLock.writeLock().unlock();
    }
}
