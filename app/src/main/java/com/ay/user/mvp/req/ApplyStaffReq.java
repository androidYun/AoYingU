package com.ay.user.mvp.req;

/**
 * Created by ${lgy} on 2017/11/2216:32
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class ApplyStaffReq extends Packet {
    private int userId;

    private String phone;

    private String name;


    private String job;

    private String balance;

    private String productId;

    private String companyNo;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }
}
