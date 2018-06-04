package com.jarvan.dagger2demo.app;

import android.app.Application;

import com.jarvan.dagger2demo.di.component.AppComponent;
import com.jarvan.dagger2demo.di.component.DaggerAppComponent;
import com.jarvan.dagger2demo.di.module.AppModule;
import com.jarvan.dagger2demo.di.module.NetworkModule;

/**
 * 创建日期：2018/6/4 on 下午8:59
 * 描述:
 * 作者:张冰
 */
public class MyApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }
}
