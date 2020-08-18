package com.zzh.motiondemo.aspectj;

import com.blankj.utilcode.util.LogUtils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 车主邦
 * ---------------------------
 * <p>
 * Created by zhaozh on 2020/7/30.
 */
//@Aspect
public class ToLoginAspectJ {
    public void logs() {
        LogUtils.e("呵呵");
    }
//
//    /**
//     * 找到处理的切点
//     */
//    @Pointcut("call(* com.zzh.motiondemo.MainActivity.tologin(..))")
//    public void toLogin() {
//
//    }
//
//    /**
//     * 处理切面
//     */
//    @Before("toLogin()")
//    public void checkLogin(JoinPoint joinPoint) throws Throwable {
//        Object aThis = joinPoint.getThis();
//        LogUtils.e("=============调用toLogin==============" + aThis.toString());
//    }
//
//    @After("toLogin()")
//    public void checkLoginAfter(JoinPoint joinPoint) throws Throwable {
//        Object target = joinPoint.getTarget();
//        LogUtils.e("=============调用toLogin完毕==============" + target.toString());
//    }
}
