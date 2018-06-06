package com.jarvan.dagger2demo.ui.fragment;

import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jarvan.dagger2demo.R;
import com.jarvan.dagger2demo.app.MyApplication;
import com.jarvan.dagger2demo.base.BaseFragment;
import com.jarvan.dagger2demo.base.BaseLazyFragment;
import com.jarvan.dagger2demo.contract.GankIoContract;
import com.jarvan.dagger2demo.di.component.DaggerGankIoComponent;
import com.jarvan.dagger2demo.di.module.GankModule;
import com.jarvan.dagger2demo.model.bean.GankIoSection;
import com.jarvan.dagger2demo.presenter.TodayPresenter;
import com.jarvan.dagger2demo.ui.adapter.BottomSheetAdapter;
import com.jarvan.dagger2demo.ui.adapter.TodayAdapter;
import com.jarvan.dagger2demo.util.callback.ErrorCallback;
import com.jarvan.dagger2demo.util.callback.LoadingCallback;
import com.kingja.loadsir.callback.SuccessCallback;
import com.trello.rxlifecycle2.LifecycleTransformer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * 创建日期：2018/6/5 on 下午2:15
 * 描述:
 * 作者:张冰
 */
public class TodayFragment extends BaseFragment implements GankIoContract.View {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;

    private FloatingActionButton mFabHistory;
    private View mBottomSheetView;
    private TextView mBottomSheetTitle;
    private List<GankIoSection> data = new ArrayList<>();

    //    private BottomSheetDialog mBottomSheetDialog;
//    private BottomSheetAdapter mBottomSheetAdapter;
    @Inject
    TodayPresenter mPresenter;
    private TodayAdapter mAdapter;
    private BottomSheetAdapter mBottomSheetAdapter;
    private BottomSheetDialog mBottomSheetDialog;

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
//        loadService.showCallback(LoadingCallback.class);
        mPresenter.getGankIoDayList();
    }

    @Override
    protected void initData() {
        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            mPresenter.getGankIoDayList();
        });

        mAdapter = new TodayAdapter(data);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);

        mBottomSheetView = View.inflate(getActivity(), R.layout.view_bottom_sheet_gank_history,
                null);
        mBottomSheetTitle = mBottomSheetView.findViewById(R.id.tv_title);
        RecyclerView recyclerView = mBottomSheetView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mBottomSheetAdapter = new BottomSheetAdapter();
        recyclerView.setAdapter(mBottomSheetAdapter);

        mFabHistory.setOnClickListener(v -> {
            if (mBottomSheetAdapter.getData().isEmpty()) {
                Snackbar.make(v, "请刷新后再访问", Snackbar.LENGTH_LONG)
                        .setAction("Ok", v1 -> {
                        })
                        .show();
                return;
            }
            if (mBottomSheetDialog == null) {
                mBottomSheetDialog = new BottomSheetDialog(getActivity());
                mBottomSheetDialog.setContentView(mBottomSheetView);
            }
            mBottomSheetDialog.show();
        });
    }

    @Override
    protected void onNetReload(View v) {
        loadService.showCallback(LoadingCallback.class);
        mPresenter.getGankIoDayList();
    }

    @Override
    public void onResultGankIoList(List list) {
        closeSwipeRefreshLayout();
        mAdapter.setNewData(list);
        loadService.showCallback(SuccessCallback.class);
    }

    @Override
    public void onResultHistoryList(List<String> list) {
        mBottomSheetTitle.setText("今日干货:" + list.get(0));
        mBottomSheetAdapter.setNewData(list);
    }

    @Override
    public void onFailed(boolean isRefresh, String msg) {
        closeSwipeRefreshLayout();
        if (isRefresh) {
            loadService.showCallback(ErrorCallback.class);
        } else {
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    private void closeSwipeRefreshLayout() {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }
}
