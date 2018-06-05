package com.jarvan.dagger2demo.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 创建日期：2018/6/5 on 下午3:39
 * 描述:
 * 作者:张冰
 */
public class TodayEntity {

    @SerializedName("Android")
    private List<GankEntity> androidList;
    @SerializedName("App")
    private List<GankEntity> appList;
    @SerializedName("iOS")
    private List<GankEntity> iosList;
    @SerializedName("前端")
    private List<GankEntity> webList;
    @SerializedName("休息视频")
    private List<GankEntity> videoList;
    @SerializedName("拓展资源")
    private List<GankEntity> expandList;
    @SerializedName("瞎推荐")
    private List<GankEntity> recommendList;
    @SerializedName("福利")
    private List<GankEntity> welfareList;

    public List<GankEntity> getAndroidList() {
        return androidList;
    }

    public void setAndroidList(List<GankEntity> androidList) {
        this.androidList = androidList;
    }

    public List<GankEntity> getAppList() {
        return appList;
    }

    public void setAppList(List<GankEntity> appList) {
        this.appList = appList;
    }

    public List<GankEntity> getIosList() {
        return iosList;
    }

    public void setIosList(List<GankEntity> iosList) {
        this.iosList = iosList;
    }

    public List<GankEntity> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<GankEntity> videoList) {
        this.videoList = videoList;
    }

    public List<GankEntity> getExpandList() {
        return expandList;
    }

    public void setExpandList(List<GankEntity> expandList) {
        this.expandList = expandList;
    }

    public List<GankEntity> getRecommendList() {
        return recommendList;
    }

    public void setRecommendList(List<GankEntity> recommendList) {
        this.recommendList = recommendList;
    }

    public List<GankEntity> getWelfareList() {
        return welfareList;
    }

    public void setWelfareList(List<GankEntity> welfareList) {
        this.welfareList = welfareList;
    }

    public List<GankEntity> getWebList() {
        return webList;
    }
}
