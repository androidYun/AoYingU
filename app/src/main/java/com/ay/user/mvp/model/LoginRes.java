package com.ay.user.mvp.model;

import com.google.gson.annotations.Expose;

/**
 * Created by ${lgy} on 2017/11/2115:26
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class LoginRes extends BaseRes{
    @Expose
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
