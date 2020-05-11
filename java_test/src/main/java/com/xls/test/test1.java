package com.xls.test;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description:
 * @author: xingliushan
 * @createDate: 2020/5/11
 * @version: 1.0
 */
public class test1{

    public static void main(String[] args) {

    }

    //测试 reentrantReadWriteLock锁的可重入性
    @Test
    public void testReIn() {
        final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        //定义线程
        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {
                reentrantReadWriteLock.writeLock().lock();
                System.out.println("子线程运行。。。。。");
            }
        });


        //主线程获取2次锁
        reentrantReadWriteLock.readLock().lock();
        reentrantReadWriteLock.readLock().lock();
        t.start();
        System.out.println("主线程释放一次锁。。。");
        reentrantReadWriteLock.readLock().unlock();
        System.out.println("主线程释放2次锁。。。");
        //  reentrantReadWriteLock.readLock().lock();
    }


    //测试reentrantReadWriteLock锁的降级和升级

    /* *
        测试reentrantReadWriteLock锁的升级
        结论：读锁不能升级为写锁，ReadWriteLock不支持锁的升级
     */
    @Test
    public void testLockUpgrade() {
        final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();



        System.out.println("读锁升级为写锁。。。");
        reentrantReadWriteLock.readLock().lock();
        System.out.println("获取读锁。。。");
        reentrantReadWriteLock.writeLock().lock();
        System.out.println("获取写锁。。。");
    }


      /* *
        测试reentrantReadWriteLock锁的降级
        结论：写锁可以降级为读锁，但是锁没有显示的释放，别的线程永远也获取不到写锁。
     */
    @Test
    public void testLockDowngrade() {
        final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        System.out.println("写锁降级为读锁。。。");
        reentrantReadWriteLock.writeLock().lock();
        System.out.println("获取写锁。。。");
        reentrantReadWriteLock.readLock().lock();
        System.out.println("获取读锁。。。");
        System.out.println("写锁是否锁住===="+reentrantReadWriteLock.isWriteLocked());
    }


    /**
     * 使用 synchronized 读取的时候的现象
     *
     *
     */
    @Test
    public void testSynchronizedRead(){

        new Thread(new Runnable(){
            @Override
            public void run() {
               // read111(Thread.currentThread());
               Thread thread = Thread.currentThread();
                System.out.println("start time:" + System.currentTimeMillis());
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(thread.getName() + ":正在进行读操作……");
                }
                System.out.println(thread.getName() + ":读操作完毕！");
                System.out.println("end time:" + System.currentTimeMillis());
            }
        }).start();

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        new Thread(new Runnable(){
//            @Override
//            public void run() {
//                read111(Thread.currentThread());
//            }
//        }).start();

    }


    private synchronized void read111(Thread thread){
        System.out.println("start time:" + System.currentTimeMillis());
        for (int i = 0; i < 5; i++) {
            try {
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
