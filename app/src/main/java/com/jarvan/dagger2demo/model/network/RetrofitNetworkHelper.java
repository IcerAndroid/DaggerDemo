package com.jarvan.dagger2demo.model.network;

import org.apache.http.conn.ssl.SSLSocketFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 创建日期：2018/6/4 on 下午4:30
 * 描述:
 * 作者:张冰
 */
public class RetrofitNetworkHelper {
    private static final int TIMEOUT_READ = 20;
    private static final int TIMEOUT_WRITE = 20;
    private static final int TIMEOUT_CONNECTION = 20;

    public static OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
            .sslSocketFactory(TrustManager.getUnsafeOkHttpClient())
            .hostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)
            //打印日志
            .addInterceptor(
                    new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_WRITE, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
            .build();

    public static <T> T createApi(Class<T> clazz, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder().client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
        return retrofit.create(clazz);
    }

}
