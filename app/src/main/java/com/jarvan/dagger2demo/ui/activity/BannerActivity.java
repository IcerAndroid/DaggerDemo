package com.jarvan.dagger2demo.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jarvan.dagger2demo.R;
import com.jarvan.dagger2demo.base.BaseActivity;
import com.jarvan.dagger2demo.customview.BannerLayoutManager;
import com.jarvan.dagger2demo.ui.adapter.BannerAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * 创建日期：2018/6/11 on 下午3:41
 * 描述:
 * 作者:张冰
 */
public class BannerActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_banner;
    }

    @Override
    protected void initView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        BannerAdapter adapter = new BannerAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new BannerLayoutManager());
        List<String> data = Arrays.asList("复仇者联盟3", "巴啦啦小魔仙", "亨通光电的崛起");
        adapter.setNewData(data);
    }

    @Override
    protected boolean hasToolbarTitle() {
        return false;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initNet() {

    }

    @Override
    protected void onNetReload(View v) {

    }
}
