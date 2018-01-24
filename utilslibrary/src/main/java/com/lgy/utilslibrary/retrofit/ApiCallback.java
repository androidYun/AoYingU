package com.lgy.utilslibrary.retrofit;


import com.lgy.utilslibrary.Bean.ErrorMsg;
import com.lgy.utilslibrary.mvp.PresenterView.BaseView;
import com.lgy.utilslibrary.utils.JsonUtil;
import com.lgy.utilslibrary.utils.LogUtil;
import com.lgy.utilslibrary.utils.StringUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by WuXiaolong on 2016/9/22.
 * github:https://github.com/WuXiaolong/
 * 微信公众号：吴小龙同学
 * 个人博客：http://wuxiaolong.me/
 */
public abstract class ApiCallback<M> extends Subscriber<String> {

    private BaseView baseView;

    public abstract void onSuccess(M resultResp);

    JSONObject jsonObject = null;

    private boolean isShowDialog;


    public ApiCallback(BaseView baseView, boolean isShowDialog) {
        this.baseView = baseView;
        this.isShowDialog = isShowDialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (baseView != null) {
            baseView.showLoading();
        }
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            //httpException.response().errorBody().string()
            int code = httpException.code();
            String msg = httpException.getMessage();
            LogUtil.d("code=" + code);
            if (code == 504) {
                msg = "网络不给力";
            }
            if (code == 502 || code == 404 || code == 500) {
                msg = "服务器异常，请稍后再试";
            }
            baseView.loadDataFail(new ErrorMsg(0, msg, code));
        } else {
            baseView.loadDataFail(new ErrorMsg(0, e.getMessage(), 0));
        }
        if (baseView != null) {
            baseView.hideLoading();
        }
    }

    @Override
    public void onNext(String model) {
        M m;
        if (StringUtils.isEmpty(model)) {
            baseView.loadDataFail(new ErrorMsg(0, "请求服务失败", 0));
            return;
        } else {
            try {
                if (jsonObject == null) {
                    jsonObject = new JSONObject(model);
                }
                int result = jsonObject.getInt("result");
                if (result != 1) {
                    String errorMsg = jsonObject.getString("errorMsg");
                    baseView.loadDataFail(new ErrorMsg(0, errorMsg, 0));
                    return;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                m = JsonUtil.fromJson(model, getClazz());
                if (m != null) {
                    onSuccess(m);
                } else {
                    baseView.loadDataFail(new ErrorMsg(0, "解析失败", 0));
                }
            } catch (Exception e) {
                e.printStackTrace();
                baseView.loadDataFail(new ErrorMsg(0, "解析失败", 0));
                return;
            }

        }

    }

    @Override
    public void onCompleted() {
        if (baseView != null) {
            baseView.hideLoading();
        }
    }

    public Class<M> getClazz() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType p = (ParameterizedType) t;
        Class<M> c = (Class<M>) p.getActualTypeArguments()[0];
        return c;
    }
}
