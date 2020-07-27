package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * description:用于记录日志的工具类，他提供了公共的代码
 *
 * @author xuqiangsheng
 * @date 2020/7/27 9:02
 */
@Component("logger")
//表示当前类是一个切面
@Aspect
public class Logger {

    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    private void pt1(){}

    /**
     * 前置通知
     */
    @Before("pt1()")
    public void beforePrintLog(){
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志了。。。。");
    }

    /**
     * 后置通知
     */
    @After("pt1()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法开始记录日志了。。。。");
    }

    /**
     * 异常通知
     */
    @AfterThrowing("pt1()")
    public void afterThrowingPrintLog(){
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志了。。。。");
    }

    /**
     * 最终通知
     */
    @AfterReturning("pt1()")
    public void afterPrintLog(){
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了。。。。");

    }

    /**
     * 环绕通知
     * 问题:
     *      当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了
     * 分析:
     *      通过对比动态代理中的环绕通知的方法发现动态代理中的环绕通知有明确的切入点方法调用，而我们的方法中没有
     * 解决：
     *      Spring框架为我们提供了一个接口：ProceedingJoinPoint，该接口有个方法叫做proceed()，此方法就相当于明确调用切入点方法
     *      该接口可以作为环绕通知的方法参数，在程序执行时，Spring框架会为我们提供该方法的实现类供我们使用。
     * Spring中的环绕通知：
     *      他是Spring框架为我们提供的一种可以再代码中手动控制增强方法何时执行的方式。
     */
//    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        //明确调用业务层方法(切入点方法)
        try {
            //得到方法执行所需的参数
            Object[] args = pjp.getArgs();
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。。前置通知");
            rtValue = pjp.proceed(args);
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。。后置通知");
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。。异常通知");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。。最终通知");
        }
    }

}
