package com.ay.user.mvp.req;

/**
 * Created by ${lgy} on 2017/11/2216:32
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class LoginReq extends Packet {
    private int userId;

    private String userName;

    private String passWord;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
