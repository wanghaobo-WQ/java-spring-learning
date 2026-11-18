package com.zhangguowen.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnoAdvice {

    // 切点：dao 包下所有类的所有方法
    @Pointcut("execution(* com.zhangguowen.dao.*.*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("这是环绕通知之前的部分!");
        Object result = pjp.proceed();   // 真正去执行目标方法
        System.out.println("这是环绕通知之后的部分!");
        return result;
    }

    @Before("pointCut()")
    public void before(JoinPoint jp) {
        System.out.println("这是前置通知! 目标类: " + jp.getTarget().getClass().getName()
                + "; 目标方法: " + jp.getSignature().getName());
    }

    @AfterReturning(pointcut = "pointCut()", returning = "result")
    public void afterReturning(JoinPoint jp, Object result) {
        System.out.println("这是返回通知! 方法: " + jp.getSignature().getName() + ", 返回值: " + result);
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Throwable e) {
        System.out.println("这是异常通知! 方法: " + jp.getSignature().getName() + " 异常: " + e);
    }

    @After("pointCut()")
    public void after(JoinPoint jp) {
        System.out.println("这是后置通知!");
    }
}