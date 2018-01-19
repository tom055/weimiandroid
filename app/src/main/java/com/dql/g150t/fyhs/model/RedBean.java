package com.dql.g150t.fyhs.model;

/**
 * Created by fm on 2017/7/25.
 */

public class RedBean {
    /**
     * end_date : 2017-09-01
     * red_type_name : 3% 或者10元
     * red_id : 1
     * red_type_id : 2 //1加息 2满减
     * lowest_account ://满减最低金额
     * start_date : 2017-07-03
     * status : 0
     * id : 9
     */

    private int id;
    private int red_id;
    private int red_type_id;
    private String red_title;
    private int lowest_account;
    private String start_date;
    private String end_date;
    private int status;
    private String day_limit;


    public RedBean(int id, int red_id, int red_type_id, String red_title, String day_limit, int lowest_account, String start_date, String end_date, int status) {
        this.id = id;
        this.red_id = red_id;
        this.red_type_id = red_type_id;
        this.red_title = red_title;
        this.lowest_account = lowest_account;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.day_limit = day_limit;
    }

    public String getDay_limit() {
        return day_limit;
    }

    public void setDay_limit(String day_limit) {
        this.day_limit = day_limit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRed_id() {
        return red_id;
    }

    public void setRed_id(int red_id) {
        this.red_id = red_id;
    }

    public int getRed_type_id() {
        return red_type_id;
    }

    public void setRed_type_id(int red_type_id) {
        this.red_type_id = red_type_id;
    }

    public String getRed_title() {
        return red_title;
    }

    public void setRed_title(String red_title) {
        this.red_title = red_title;
    }

    public int getLowest_account() {
        return lowest_account;
    }

    public void setLowest_account(int lowest_account) {
        this.lowest_account = lowest_account;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
