package com.xls.spring.aop.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 切面类
 *
 */
@Aspect
public class MathAspect{


    @Pointcut(value = "execution(public int com.xls.spring.aop.service.MathCalculator.*(..))")
    public void pointCut(){}

    /**
     * pointCut 本类使用方式 直接value = @Pointcut 注解的带有execution的方法
     */
    @Before("pointCut()")
    public void methodBefore(JoinPoint joinPoint){
        //方法名
        String methodName = joinPoint.getSignature().getName();
        //方法参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println(""+methodName+"开始之前。。。@Before....参数列表"+ Arrays.asList(args)+"");
    }

    /**
     * 外部类使用可以直接加上全类名
     */
    @After("com.xls.spring.aop.service.MathAspect.pointCut()")
    public void methodAfter(JoinPoint joinPoint){
        //方法名

        String methodName = joinPoint.getSignature().getName();
        System.out.println(""+methodName+"完成之后。。。@After");
    }


    @AfterReturning(value = "pointCut()",returning = "result")
    public void methodAfterReturning(JoinPoint joinPoint,Object result){
        //方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println(""+methodName+"方法完成之后  @AfterReturning并输出结果。。。{"+result+"}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void methodThrowing(JoinPoint joinPoint,Exception exception){
        //方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println(""+methodName+"抛出异常。。 @AfterThrowing....。{"+exception+"}");
    }


}
