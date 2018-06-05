package com.jarvan.dagger2demo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * 创建日期：2018/6/5 on 上午11:33
 * 描述:
 * 作者:张冰
 */
public abstract class BaseLazyFragment extends BaseFragment {

    boolean isVisible = false;
    private boolean isPrepared = false;
    private boolean isFirst = true;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isPrepared = true;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(getUserVisibleHint()){
            isVisible=true;
            lazyLoad();
        }else {
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * 懒加载
     */
    private void lazyLoad() {
        if (!isPrepared || !isVisible || !isFirst) {
            return;
        }
        loadNet();
        initData();
        isFirst = false;
    }

    @Override
    protected boolean islazy() {
        return true;
    }

    /**
     * fragment被设置为不可见时调用
     */
    protected abstract void onInvisible();

}
