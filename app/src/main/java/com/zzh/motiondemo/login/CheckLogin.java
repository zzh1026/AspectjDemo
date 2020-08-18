package com.zzh.motiondemo.login;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 车主邦
 * ---------------------------
 * <p>
 * Created by zhaozh on 2020/7/30.
 */

@Target(ElementType.METHOD)     //限定可以注解在方法上
@Retention(RetentionPolicy.RUNTIME) //运行时存在
public @interface CheckLogin {
}
