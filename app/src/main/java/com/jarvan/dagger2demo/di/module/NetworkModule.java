package com.jarvan.dagger2demo.di.module;

import com.jarvan.dagger2demo.model.network.GankService;
import com.jarvan.dagger2demo.model.network.RetrofitNetworkHelper;

import dagger.Module;
import dagger.Provides;

/**
 * 创建日期：2018/6/4 on 下午4:01
 * 描述:
 * 作者:张冰
 */
@Module
public class NetworkModule {

    @Provides
    GankService provideGankService(){
        return RetrofitNetworkHelper.createApi(GankService.class,GankService.BASE_URL);
    }

}
