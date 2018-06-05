package com.jarvan.dagger2demo.ui.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.jarvan.dagger2demo.R;
import com.jarvan.dagger2demo.app.MyApplication;
import com.jarvan.dagger2demo.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private Toolbar mToolbar;
    private BottomNavigationView.OnNavigationItemSelectedListener mSelectedListener =
            item -> {
                switch (item.getItemId()) {
                    case R.id.navigation_gankio:
                        break;
                    case R.id.navigation_xd:
                        break;
                    case R.id.navigation_personal:
                        break;
                }
                return false;
            };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mToolbar = findViewById(R.id.toolbar);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mSelectedListener);

        setSupportActionBar(mToolbar);
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

    private void showFragment(int index){
        setToolbarTitle(index);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideFragment(fragmentTransaction);
        switch (index){
            case 0:

                break;

        }
    }

    private void hideFragment(FragmentTransaction fragmentTransaction) {

    }

    private void setToolbarTitle(int index) {
        switch (index) {
            case 0:
                mToolbar.setTitle("干货");
                break;
            case 1:
                mToolbar.setTitle("闲读");
                break;
            case 2:
                mToolbar.setTitle("个人中心");
                break;
        }
    }

}