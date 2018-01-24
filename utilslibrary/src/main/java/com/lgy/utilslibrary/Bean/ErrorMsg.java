package com.lgy.utilslibrary.Bean;

/**
 * 作者：${李桂云} on 2017/6/1 18:19
 * 邮箱：1343168198@qq.com
 */

public class ErrorMsg {
    private int respCode;//请求接口

    private String errorMsg;//错误信息

    private int ErrorCode;//请求错误数据

    public ErrorMsg(int respCode, String errorMsg, int errorCode) {
        this.respCode = respCode;
        this.errorMsg = errorMsg;
        ErrorCode = errorCode;
    }

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(int errorCode) {
        ErrorCode = errorCode;
    }

    @Override
    public String toString() {
        return "ErrorMsg{" +
                "respCode=" + respCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", ErrorCode=" + ErrorCode +
                '}';
    }
}
