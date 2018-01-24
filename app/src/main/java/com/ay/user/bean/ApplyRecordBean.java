package com.ay.user.bean;

/**
 * Created by ${lgy} on 2017/11/2510:19
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class ApplyRecordBean {
    public ApplyRecordBean(String applyState, int type) {
        this.applyState = applyState;
        this.type = type;
    }

    private String applyState;

    private int type;

    public String getApplyState() {
        return applyState;
    }

    public void setApplyState(String applyState) {
        this.applyState = applyState;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
