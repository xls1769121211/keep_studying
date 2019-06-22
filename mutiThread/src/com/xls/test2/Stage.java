package com.xls.test2;

/**
 * 战场
 */
public class Stage extends Thread{

    //开站时间
    private long time;
    public Stage(long time) {
        this.time = time;
    }
    //战场的线程
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println();
            //定义2个军队
            ArmyRunnable armyRunnable_A = new ArmyRunnable();
            ArmyRunnable armyRunnable_B = new ArmyRunnable();

            //将两个军队调度
            Thread thread_A = new Thread(armyRunnable_A,"隋军");
            Thread thread_B = new Thread(armyRunnable_B,"农民军");

            //开打
            thread_A.start();
            thread_B.start();

            //打多长时间？

                Thread.sleep(time);
                //此时半路杀出程咬金
                Thread cheng = new KeyPerson();
                cheng.setName("程咬金");
                // 军队停止战斗，看
                armyRunnable_A.attack = false;
                armyRunnable_B.attack = false;
                cheng.start();
                Thread.sleep(time);
                cheng.join();
            }catch (Exception e){
        }
    }


    // 开启战场
    public static void main(String[] args) {
        Thread stage = new Stage(100);
        stage.start();
    }
}
