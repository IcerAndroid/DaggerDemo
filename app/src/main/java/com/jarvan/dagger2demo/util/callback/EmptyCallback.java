package com.jarvan.dagger2demo.util.callback;

import com.jarvan.dagger2demo.R;
import com.kingja.loadsir.callback.Callback;

/**
 * 创建日期：2018/6/6 on 下午4:45
 * 描述:
 * 作者:张冰
 */
public class EmptyCallback extends Callback {
    @Override
    protected int onCreateView() {
        return R.layout.layout_status_empty;
    }
}
