package com.jarvan.dagger2demo.ui.fragment;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jarvan.dagger2demo.R;
import com.jarvan.dagger2demo.app.MyApplication;
import com.jarvan.dagger2demo.base.BaseLazyFragment;
import com.jarvan.dagger2demo.contract.GankIoContract;
import com.jarvan.dagger2demo.di.component.DaggerGankIoComponent;
import com.jarvan.dagger2demo.di.module.GankModule;
import com.jarvan.dagger2demo.presenter.TodayPresenter;
import com.jarvan.dagger2demo.util.callback.LoadingCallback;
import com.trello.rxlifecycle2.LifecycleTransformer;

import java.util.List;

import javax.inject.Inject;

/**
 * 创建日期：2018/6/5 on 下午2:15
 * 描述:
 * 作者:张冰
 */
public class TodayFragment extends BaseLazyFragment implements GankIoContract.View {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;

    private FloatingActionButton mFabHistory;
    private View mBottomSheetView;
    private TextView mBottomSheetTitle;

    //    private BottomSheetDialog mBottomSheetDialog;
//    private BottomSheetAdapter mBottomSheetAdapter;
    @Inject
    TodayPresenter mPresenter;

    @Override
    protected void onInvisible() {

    }

    @Override
    protected int getlayoutId() {
        return R.layout.layout_refresh_recycler;
    }

    @Override
    protected void initView(View view) {
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        mFabHistory = (FloatingActionButton) view.findViewById(R.id.fab_history);
        mFabHistory.setVisibility(View.VISIBLE);
        DaggerGankIoComponent.builder()
                .appComponent(MyApplication.getApplication().getAppComponent())
                .gankModule(new GankModule(this))
                .build().inject(this);
    }

    @Override
    protected void loadNet() {
        loadService.showCallback(LoadingCallback.class);
        mPresenter.getGankIoDayList();

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onNetReload(View v) {

    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return null;
    }

    @Override
    public void onResultGankIoList(List list) {

    }

    @Override
    public void onResultHistoryList(List<String> list) {

    }

    @Override
    public void onFailed(boolean isRefresh, String msg) {

    }
}
