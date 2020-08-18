package com.zzh.motiondemo.aspectj;

import android.content.Context;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.zzh.motiondemo.MyApplication;
import com.zzh.motiondemo.login.CheckLogin;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 车主邦
 * ---------------------------
 * <p>
 * Created by zhaozh on 2020/7/30.
 */
@Aspect
public class CheckLoginAspectJ {

    /**
     * 找到处理的切点
     */
    @Pointcut("execution(@com.zzh.motiondemo.login.CheckLogin * *(..))")
    public void executionCheckLogin() {

    }

    /**
     * 处理切面
     */
    @Around("executionCheckLogin()")
    public Object checkLogin(ProceedingJoinPoint joinPoint) throws Throwable {
        LogUtils.e("checkLogin: ");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        CheckLogin checkLogin = signature.getMethod().getAnnotation(CheckLogin.class);
        if (checkLogin != null) {
            Context context = (Context) joinPoint.getThis();
            if (MyApplication.isLogin) {
                LogUtils.e("checkLogin: 登录成功 继续");
                return joinPoint.proceed();
            } else {
                LogUtils.e("checkLogin: 未登录需要登录");
                ToastUtils.showShort("未登录,需要登录");
                return null;
            }
        }
        return joinPoint.proceed();
    }
}
