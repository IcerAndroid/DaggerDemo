package com.jarvan.dagger2demo.presenter;

import android.text.TextUtils;

import com.jarvan.dagger2demo.base.BaseEntity;
import com.jarvan.dagger2demo.contract.GankIoContract;
import com.jarvan.dagger2demo.model.bean.GankEntity;
import com.jarvan.dagger2demo.model.bean.GankIoSection;
import com.jarvan.dagger2demo.model.bean.TodayEntity;
import com.jarvan.dagger2demo.model.network.GankService;
import com.jarvan.dagger2demo.model.network.RxSchedulers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 创建日期：2018/6/5 on 下午2:21
 * 描述:
 * 作者:张冰
 */
public class TodayPresenter implements GankIoContract.Presenter {
    private GankService mGankService;
    private GankIoContract.View mView;
    private String lastDate = null;

    @Inject
    public TodayPresenter(GankService gankService, GankIoContract.View view) {
        this.mGankService = gankService;
        this.mView = view;
    }

    @Override
    public void getGankIoDayList() {
        getGankIoDayList(lastDate);
    }

    @Override
    public void getGankIoDayList(String date) {
        boolean flag = TextUtils.isEmpty(date);
        Observable<BaseEntity<TodayEntity>> observable;
        if (flag) {
            observable = mGankService.getHistoryList()
                    .compose(RxSchedulers.ioMain())
                    .doOnNext(entity -> {
                        if (entity.isSuccess()) {
                            mView.onResultHistoryList(entity.getGankIo());
                        }
                    })
                    .observeOn(Schedulers.io())
                    .flatMap(
                            new Function<BaseEntity<List<String>>,
                                    ObservableSource<BaseEntity<TodayEntity>>>() {
                                @Override
                                public ObservableSource<BaseEntity<TodayEntity>> apply(
                                        BaseEntity<List<String>> entity)
                                        throws Exception {
                                    if (entity.isSuccess()) {
                                        String date = entity.getGankIo().get(0);
                                        if (!TextUtils.isEmpty(date)) {
                                            lastDate = date.replace("-", "/");
                                            return mGankService.getGankIoToday(lastDate);
                                        }
                                    }
                                    return null;
                                }
                            });
        } else {
            lastDate = date.replace("-", "/");
            observable = mGankService.getGankIoToday(lastDate);
        }

        observable.compose(RxSchedulers.ioMain())
                .subscribe(new Consumer<BaseEntity<TodayEntity>>() {
                    @Override
                    public void accept(BaseEntity<TodayEntity> baseEntity)
                            throws Exception {
                        if (baseEntity.isSuccess()) {
                            TodayEntity today = baseEntity.getGankIo();
                            List<GankEntity> list = new ArrayList<>();
                            if (today.getAndroidList() != null
                                    && !today.getAndroidList().isEmpty()) {
                                list.add(new GankEntity("Android"));
                                list.addAll(today.getAndroidList());
                            }
                            if (today.getIosList() != null && !today.getIosList().isEmpty()) {
                                list.add(new GankEntity("iOS"));
                                list.addAll(today.getIosList());
                            }
                            if (today.getWebList() != null && !today.getWebList().isEmpty()) {
                                list.add(new GankEntity("前端"));
                                list.addAll(today.getWebList());
                            }
                            if (today.getVideoList() != null && !today.getVideoList().isEmpty()) {
                                list.add(new GankEntity("休息视频"));
                                list.addAll(today.getVideoList());
                            }
                            if (today.getWelfareList() != null
                                    && !today.getWelfareList().isEmpty()) {
                                list.add(new GankEntity("福利"));
                                list.addAll(today.getWelfareList());
                            }
                            if (today.getRecommendList() != null
                                    && !today.getRecommendList().isEmpty()) {
                                list.add(new GankEntity("瞎推荐"));
                                list.addAll(today.getRecommendList());
                            }
                            if (today.getExpandList() != null && !today.getExpandList().isEmpty()) {
                                list.add(new GankEntity("拓展资源"));
                                list.addAll(today.getExpandList());
                            }
                            ArrayList<GankIoSection> sections=new ArrayList<>();
                            for (GankEntity gankEntity : list) {
                                GankIoSection section=new GankIoSection(gankEntity);
                                sections.add(section);
                            }
                            mView.onResultGankIoList(sections);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onFailed(flag, throwable.getMessage());
                    }
                });
    }
}
