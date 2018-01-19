package com.dql.g150t.fyhs.model;

/**
 * Created by G150T on 2017/7/20.
 */

public class WithDraw {

    /**
     * msg : 提现金额不能大于账户的可用余额
     * status : 0
     */

    private String msg;
    private String status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
