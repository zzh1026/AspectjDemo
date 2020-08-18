package com.zzh.motiondemo.utils;

/**
 * 车主邦
 * ---------------------------
 * <p>
 * Created by zhaozh on 2020/8/10.
 * <p>
 * 防止按钮连续多次点击
 */
public class NoDoubleClickUtils {
    private final static int SPACE_TIME = 1000;  //每次点击的间隔时间，单位ms

    private static long lastClickTime;  //标记上次点击的时间

    public synchronized static boolean isDoubleClick() {
        long currentTime = System.currentTimeMillis();
        boolean isDoubleClick = currentTime - lastClickTime < SPACE_TIME;
        if (!isDoubleClick) {
            lastClickTime = currentTime;
        }
        return isDoubleClick;
    }
}
