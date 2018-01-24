package com.lgy.utilslibrary.retrofit;

import com.lgy.utilslibrary.retrofit.converter.CustomGsonConverterFactory;
import com.lgy.utilslibrary.retrofit.interceptor.LoggingInterceptor;
import com.lgy.utilslibrary.utils.LogUtil;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by WuXiaolong on 2016/3/24.
 * github:https://github.com/WuXiaolong/
 * 微信公众号：吴小龙同学
 * 个人博客：http://wuxiaolong.me/
 */
public class ApiClient {
    //baseUrl
    String API_SERVER_URL = "http://find.kjjl100.com/app/";
    public Retrofit mRetrofit;

    public static ApiClient getInstance() {
        return CreateApiClient.API_CLIENT;
    }

    static class CreateApiClient {
        public final static ApiClient API_CLIENT = new ApiClient();
    }


    public Retrofit retrofit() {
        if (mRetrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
//            if (BuildConfig.DEBUG) {
//                //设置 Debug Log 模式
            //   builder.addInterceptor(new LoggingInterceptor());
//            }
            //    builder.addInterceptor(new CommonInterceptor(commond));
            builder.addInterceptor(new LoggingInterceptor());
            builder.addNetworkInterceptor(getHttpLoggingInterceptor());
            OkHttpClient okHttpClient = builder.build();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(API_SERVER_URL)
                    .addConverterFactory(CustomGsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return mRetrofit;
    }


    /**
     * 日志打印拦截器
     *
     * @return
     */
    public static HttpLoggingInterceptor getHttpLoggingInterceptor() {
        //日志打印初始化
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //打印retrofit日志
                LogUtil.d("Interceptor", "元数据 = " + message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }


}
