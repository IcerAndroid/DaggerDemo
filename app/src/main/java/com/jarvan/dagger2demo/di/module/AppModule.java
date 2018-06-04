package com.jarvan.dagger2demo.di.module;

import android.app.Application;

import dagger.Module;

/**
 * 创建日期：2018/6/4 on 下午4:00
 * 描述:
 * 作者:张冰
 */
@Module
public class AppModule {

    private Application mApplication;

    public AppModule(Application application){

    }
}
