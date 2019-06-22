package com.xls.test2;


/**
 * 模拟宇宙中的能量转移
 * 符合能量守恒定律
 */
public class EnergySystem{
    //能量全部装在能量盒子中，用数组模拟盒子
    private static Object object = new Object();

    double [] energyBoxes ;

    //初始化盒子大小和每个盒子的能量
    public EnergySystem(int boxSize,double eachBoxEnergy) {
        energyBoxes = new double[boxSize];
        for (int i = 0; i < boxSize; i++) {
            energyBoxes[i] = eachBoxEnergy;
        }
    }
    //转移函数，模拟能量传递但是 总和不变
    public void transferEnergy(int from,int to, double count){
        //在这个地方加上锁
       synchronized (object){
           try {
               while (energyBoxes[from] < count){
                   object.wait();
               }
               //from减少 count
               energyBoxes[from] -= count;
               //to 增加count
               energyBoxes[to] += count;
               System.out.printf("能量从盒子%d到盒子%d转移了%10.2f的能量",from,to,count);
               System.out.printf("宇宙总能量是%10.2f%n",getAllEnergyCount());

               object.notifyAll();
           }catch (Exception e){
                e.printStackTrace();
           }


       }
    }
    //计算能量总和
    public double getAllEnergyCount(){
        double sum = 0;
        for (int i = 0; i < energyBoxes.length ;i++) {
            sum += energyBoxes[i];
        }
        return sum;
    }

    //或去盒子长度
    public  int getEnergyLength(){
        return  energyBoxes.length;
    }
}
