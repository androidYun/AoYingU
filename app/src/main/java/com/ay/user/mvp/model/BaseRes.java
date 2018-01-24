package com.ay.user.mvp.model;

import com.google.gson.annotations.Expose;

/**
 * Created by ${lgy} on 2017/11/2211:04
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class BaseRes {
    @Expose
    private int command;
    @Expose
    private int result;

    @Expose
    public String errorMsg;

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }



    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
