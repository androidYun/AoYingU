package com.ay.user.mvp.model;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by ${lgy} on 2017/11/2115:26
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class ProductListRes extends BaseRes {
    @Expose
    public List<DataBean> data;

    public static class DataBean {
        /**
         * id : 1
         * intro : 1：啦啦啦啦啦啦
         * 2：啦啦啦
         * name : 产品一
         */
        @Expose
        public String id;
        @Expose
        public String intro;
        @Expose
        public String name;

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", intro='" + intro + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
