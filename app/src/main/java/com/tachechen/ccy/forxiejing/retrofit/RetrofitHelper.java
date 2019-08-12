package com.tachechen.ccy.forxiejing.retrofit;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    private static RetrofitHelper retrofitHelper;
    private static Retrofit retrofit;
    private OkHttpClient okHttpClient;

    private RetrofitHelper(){
        initBuild();
    }

    public static RetrofitHelper getInstance(){
        if(retrofitHelper == null)
            retrofitHelper = new RetrofitHelper();
        return retrofitHelper;
    }

    private void initBuild() {
        buildOkhttp();
        buildRetrofit();
    }

    private void buildOkhttp() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {

            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient()
                .newBuilder()
                .addNetworkInterceptor(httpLoggingInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    private void buildRetrofit() {
        retrofit = new Retrofit.Builder()
//                .baseUrl()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static RetrofitService getService(){
        return retrofit.create(RetrofitService.class);
    }
}
