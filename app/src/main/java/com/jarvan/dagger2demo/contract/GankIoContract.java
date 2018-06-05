package com.jarvan.dagger2demo.contract;

import com.jarvan.dagger2demo.base.BaseView;

import java.util.List;

/**
 * 创建日期：2018/6/5 on 下午2:23
 * 描述:
 * 作者:张冰
 */
public interface GankIoContract {

    interface View extends BaseView{

        void onResultGankIoList(List list);

        void onResultHistoryList(List<String> list);

        void onFailed(boolean isRefresh, String msg);
    }

    interface Presenter{

        void getGankIoDayList();

        void getGankIoDayList(String date);
    }
}
