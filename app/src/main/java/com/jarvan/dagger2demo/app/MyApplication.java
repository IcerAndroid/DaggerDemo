package com.jarvan.dagger2demo.app;

import android.app.Application;

import com.jarvan.dagger2demo.di.component.AppComponent;
import com.jarvan.dagger2demo.di.component.DaggerAppComponent;
import com.jarvan.dagger2demo.di.module.AppModule;
import com.jarvan.dagger2demo.di.module.NetworkModule;
import com.jarvan.dagger2demo.util.callback.EmptyCallback;
import com.jarvan.dagger2demo.util.callback.ErrorCallback;
import com.jarvan.dagger2demo.util.callback.LoadingCallback;
import com.kingja.loadsir.callback.SuccessCallback;
import com.kingja.loadsir.core.LoadSir;

/**
 * 创建日期：2018/6/4 on 下午8:59
 * 描述:
 * 作者:张冰
 */
public class MyApplication extends Application {

    private AppComponent mAppComponent;
    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .setDefaultCallback(SuccessCallback.class)
                .commit();
    }

    public static MyApplication getApplication() {
        return application;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
