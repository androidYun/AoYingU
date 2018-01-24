package com.ay.user.mvp.req;

/**
 * Created by ${lgy} on 2017/11/2216:32
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class ApplyListReq extends Packet {
    private int userId;

    private String key;

    private int type;//-1：全部0：审核中1：成功2：失败

    private int pageIndex;//页码

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
}
