package com.xls.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Schedule{
    /**
     * 	 * @Scheduled:设置定时任务
     * 	 * cron属性：cron表达式。定时任务触发是时间的一个字符串表达形式
     */
    @Scheduled(cron = "0/2 * * * * ?")
    public void TestSchedule1(){
        System.out.println("定时器被触发=================="+new Date());
    }
}
