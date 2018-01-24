package com.ay.user.httpservice;

import com.ay.user.mvp.req.ApplyListReq;
import com.ay.user.mvp.req.ApplyStaffReq;
import com.ay.user.mvp.req.LoginReq;
import com.ay.user.mvp.req.ModifyPwdReq;
import com.ay.user.mvp.req.ProductListReq;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by WuXiaolong on 2016/3/24.
 * github:https://github.com/WuXiaolong/
 * 微信公众号：吴小龙同学
 * 个人博客：http://wuxiaolong.me/
 */
public interface ApiStores {


    @POST("aoying.ashx")
    Observable<String> loadDataByRetrofit(@Body LoginReq loginResp);


    @POST("aoying.ashx")
    Observable<String> addApplyRecord(@Body ApplyStaffReq applyStaffResp);


    @POST("aoying.ashx")
    Observable<String> getApplyListRecord(@Body ApplyListReq applyListResp);


    @POST("aoying.ashx")
    Observable<String> getProcduceList(@Body ProductListReq productListResp);


    @POST("aoying.ashx")
    Observable<String> modifyPassword(@Body ModifyPwdReq modifyPwdResp);

}
