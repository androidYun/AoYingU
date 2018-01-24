package com.ay.user.mvp.req;


public abstract class Packet {
    protected int command;//命令字

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

}
