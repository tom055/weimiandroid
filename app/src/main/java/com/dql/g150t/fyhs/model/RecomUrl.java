package com.dql.g150t.fyhs.model;

/**
 * Created by ST on 2017/8/25.
 */

public class RecomUrl {

    /**
     * msg : 成功
     * recommend_url : http://www.gcs1688.com/front/user/regist.jsp?mobilePhone=MTU5OTAwMzkwMzk=
     * status : 1
     */

    private String msg;
    private String recommend_url;
    private String status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRecommend_url() {
        return recommend_url;
    }

    public void setRecommend_url(String recommend_url) {
        this.recommend_url = recommend_url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
