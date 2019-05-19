package sychronizedTest;

public class SynchronizedClassClass5 implements Runnable {


    static  SynchronizedClassClass5 testSychronized1 = new SynchronizedClassClass5();
    static  SynchronizedClassClass5 testSychronized2 = new SynchronizedClassClass5();
    public static void main(String args[]) throws Exception{
        Thread thead1 = new Thread(testSychronized1);
        Thread thead2 = new Thread(testSychronized2);
        thead1.start();
        thead2.start();
    }

    public static  void method(){
        synchronized (SynchronizedClassClass5.class){
            System.out.println("我是线程=========="+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e) {
            }
            System.out.println("jhhhhhhhhhhhhhhh=================");
        }
    }

    @Override
    public void run() {
        method();
    }
}
