package com.lgy.utilslibrary.retrofit.converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.lgy.utilslibrary.mvp.Presenter.model.HttpStatus;
import com.lgy.utilslibrary.utils.LogUtil;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import retrofit2.Converter;

/**
 * Created by ${lgy} on 2017/11/2316:57
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class CustomGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    CustomGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string().trim();
        LogUtil.d("李桂云" + response);
        HttpStatus httpStatus = gson.fromJson(response, HttpStatus.class);
//        if (httpStatus.isCodeInvalid()) {
//            value.close();
//        }

        MediaType contentType = value.contentType();
        Charset charset = contentType != null ? contentType.charset(Util.UTF_8) : Util.UTF_8;
        InputStream inputStream = new ByteArrayInputStream(response.getBytes());
        Reader reader = new InputStreamReader(inputStream, charset);
        JsonReader jsonReader = gson.newJsonReader(reader);
        try {
            return adapter.read(jsonReader);
        } finally {
            value.close();
        }
    }
}
