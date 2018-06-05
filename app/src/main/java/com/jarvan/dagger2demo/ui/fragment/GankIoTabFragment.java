package com.jarvan.dagger2demo.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jarvan.dagger2demo.R;
import com.jarvan.dagger2demo.base.BaseFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 创建日期：2018/6/5 on 上午11:39
 * 描述:
 * 作者:张冰
 */
public class GankIoTabFragment extends BaseFragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_tab_layout;
    }

    @Override
    protected void initView(View view) {
        mTabLayout = view.findViewById(R.id.tab_layout);
        mViewPager = view.findViewById(R.id.view_pager);


    }

    @Override
    protected void loadNet() {

    }

    @Override
    protected void initData() {
        final List<String> titleList = Arrays.asList("今日干货", "分类", "福利");
        final List<Fragment> fragmentList = new ArrayList<>(titleList.size());

    }

    @Override
    protected void onNetReload(View v) {

    }
}
