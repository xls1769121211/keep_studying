package com.xls.config;

import com.xls.schedule.QuartzDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 *整合Springboot和Quartz的配置类
 */
@Configuration
public class QuartzConfig{
    /**
     * 1创建任务详情，
     */
    @Bean
    public JobDetailFactoryBean geneJobDetailFactoryBean(){
        JobDetailFactoryBean jobDetailFactoryBea = new JobDetailFactoryBean();

        //设置任务类
        jobDetailFactoryBea.setJobClass(QuartzDemo.class);

        return  jobDetailFactoryBea;
    }

    /**
     * 2创建任务执行时间
     * 简单时间格式
     */
    @Bean
    public SimpleTriggerFactoryBean geneSimpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        //关联 任务详情
        simpleTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());

        //设置时间 毫秒数
        simpleTriggerFactoryBean.setRepeatInterval(3000);
        //重复次数
        simpleTriggerFactoryBean.setRepeatCount(5);
        return  simpleTriggerFactoryBean;
    }

    /**
     * 2创建任务执行时间
     * Cron时间格式
     */
    @Bean
    public CronTriggerFactoryBean geneCronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        //关联 任务详情
        cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        cronTriggerFactoryBean.setCronExpression("0/2 * * * * ?");

        return  cronTriggerFactoryBean;
    }

    /**
     * 3创建定时任务
     */
    @Bean
    public SchedulerFactoryBean geneSchedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactoryBean,CronTriggerFactoryBean cronTriggerFactoryBean,MyAdt myadapt){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();

        //设置定时时间
     //   schedulerFactoryBean.setTriggers(simpleTriggerFactoryBean.getObject());
       schedulerFactoryBean.setTriggers(cronTriggerFactoryBean.getObject());
        //schedulerFactoryBean.setJobFactory(myadapt);
        return  schedulerFactoryBean;
    }
}
