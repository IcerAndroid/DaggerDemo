package com.jarvan.dagger2demo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;

import com.jarvan.dagger2demo.R;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * 创建日期：2018/6/5 on 上午10:10
 * 描述: 基础activity
 * 作者:张冰
 */
public abstract class BaseActivity extends RxAppCompatActivity {

    private LoadService loadService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = View.inflate(this, R.layout.activity_base, null);
        final FrameLayout flContent = (FrameLayout) rootView.findViewById(R.id.fl_content);
        if (hasToolbarTitle()) {
            ViewStub viewStub = (ViewStub) rootView.findViewById(R.id.vs_toolbar);
            viewStub.inflate();
        }
        View content = View.inflate(this, getLayoutId(), null);
        if (content != null) {
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
            flContent.addView(content, params);
//            loadService = LoadSir.getDefault().register(content, (Callback.OnReloadListener) this::onNetReload);
        }
        setContentView(rootView);
        initNet();
        initView();
        initData();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract boolean hasToolbarTitle();

    protected abstract void initData();

    protected abstract void initNet();

    protected abstract void onNetReload(View v);
}
