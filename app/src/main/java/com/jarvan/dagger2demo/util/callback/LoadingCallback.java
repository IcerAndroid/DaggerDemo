package com.jarvan.dagger2demo.util.callback;

import com.jarvan.dagger2demo.R;

/**
 * 创建日期：2018/6/5 on 下午6:28
 * 描述:
 * 作者:张冰
 */
public class LoadingCallback extends com.kingja.loadsir.callback.Callback {
    @Override
    protected int onCreateView() {
        return R.layout.layout_status_loading;
    }
}
