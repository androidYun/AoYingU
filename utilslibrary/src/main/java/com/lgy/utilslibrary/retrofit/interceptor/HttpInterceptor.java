package com.lgy.utilslibrary.retrofit.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ${lgy} on 2017/11/2210:26
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class HttpInterceptor implements Interceptor {
    private int Commond;

    private boolean isNeedCommond = true;

    public HttpInterceptor(int commond) {
        Commond = commond;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        Request requst = null;
        if (isNeedCommond) {
            requst = builder.addHeader("Content-type", "application/json")
                    .addHeader("Commond", Commond + "")
                    .build();
        } else {
            requst = builder.addHeader("Content-type", "application/json")
                    .build();
        }
        Response response = chain.proceed(requst);
        return response;
    }
}
