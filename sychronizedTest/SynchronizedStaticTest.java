package sychronizedTest;

public class SynchronizedStaticTest  implements  Runnable{


    static  SynchronizedStaticTest testSychronized1 = new SynchronizedStaticTest();
    static  SynchronizedStaticTest testSychronized2 = new SynchronizedStaticTest();
    public static void main(String args[]) throws Exception{
        Thread thead1 = new Thread(testSychronized1);
        Thread thead2 = new Thread(testSychronized2);
        thead1.start();
        thead2.start();
    }

    public static synchronized void method(){

        System.out.println("我是线程=========="+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e) {
        }
        System.out.println("jhhhhhhhhhhhhhhh=================");
    }


    @Override
    public void run()  {
        method();
    }
}
