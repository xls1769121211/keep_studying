package com.xls.schedule;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 使用quartz执行定时任务的main类
 */
public class QuartzMain{
    public static void main(String[] args) throws Exception {
        /**
         * 1创建Job任务，要做什么事
         * 参数是实现了Job接口的实现类
         */
        JobDetail jobDetail = JobBuilder.newJob(QuartzDemo.class).build();

        /**
         * 2定义什么时候去执行
         * 包括2种时间表达式 1 是Quartz 提供的简单类型的时间表达式
         * 2是使用corn表达式
         */
       // Trigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever()).build();
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();


        /**
         * 3什么时候做什么事情，定义schedule
         *
         */
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobDetail,trigger);

        scheduler.start();
    }
}

