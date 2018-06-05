package com.jarvan.dagger2demo.model.network;

import com.jarvan.dagger2demo.base.BaseEntity;
import com.jarvan.dagger2demo.model.bean.GankEntity;
import com.jarvan.dagger2demo.model.bean.TodayEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 创建日期：2018/6/4 on 下午4:04
 * 描述: 网络请求接口
 * 作者:张冰
 */
public interface GankService {
    String BASE_URL = "http://gank.io/";

    @GET("api/day/history")
    Observable<BaseEntity<List<String>>> getHistoryList();

    @GET("api/day/{date}")
    Observable<BaseEntity<TodayEntity>> getGankIoToday(@Path("date") String date);

    @GET("api/data/{category}/{count}/{page}")
    Observable<BaseEntity<List<GankEntity>>> getGankIoList(@Path("category") String category,
            @Path("count") int count,
            @Path("page") int page);
}
