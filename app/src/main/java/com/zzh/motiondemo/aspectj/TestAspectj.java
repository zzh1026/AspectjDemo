package com.zzh.motiondemo.aspectj;

import com.blankj.utilcode.util.LogUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 车主邦
 * ---------------------------
 * <p>
 * Created by zhaozh on 2020/8/10.
 */
@Aspect
public class TestAspectj {

    @Pointcut("execution(* com.zzh.motiondemo.MainActivity.testAdvice(..))")
    public void onTestMethod() {
    }

    @Before("onTestMethod()")
    public void testBefore() {
        LogUtils.e("将内容添加到方法内部的头部");
    }

    @After("onTestMethod()")
    public void testAfter() {
        LogUtils.e("将内容添加到方法内部的尾部");
    }

    @Around("execution(* com.zzh.motiondemo.MainActivity.testAdvice1(..))")
    public void testAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LogUtils.e("testAround 之前的头部");
//        proceedingJoinPoint.proceed();
        LogUtils.e("testAround 之前的尾部");
    }

    @AfterReturning(value = "execution(* com.zzh.motiondemo.MainActivity.testAdvice2(..))", returning = "result")
    public void testAfterReturning(String result) {
        LogUtils.e("testAfterReturning 收到了返回值:" + result);
    }

    @Pointcut("execution(* com.zzh.motiondemo.MainActivity.testAdvice3(..))")
    public void onThrowException() {
    }

    @Around(value = "onThrowException()")
    public void testTryCatchThrowing(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LogUtils.e("尝试try起来");
        try {
            proceedingJoinPoint.proceed();
        } catch (Exception e) {
            LogUtils.e("捕获到了异常: " + e.getMessage());
        }
    }

    @AfterThrowing(pointcut = "onThrowException()", throwing = "exception")
    public void testAfterThrowing(Exception exception) {
        LogUtils.e("testAfterThrowing 抛出了错误 :" + exception.getMessage());
    }
}
