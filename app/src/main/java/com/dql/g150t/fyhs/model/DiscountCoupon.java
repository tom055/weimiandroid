package com.dql.g150t.fyhs.model;

import java.util.List;

/**
 * Created by ST on 2017/7/24.
 */

public class DiscountCoupon {

    /**
     * msg : 获取成功
     * ableReds : [{"create_time":"2017-06-01","red_type":2,"red_type_name":"满1000减10元","lowest_account":1000,"red_account":10,"invite_send_status":0,"regist_send_status":0,"id":1},{"create_time":"2017-06-01","red_type":2,"red_type_name":"满1000减20元","lowest_account":1000,"red_account":20,"invite_send_status":0,"regist_send_status":0,"id":2},{"create_time":"2017-06-01","red_type":2,"red_type_name":"满1000减30元","lowest_account":1000,"red_account":30,"invite_send_status":0,"regist_send_status":0,"id":3},{"create_time":"2017-06-01","red_type":2,"red_type_name":"满1000减40元","lowest_account":1000,"red_account":40,"invite_send_status":0,"regist_send_status":0,"id":4},{"create_time":"2017-06-01","red_type":2,"red_type_name":"满1000减50元","lowest_account":1000,"red_account":50,"invite_send_status":0,"regist_send_status":0,"id":5},{"create_time":"2017-06-01","red_type":2,"red_type_name":"满1000减60元","lowest_account":1000,"red_account":60,"invite_send_status":0,"regist_send_status":0,"id":6},{"create_time":"2017-06-01","red_type":2,"red_type_name":"满1000减70元","lowest_account":1000,"red_account":70,"invite_send_status":0,"regist_send_status":0,"id":7}]
     * addReds : [{"create_time":"2016-06-20","red_type":1,"red_type_name":"3%加息券","add_percent":3,"invite_send_status":0,"regist_send_status":0,"id":3},{"create_time":"2016-06-20","red_type":1,"red_type_name":"1%加息券","add_percent":1,"invite_send_status":0,"regist_send_status":1,"id":4},{"create_time":"2016-07-27","red_type":1,"red_type_name":"加息券","add_percent":3,"invite_send_status":0,"regist_send_status":0,"id":5},{"create_time":"2016-07-27","red_type":1,"red_type_name":"加息券3%","add_percent":3,"invite_send_status":1,"regist_send_status":1,"id":6}]
     * redList : [{"end_date":"2017-09-01","add_time":"1499044048","red_type_name":"满1000减10元","user_id":1003,"red_id":1,"red_type_id":2,"red_account":0,"start_date":"2017-07-03","userName":null,"status":0,"id":9}]
     * page : {"totalCount":1,"begin":0,"pageSize":20,"currentPage":1,"totalPage":1}
     * status : 1
     */

    private String msg;
    private PageBean page;
    private String status;
    private List<AbleRedsBean> ableReds;
    private List<AddRedsBean> addReds;
    private List<RedListBean> redList;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<AbleRedsBean> getAbleReds() {
        return ableReds;
    }

    public void setAbleReds(List<AbleRedsBean> ableReds) {
        this.ableReds = ableReds;
    }

    public List<AddRedsBean> getAddReds() {
        return addReds;
    }

    public void setAddReds(List<AddRedsBean> addReds) {
        this.addReds = addReds;
    }

    public List<RedListBean> getRedList() {
        return redList;
    }

    public void setRedList(List<RedListBean> redList) {
        this.redList = redList;
    }

    public static class PageBean {
        /**
         * totalCount : 1
         * begin : 0
         * pageSize : 20
         * currentPage : 1
         * totalPage : 1
         */

        private int totalCount;
        private int begin;
        private int pageSize;
        private int currentPage;
        private int totalPage;

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getBegin() {
            return begin;
        }

        public void setBegin(int begin) {
            this.begin = begin;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }
    }

    public static class AbleRedsBean {
        /**
         * create_time : 2017-06-01
         * red_type : 2
         * red_type_name : 满1000减10元
         * lowest_account : 1000
         * red_account : 10
         * invite_send_status : 0
         * regist_send_status : 0
         * id : 1
         */

        private String create_time;
        private int red_type;
        private String red_type_name;
        private int lowest_account;
        private int red_account;
        private int invite_send_status;
        private int regist_send_status;
        private int id;
        private int day_limit;

        public int getDay_limit() {
            return day_limit;
        }

        public void setDay_limit(int day_limit) {
            this.day_limit = day_limit;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public int getRed_type() {
            return red_type;
        }

        public void setRed_type(int red_type) {
            this.red_type = red_type;
        }

        public String getRed_type_name() {
            return red_type_name;
        }

        public void setRed_type_name(String red_type_name) {
            this.red_type_name = red_type_name;
        }

        public int getLowest_account() {
            return lowest_account;
        }

        public void setLowest_account(int lowest_account) {
            this.lowest_account = lowest_account;
        }

        public int getRed_account() {
            return red_account;
        }

        public void setRed_account(int red_account) {
            this.red_account = red_account;
        }

        public int getInvite_send_status() {
            return invite_send_status;
        }

        public void setInvite_send_status(int invite_send_status) {
            this.invite_send_status = invite_send_status;
        }

        public int getRegist_send_status() {
            return regist_send_status;
        }

        public void setRegist_send_status(int regist_send_status) {
            this.regist_send_status = regist_send_status;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class AddRedsBean {
        /**
         * create_time : 2016-06-20
         * red_type : 1
         * red_type_name : 3%加息券
         * add_percent : 3
         * invite_send_status : 0
         * regist_send_status : 0
         * id : 3
         */

        private String create_time;
        private int red_type;
        private String red_type_name;
        private float add_percent;
        private int invite_send_status;
        private int regist_send_status;
        private int id;
        private int day_limit;

        public int getDay_limit() {
            return day_limit;
        }

        public void setDay_limit(int day_limit) {
            this.day_limit = day_limit;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public int getRed_type() {
            return red_type;
        }

        public void setRed_type(int red_type) {
            this.red_type = red_type;
        }

        public String getRed_type_name() {
            return red_type_name;
        }

        public void setRed_type_name(String red_type_name) {
            this.red_type_name = red_type_name;
        }

        public float getAdd_percent() {
            return add_percent;
        }

        public void setAdd_percent(float add_percent) {
            this.add_percent = add_percent;
        }

        public int getInvite_send_status() {
            return invite_send_status;
        }

        public void setInvite_send_status(int invite_send_status) {
            this.invite_send_status = invite_send_status;
        }

        public int getRegist_send_status() {
            return regist_send_status;
        }

        public void setRegist_send_status(int regist_send_status) {
            this.regist_send_status = regist_send_status;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class RedListBean {
        /**
         * end_date : 2017-09-01
         * add_time : 1499044048
         * red_type_name : 满1000减10元
         * user_id : 1003
         * red_id : 1
         * red_type_id : 2
         * red_account : 0
         * start_date : 2017-07-03
         * userName : null
         * status : 0
         * id : 9
         */

        private String end_date;
        private String add_time;
        private String red_type_name;
        private int user_id;
        private int red_id;
        private int red_type_id;
        private int red_account;
        private String start_date;
        private Object userName;
        private int status;
        private int id;

        public String getEnd_date() {
            return end_date;
        }

        public void setEnd_date(String end_date) {
            this.end_date = end_date;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getRed_type_name() {
            return red_type_name;
        }

        public void setRed_type_name(String red_type_name) {
            this.red_type_name = red_type_name;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
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

        public int getRed_account() {
            return red_account;
        }

        public void setRed_account(int red_account) {
            this.red_account = red_account;
        }

        public String getStart_date() {
            return start_date;
        }

        public void setStart_date(String start_date) {
            this.start_date = start_date;
        }

        public Object getUserName() {
            return userName;
        }

        public void setUserName(Object userName) {
            this.userName = userName;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
