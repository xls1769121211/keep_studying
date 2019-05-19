package sychronizedTest;

public class TestSychronized implements Runnable{

    static  TestSychronized testSychronized = new TestSychronized();
    static int i = 0;
    public static void main(String args[]) throws Exception{
        Thread thead1 = new Thread(testSychronized);
        Thread thead2 = new Thread(testSychronized);
        thead1.start();
        thead2.start();
        //确保两个线程都执行完了
        thead1.join();
        thead2.join();

        System.out.println(i);
    }

    @Override
    public synchronized void run() {
        for (int j = 0; j < 100000; j++) {
            i++;
        }
    }
}
