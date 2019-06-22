package com.xls.test1;

public class Test2 extends  Thread{


    @Override
    public void run() {
        int count = 0;
        String name = getName();
        boolean show = true;
        while (show){
            try {
                System.out.println("这是1"+name+"的第"+(++count)+"次表演");
                if (count > 100){
                    show = false;
                }
                if (count % 10 == 0){

                    Thread.sleep(3000);
                }
            }catch (Exception e){

            }
        }
    }
    public static void main(String[] args) {
        Thread thread = new Test2();
        thread.setName("Mr.Thread");
        thread.start();
        Thread thread1 = new Thread(new Test3(),"Ms.Runnable");
        thread1.start();
    }
}

class Test3 implements Runnable{
    @Override
    public void run() {
        int count = 0;
        String name = Thread.currentThread().getName();
        boolean show = true;
        while (show){
            try {
                System.out.println("这是"+name+"的第"+(++count)+"次表演");
                if (count > 100){
                    show = false;
                }
                if (count % 10 == 0){
                    Thread.sleep(3000);
                }
            }catch (Exception e){

            }
        }
    }
}
