package com.zzh.motiondemo.aspectj;

import android.graphics.Paint;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.zzh.motiondemo.utils.NoDoubleClickUtils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 车主邦
 * ---------------------------
 * <p>
 * Created by zhaozh on 2020/8/10.
 * 避免双重点击的切面
 */
@Aspect
public class DoubleClickAspectJ {
    private boolean isCanDoubleClick = false;

    @Before("execution(@com.zzh.motiondemo.login.CanDoubleClick * *(..))")
    public void beforeEnableDoubleClick(JoinPoint point) throws Throwable {
        LogUtils.e("beforeEnableDoubleClick: ");
        isCanDoubleClick = true;
    }

    /**
     * 找到处理的切点
     */
    @Pointcut("execution(* android.view.View.OnClickListener.onClick(..))")
    public void executionDoubleClick() {

    }

    @Around("executionDoubleClick()")
    public void onClickListener(ProceedingJoinPoint joinPoint) throws Throwable {
        LogUtils.e("点击了View");
        if (isCanDoubleClick || !NoDoubleClickUtils.isDoubleClick()) {
            LogUtils.e("可以继续往下走");
            joinPoint.proceed();
            isCanDoubleClick = false;
        } else {
            LogUtils.e("双重点击, 不可继续");
        }
    }

}
