package com.dql.g150t.fyhs.model;

import java.util.List;

/**
 * Created by ST on 2017/7/22.
 */

public class Collection {

    /**
     * msg : 查询成功
     * borrowTypes : [{"addtime":"1429783736","type_name":"信用标","type_commodity_name":"信用标","is_home_display":1,"uptime":"1500259522","description":"以各类银行（商业）承兑汇票作为质押品的融资项目。","status":1,"id":1},{"addtime":"1429783736","type_name":"抵押标","type_commodity_name":"抵押标","is_home_display":1,"uptime":"1500259597","description":"由电联担保作为保证人的融资项目。","status":1,"id":2},{"addtime":"1429783736","type_name":"担保标","type_commodity_name":"担保标","is_home_display":1,"uptime":"1500259616","description":"为车辆按揭业务提供资金周转，实现快捷购车。","status":1,"id":3},{"addtime":"1429783736","type_name":"流转标","type_commodity_name":"流标","is_home_display":1,"uptime":"1500349802","description":"以物品典当方式的融资项目，由电联典当提供连带转让担保。","status":1,"id":4},{"addtime":"1453284776","type_name":"新手专享","type_commodity_name":"新手专享","is_home_display":1,"uptime":"1500259547","description":"新手专享","status":1,"id":6}]
     * collections : [{"id":1360,"site_id":null,"debt_user_id":1003,"status":0,"order":1,"tender_id":1300,"repay_time":"1462773739","repay_account":60640,"capital":60000,"interest":640,"repay_yestime":null,"repay_yesaccount":0,"late_days":0,"late_interest":0,"addtime":"1460181739","addip":"118.133.35.138","add_interest_account":0,"b_name":"小金宝052","b_account":100000,"b_type":1,"b_apr":12.8,"b_time_limit":30,"b_style":"0","b_id":205,"b_repayment_periods":1,"bt_account":60000,"bt_interest":640},{"id":1368,"site_id":null,"debt_user_id":1003,"status":0,"order":1,"tender_id":1314,"repay_time":"1463031219","repay_account":303200,"capital":300000,"interest":3200,"repay_yestime":null,"repay_yesaccount":0,"late_days":0,"late_interest":0,"addtime":"1460439219","addip":"117.185.87.158","add_interest_account":0,"b_name":"小金宝060","b_account":300000,"b_type":1,"b_apr":12.8,"b_time_limit":30,"b_style":"0","b_id":214,"b_repayment_periods":1,"bt_account":300000,"bt_interest":3200},{"id":1429,"site_id":null,"debt_user_id":1003,"status":0,"order":1,"tender_id":1372,"repay_time":"1463565515","repay_account":106120,"capital":105000,"interest":1120,"repay_yestime":null,"repay_yesaccount":0,"late_days":0,"late_interest":0,"addtime":"1460973515","addip":"117.185.87.158","add_interest_account":0,"b_name":"小金宝070","b_account":200000,"b_type":1,"b_apr":12.8,"b_time_limit":30,"b_style":"0","b_id":228,"b_repayment_periods":1,"bt_account":105000,"bt_interest":1120},{"id":1443,"site_id":null,"debt_user_id":1003,"status":0,"order":1,"tender_id":1401,"repay_time":"1463732769","repay_account":1212.8,"capital":1200,"interest":12.8,"repay_yestime":null,"repay_yesaccount":0,"late_days":0,"late_interest":0,"addtime":"1461140769","addip":"117.185.87.158","add_interest_account":0,"b_name":"小金宝076","b_account":120000,"b_type":1,"b_apr":12.8,"b_time_limit":30,"b_style":"0","b_id":235,"b_repayment_periods":1,"bt_account":1200,"bt_interest":12.8},{"id":1444,"site_id":null,"debt_user_id":1003,"status":0,"order":1,"tender_id":1400,"repay_time":"1463732769","repay_account":106120,"capital":105000,"interest":1120,"repay_yestime":null,"repay_yesaccount":0,"late_days":0,"late_interest":0,"addtime":"1461140769","addip":"117.185.87.158","add_interest_account":0,"b_name":"小金宝076","b_account":120000,"b_type":1,"b_apr":12.8,"b_time_limit":30,"b_style":"0","b_id":235,"b_repayment_periods":1,"bt_account":105000,"bt_interest":1120},{"id":1341,"site_id":null,"debt_user_id":1003,"status":1,"order":1,"tender_id":1279,"repay_time":"1460190640","repay_account":20045.89,"capital":20000,"interest":45.89,"repay_yestime":"1460180758","repay_yesaccount":20045.89,"late_days":0,"late_interest":0,"addtime":"1459585840","addip":"117.185.87.158","add_interest_account":0,"b_name":"小金宝045","b_account":20000,"b_type":1,"b_apr":11.8,"b_time_limit":7,"b_style":"0","b_id":198,"b_repayment_periods":1,"bt_account":20000,"bt_interest":45.89},{"id":1242,"site_id":null,"debt_user_id":1003,"status":1,"order":1,"tender_id":1184,"repay_time":"1460442827","repay_account":88938.67,"capital":88000,"interest":938.67,"repay_yestime":"1460431685","repay_yesaccount":88938.67,"late_days":0,"late_interest":0,"addtime":"1457850827","addip":"117.185.87.158","add_interest_account":0,"b_name":"小金宝013","b_account":300000,"b_type":1,"b_apr":12.8,"b_time_limit":30,"b_style":"0","b_id":165,"b_repayment_periods":1,"bt_account":88000,"bt_interest":938.67},{"id":1243,"site_id":null,"debt_user_id":1003,"status":1,"order":1,"tender_id":1183,"repay_time":"1460442827","repay_account":104098.67,"capital":103000,"interest":1098.67,"repay_yestime":"1460431685","repay_yesaccount":104098.67,"late_days":0,"late_interest":0,"addtime":"1457850827","addip":"117.185.87.158","add_interest_account":0,"b_name":"小金宝013","b_account":300000,"b_type":1,"b_apr":12.8,"b_time_limit":30,"b_style":"0","b_id":165,"b_repayment_periods":1,"bt_account":103000,"bt_interest":1098.67},{"id":1363,"site_id":null,"debt_user_id":1003,"status":1,"order":1,"tender_id":1301,"repay_time":"1460786547","repay_account":30068.83,"capital":30000,"interest":68.83,"repay_yestime":"1460776256","repay_yesaccount":30068.83,"late_days":0,"late_interest":0,"addtime":"1460181747","addip":"118.133.35.138","add_interest_account":0,"b_name":"小金宝053","b_account":30000,"b_type":1,"b_apr":11.8,"b_time_limit":7,"b_style":"0","b_id":206,"b_repayment_periods":1,"bt_account":30000,"bt_interest":68.83},{"id":1271,"site_id":null,"debt_user_id":1003,"status":1,"order":1,"tender_id":1205,"repay_time":"1461123811","repay_account":103896.53,"capital":102800,"interest":1096.53,"repay_yestime":"1461119156","repay_yesaccount":103896.53,"late_days":0,"late_interest":0,"addtime":"1458531811","addip":"117.185.87.158","add_interest_account":0,"b_name":"小金宝022","b_account":120000,"b_type":1,"b_apr":12.8,"b_time_limit":30,"b_style":"0","b_id":174,"b_repayment_periods":1,"bt_account":102800,"bt_interest":1096.53}]
     * page : {"totalPage":1,"begin":0,"pageSize":20,"currentPage":1,"totalCount":10}
     * type : collection
     * status : 1
     */

    private String msg;
    private PageBean page;
    private String type;
    private String status;
    private List<BorrowTypesBean> borrowTypes;
    private List<CollectionsBean> collections;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<BorrowTypesBean> getBorrowTypes() {
        return borrowTypes;
    }

    public void setBorrowTypes(List<BorrowTypesBean> borrowTypes) {
        this.borrowTypes = borrowTypes;
    }

    public List<CollectionsBean> getCollections() {
        return collections;
    }

    public void setCollections(List<CollectionsBean> collections) {
        this.collections = collections;
    }

    public static class PageBean {
        /**
         * totalPage : 1
         * begin : 0
         * pageSize : 20
         * currentPage : 1
         * totalCount : 10
         */

        private int totalPage;
        private int begin;
        private int pageSize;
        private int currentPage;
        private int totalCount;

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
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

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }
    }

    public static class BorrowTypesBean {
        /**
         * addtime : 1429783736
         * type_name : 信用标
         * type_commodity_name : 信用标
         * is_home_display : 1
         * uptime : 1500259522
         * description : 以各类银行（商业）承兑汇票作为质押品的融资项目。
         * status : 1
         * id : 1
         */

        private String addtime;
        private String type_name;
        private String type_commodity_name;
        private int is_home_display;
        private String uptime;
        private String description;
        private int status;
        private int id;

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getType_name() {
            return type_name;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }

        public String getType_commodity_name() {
            return type_commodity_name;
        }

        public void setType_commodity_name(String type_commodity_name) {
            this.type_commodity_name = type_commodity_name;
        }

        public int getIs_home_display() {
            return is_home_display;
        }

        public void setIs_home_display(int is_home_display) {
            this.is_home_display = is_home_display;
        }

        public String getUptime() {
            return uptime;
        }

        public void setUptime(String uptime) {
            this.uptime = uptime;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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

    public static class CollectionsBean {
        /**
         * id : 1360
         * site_id : null
         * debt_user_id : 1003
         * status : 0
         * order : 1
         * tender_id : 1300
         * repay_time : 1462773739
         * repay_account : 60640
         * capital : 60000
         * interest : 640
         * repay_yestime : null
         * repay_yesaccount : 0
         * late_days : 0
         * late_interest : 0
         * addtime : 1460181739
         * addip : 118.133.35.138
         * add_interest_account : 0
         * b_name : 小金宝052
         * b_account : 100000
         * b_type : 1
         * b_apr : 12.8
         * b_time_limit : 30
         * b_style : 0
         * b_id : 205
         * b_repayment_periods : 1
         * bt_account : 60000
         * bt_interest : 640
         */

        private int id;
        private Object site_id;
        private int debt_user_id;
        private int status;
        private int order;
        private int tender_id;
        private String repay_time;
        private Object repay_account;
        private float capital;
        private Object interest;
        private Object repay_yestime;
        private Object repay_yesaccount;
        private int late_days;
        private Object late_interest;
        private String addtime;
        private String addip;
        private Object add_interest_account;
        private String b_name;
        private int b_account;
        private int b_type;
        private double b_apr;
        private int b_time_limit;
        private String b_style;
        private int b_id;
        private int b_repayment_periods;
        private int bt_account;
        private Object bt_interest;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getSite_id() {
            return site_id;
        }

        public void setSite_id(Object site_id) {
            this.site_id = site_id;
        }

        public int getDebt_user_id() {
            return debt_user_id;
        }

        public void setDebt_user_id(int debt_user_id) {
            this.debt_user_id = debt_user_id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getTender_id() {
            return tender_id;
        }

        public void setTender_id(int tender_id) {
            this.tender_id = tender_id;
        }

        public String getRepay_time() {
            return repay_time;
        }

        public void setRepay_time(String repay_time) {
            this.repay_time = repay_time;
        }

        public Object getRepay_account() {
            return repay_account;
        }

        public void setRepay_account(Object repay_account) {
            this.repay_account = repay_account;
        }

        public float getCapital() {
            return capital;
        }

        public void setCapital(float capital) {
            this.capital = capital;
        }

        public Object getInterest() {
            return interest;
        }

        public void setInterest(Object interest) {
            this.interest = interest;
        }

        public Object getRepay_yestime() {
            return repay_yestime;
        }

        public void setRepay_yestime(Object repay_yestime) {
            this.repay_yestime = repay_yestime;
        }

        public Object getRepay_yesaccount() {
            return repay_yesaccount;
        }

        public void setRepay_yesaccount(Object repay_yesaccount) {
            this.repay_yesaccount = repay_yesaccount;
        }

        public int getLate_days() {
            return late_days;
        }

        public void setLate_days(int late_days) {
            this.late_days = late_days;
        }

        public Object getLate_interest() {
            return late_interest;
        }

        public void setLate_interest(Object late_interest) {
            this.late_interest = late_interest;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getAddip() {
            return addip;
        }

        public void setAddip(String addip) {
            this.addip = addip;
        }

        public Object getAdd_interest_account() {
            return add_interest_account;
        }

        public void setAdd_interest_account(Object add_interest_account) {
            this.add_interest_account = add_interest_account;
        }

        public String getB_name() {
            return b_name;
        }

        public void setB_name(String b_name) {
            this.b_name = b_name;
        }

        public int getB_account() {
            return b_account;
        }

        public void setB_account(int b_account) {
            this.b_account = b_account;
        }

        public int getB_type() {
            return b_type;
        }

        public void setB_type(int b_type) {
            this.b_type = b_type;
        }

        public double getB_apr() {
            return b_apr;
        }

        public void setB_apr(double b_apr) {
            this.b_apr = b_apr;
        }

        public int getB_time_limit() {
            return b_time_limit;
        }

        public void setB_time_limit(int b_time_limit) {
            this.b_time_limit = b_time_limit;
        }

        public String getB_style() {
            return b_style;
        }

        public void setB_style(String b_style) {
            this.b_style = b_style;
        }

        public int getB_id() {
            return b_id;
        }

        public void setB_id(int b_id) {
            this.b_id = b_id;
        }

        public int getB_repayment_periods() {
            return b_repayment_periods;
        }

        public void setB_repayment_periods(int b_repayment_periods) {
            this.b_repayment_periods = b_repayment_periods;
        }

        public int getBt_account() {
            return bt_account;
        }

        public void setBt_account(int bt_account) {
            this.bt_account = bt_account;
        }

        public Object getBt_interest() {
            return bt_interest;
        }

        public void setBt_interest(Object bt_interest) {
            this.bt_interest = bt_interest;
        }
    }
}
