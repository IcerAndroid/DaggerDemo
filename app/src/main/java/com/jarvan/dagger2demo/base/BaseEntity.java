package com.jarvan.dagger2demo.base;

import com.google.gson.annotations.SerializedName;

/**
 * 创建日期：2018/6/5 on 下午2:40
 * 描述:
 * 作者:张冰
 */
public class BaseEntity<T> {

    private boolean error;
    @SerializedName("results")
    private T gankIo;

    public boolean isSuccess(){
        return !error;
    }

    public boolean isError() {
        return error;
    }

    public T getGankIo() {
        return gankIo;
    }
}
