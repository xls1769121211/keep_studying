package com.xls.test2;

/**
 *能量转移 任务
 */
public class EnergyTransferTask implements Runnable{
    //能量系统
    private EnergySystem energySystem ;
    private int from;
    private double maxCount;
    //休眠时间
    private int DELAY = 10;
    public EnergyTransferTask(EnergySystem energySystem, int from, double maxCount) {
        this.energySystem = energySystem;
        this.from = from;
        this.maxCount = maxCount;
    }
    @Override
    public void run() {

        try {
            while (true){
                //定义要转移到的盒子
                int toBox = (int) (energySystem.getEnergyLength() * Math.random());
                //或取要转移的能量
                double count = maxCount * Math.random();
                energySystem.transferEnergy(from,toBox,count);
                Thread.sleep((int)(DELAY * Math.random()));
            }
        }catch (Exception e){

        }

    }
}
