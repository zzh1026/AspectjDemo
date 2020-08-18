package com.zzh.motiondemo.aspectj;

import com.blankj.utilcode.util.LogUtils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 车主邦
 * ---------------------------
 * <p>
 * Created by zhaozh on 2020/8/10.
 */
@Aspect
public class LifeLogAspectj {

    @Before("execution(* com.zzh.motiondemo.MainActivity.on*(..))")
    public void lifeLog(JoinPoint joinPoint) {
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            LogUtils.e("LifeLogAspectj ----- " + signature.getMethod().getName());
        } catch (Exception e) {
        }
    }
}
