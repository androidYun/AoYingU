package com.ay.user;

import android.app.Application;
import android.content.Context;

/**
 * Created by ${lgy} on 2017/11/2115:43
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class MainApplication extends Application {
    public static Context appContext;

    public static  MainApplication mainApplication;

    public static MainApplication getInstace() {
        return mainApplication;
    }


    public static Context getAppContext() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mainApplication = this;
        appContext = MainApplication.this.getApplicationContext();
    }


}
