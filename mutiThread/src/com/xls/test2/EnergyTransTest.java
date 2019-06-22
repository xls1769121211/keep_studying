package com.xls.test2;

public class EnergyTransTest{
    //定义盒子大小
    private static final int BOX_SIZE  = 100;
    //每个盒子中能量大小
    private  static final double BOX_ENERGY_SIZE = 1000;

    public static void main(String[] args) {
        //初始化宇宙能量
        EnergySystem energySystem = new EnergySystem(BOX_SIZE,BOX_ENERGY_SIZE);

        for (int i = 0; i < BOX_SIZE; i++) {
            EnergyTransferTask energyTransferTask = new EnergyTransferTask(energySystem,i,BOX_ENERGY_SIZE);
            Thread thread = new Thread(energyTransferTask);
            thread.start();
        }
    }
}
