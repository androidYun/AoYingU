package com.ay.user.mvp.model;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by ${lgy} on 2017/11/2510:24
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class ApplyListRes extends BaseRes {


    /**
     * pageCount : 1
     * userlist : [{"balance":"13","companyNo":"123","id":"2","job":"556","lines":"0","name":"李桂云","phone":"13098834723","proName":"产品二","staffId":1,"state":"资料提交","stateCode":"0","time":"2017/11/27 10:45:36"}]
     */
    @Expose
    public int pageCount;
    @Expose
    public List<UserlistBean> userlist;

    public static class UserlistBean {
        /**
         * balance : 13
         * companyNo : 123
         * id : 2
         * job : 556
         * lines : 0
         * name : 李桂云
         * phone : 13098834723
         * proName : 产品二
         * staffId : 1
         * state : 资料提交
         * stateCode : 0
         * time : 2017/11/27 10:45:36
         */
        @Expose
        public String balance;
        @Expose
        public String companyNo;
        @Expose
        public String id;
        @Expose
        public String job;
        @Expose
        public String lines;
        @Expose
        public String name;
        @Expose
        public String phone;
        @Expose
        public String proName;
        @Expose
        public int staffId;
        @Expose
        public String state;
        @Expose
        public String stateCode;
        @Expose
        public String time;
    }
}
