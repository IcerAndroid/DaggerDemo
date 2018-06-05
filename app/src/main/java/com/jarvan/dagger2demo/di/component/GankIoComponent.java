package com.jarvan.dagger2demo.di.component;

import com.jarvan.dagger2demo.di.module.GankModule;
import com.jarvan.dagger2demo.ui.fragment.TodayFragment;

import dagger.Component;

/**
 * 创建日期：2018/6/5 on 下午4:52
 * 描述:
 * 作者:张冰
 */
@Component(modules = GankModule.class,dependencies = AppComponent.class)
public interface GankIoComponent {
    void inject(TodayFragment fragment);
}
