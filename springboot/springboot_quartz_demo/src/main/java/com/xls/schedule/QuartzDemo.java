package com.xls.schedule;

import com.xls.Service.UserService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 *自定义Job类，实现Job接口
 */
public class QuartzDemo implements Job{

    @Autowired
    private UserService userService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("QuartzDemo============"+new Date());
        this.userService.SaveUser();
    }
}
