package com.ay.user.mvp.req;


import com.google.gson.annotations.Expose;

//相应类
@SuppressWarnings("serial")
public abstract class PacketReq extends Packet {

    @Expose
    private int Code;
    @Expose
    private String Message;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
