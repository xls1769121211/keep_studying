package com.xls.test1;

public class Test1  extends  Thread{
    //private static  Object object = new Object();
   static int count = 0;
    @Override
    public void run() {
        /*String name = getName();
        System.out.println("我是演员"+name);
        System.out.println("这是我的第"+(++count)+"次表演");
        System.out.println("演员"+name+"表演结束");*/
        /*System.out.println("这是我的第"+(++count)+"次表演");*/
        //System.out.println(currentThread().getName()+"============执行=============="+count);
           synchronized (this.getClass()){
               for (int i = 0; i < 10000; i++) {
                   ++count;
               }
           }

    }

    public static void main(String[] args) {
        try {
            Thread test1 = new Test1();
            test1.start();
            Thread test12 = new Test1();
            test12.start();
            Thread test13 = new Test1();
            test13.start();
            test13.join();
            test1.join();
            test12.join();
            System.out.println("最终结果========"+count);
        }catch (Exception e){

        }




    }
}
