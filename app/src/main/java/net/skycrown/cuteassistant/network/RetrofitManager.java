package net.skycrown.cuteassistant.network;

import net.skycrown.cuteassistant.network.gson.CustomGsonConverterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by wjd on 2018/6/10.
 * 创建retrofit实例
 */

public enum RetrofitManager {
    INSTANCE;
    private OkHttpClient mOkHttpClient;
    private static final int TIME_OUT = 60;

    public Retrofit newRetrofit(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(CustomGsonConverterFactory.create())
                .build();
        return retrofit;
    }

    RetrofitManager() {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpBuilder.addInterceptor(httpLoggingInterceptor);

        //okhttp 设置超时
        okHttpBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);

        //错误重连
        okHttpBuilder.retryOnConnectionFailure(true);

        mOkHttpClient = okHttpBuilder.build();
    }

}
