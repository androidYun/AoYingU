package com.ay.user.mvp.req;

/**
 * Created by ${lgy} on 2017/11/2216:32
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class ModifyPwdReq extends Packet {
    private int userId;

    private String oldPwd;

    private String newPwd;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}
