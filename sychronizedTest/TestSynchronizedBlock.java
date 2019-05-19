package sychronizedTest;

public class TestSynchronizedBlock implements Runnable {

    static  TestSynchronizedBlock testSychronized1 = new TestSynchronizedBlock();
    public static void main(String args[]) throws Exception{
        Thread thead1 = new Thread(testSychronized1);
        Thread thead2 = new Thread(testSychronized1);
        thead1.start();
        thead2.start();
    }

    Object a = new Object();
    Object b = new Object();
    @Override
    public void run()  {

        Thread thread = Thread.currentThread();
        synchronized (a){
            System.out.println("我是线程=========="+thread.getName());
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e) {
            }
        }
        synchronized (b) {
            System.out.println("jhhhhhhhhhhhhhhh=================");
        }

    }
}
