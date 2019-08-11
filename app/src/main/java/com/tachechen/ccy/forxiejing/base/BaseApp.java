package com.tachechen.ccy.forxiejing.base;

import android.app.Application;
import android.content.res.Configuration;

public class BaseApp extends Application {

    //Application类可用来初始化全局变量

    private static BaseApp baseApp;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApp = this;
    }

    public static BaseApp getInstance(){
        return baseApp;
    }

    /**
     * 通知 应用程序 当前内存使用情况（以内存级别进行识别）
     * @param level  内存使用等级
     */
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

    }

    /**
     *     作用：监听 Android系统整体内存较低时刻
     *     调用时刻：Android系统整体内存较低时
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    /**
     * 作用：监听 应用程序 配置信息的改变，如屏幕旋转等
     * 调用时刻：应用程序配置信息 改变时调用
     * @param newConfig  Manifest.xml文件下的 Activity标签属性android:configChanges的值
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    /**
     *     作用：注册时， 应用程序内 所有Activity的生命周期监听
     *     调用时刻：当应用程序内 Activity生命周期发生变化时就会调用
     * @param callback  activity生命周期变化回调
     */
    @Override
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.registerActivityLifecycleCallbacks(callback);

    }

    @Override
    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.unregisterActivityLifecycleCallbacks(callback);

    }
}
