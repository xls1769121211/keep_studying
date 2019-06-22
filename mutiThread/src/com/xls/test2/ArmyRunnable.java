package com.xls.test2;

/**
 * 军队打架
 */
public class ArmyRunnable implements  Runnable{
    /**
     *保证多个线程之间的 可见性 控制军队是否进攻
     */
    volatile boolean attack = true;

    @Override
    public void run() {
        String name  = Thread.currentThread().getName();
        //军队发动 进攻
        while(attack){
            for (int i = 0; i < 5; i++) {
                System.out.println(name+"军队发动进攻---------["+i+"]");
                //调用线程的yeild方法，在军队的每次进攻之后，释放资源
                Thread.yield();
            }
        }
        System.out.println(name+"军队进攻结束----------");
    }
}
