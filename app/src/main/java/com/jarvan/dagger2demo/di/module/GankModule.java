package com.jarvan.dagger2demo.di.module;

import com.jarvan.dagger2demo.contract.GankIoContract;

import dagger.Module;
import dagger.Provides;

/**
 * 创建日期：2018/6/4 on 下午4:01
 * 描述:
 * 作者:张冰
 */
@Module
public class GankModule {

    private GankIoContract.View todayGankIoView;

    public GankModule(GankIoContract.View view) {
        this.todayGankIoView = view;
    }

    @Provides
    public GankIoContract.View provideTodayGankIoView(){
        return todayGankIoView;
    }
}
