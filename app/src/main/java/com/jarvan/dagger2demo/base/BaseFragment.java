package com.jarvan.dagger2demo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * 创建日期：2018/6/5 on 上午11:28
 * 描述:
 * 作者:张冰
 */
public abstract class BaseFragment extends RxFragment implements BaseView {

    protected LoadService loadService;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = View.inflate(getActivity(), getlayoutId(), null);
        loadService = LoadSir.getDefault().register(rootView,
                (Callback.OnReloadListener) this::onNetReload);
        return loadService.getLoadLayout();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        if (!islazy()) {
            loadNet();
            initData();
        }
    }

    /**
     * 是否懒加载
     */
    protected boolean islazy() {
        return false;
    }

    protected abstract int getlayoutId();

    protected abstract void initView(View view);

    protected abstract void loadNet();

    protected abstract void initData();

    protected abstract void onNetReload(View v);

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return super.bindToLifecycle();
    }
}
