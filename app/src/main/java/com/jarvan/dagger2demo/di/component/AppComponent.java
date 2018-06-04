package com.jarvan.dagger2demo.di.component;

import android.app.Application;

import com.jarvan.dagger2demo.di.module.AppModule;
import com.jarvan.dagger2demo.di.module.NetworkModule;
import com.jarvan.dagger2demo.model.network.GankService;

import dagger.Component;

/**
 * 创建日期：2018/6/4 on 下午8:56
 * 描述:
 * 作者:张冰
 */
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    Application getApplication();

    GankService getGankService();

}
