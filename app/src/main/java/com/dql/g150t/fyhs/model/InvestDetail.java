package com.dql.g150t.fyhs.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ST on 2017/7/22.
 */

public class InvestDetail {

    /**
     * imgs : [{"user_id":null,"borrow_id":251,"img":"/gcs/uploadFile/image/20170717/20170717102441_732.jpg","id":5906}]
     * userNameMap : {"11116":"15547936451","11117":"13486096437","11122":"13056724910"}
     * tenders : [{"user_id":11117,"addtime":"1500349995","money":280,"borrow_id":251,"repayment_account":280.06,"interest":0.06,"repayment_yesaccount":0,"repayment_yesinterest":0,"borrowName":null,"borrowNo":null,"account":280,"user_red_id":0,"wait_account":280.06,"wait_interest":0.06,"addip":"218.74.250.185","site_id":0,"verifyTime4":null,"tender_type":0,"contract_no":null,"seconds":0,"userName":null,"status":1,"realName":null,"page":null,"beginDate":null,"endDate":null,"delete_flag":null,"id":1444},{"user_id":11116,"addtime":"1500271106","money":220,"borrow_id":251,"repayment_account":220.05,"interest":0.05,"repayment_yesaccount":0,"repayment_yesinterest":0,"borrowName":null,"borrowNo":null,"account":220,"user_red_id":0,"wait_account":220.05,"wait_interest":0.05,"addip":"218.74.248.202","site_id":0,"verifyTime4":null,"tender_type":0,"contract_no":null,"seconds":0,"userName":null,"status":1,"realName":null,"page":null,"beginDate":null,"endDate":null,"delete_flag":null,"id":1439},{"user_id":11122,"addtime":"1500263254","money":100,"borrow_id":251,"repayment_account":100.02,"interest":0.02,"repayment_yesaccount":0,"repayment_yesinterest":0,"borrowName":null,"borrowNo":null,"account":100,"user_red_id":0,"wait_account":100.02,"wait_interest":0.02,"addip":"218.74.248.202","site_id":0,"verifyTime4":null,"tender_type":0,"contract_no":null,"seconds":0,"userName":null,"status":1,"realName":null,"page":null,"beginDate":null,"endDate":null,"delete_flag":null,"id":1433}]
     * reds : [{"red_type_name":"满1000减10元","user_id":1003,"add_time":"1499044048","red_id":1,"red_type_id":2,"red_account":0,"start_date":"2017-07-03","end_date":"2017-09-01","userName":null,"status":0,"id":9}]
     * borrow : {"user_id":11113,"addtime":"1500258286","style":0,"repayment_time":"1500781997","repayment_account":500.11,"repayment_yesaccount":0,"repayment_yesinterest":0,"account":500,"account_yes":500,"most_account":500,"lowest_account":80,"is_day":1,"time_limit":5,"apr":1.6,"award":2,"part_account":0,"funds":0.1,"tender_times":2,"borrow_fee":0,"reward_amount":0.5,"repayment_periods":1,"number_id":"620170717102446251","vouch_type":0,"end_time":"1500431163","valid_time":2,"verify_time4":"1500349997","vouch_user":"","vouch_card_no":"","litpic":"/gcs/uploadFile/image/20170717/20170717102538_958.jpg","verify_time":"1500258346","verify_remark":"申请补充完成！","addip":"218.74.248.202","site_id":0,"is_VIP":0,"dispaly":1,"hits":0,"use":"d","accept_bank":null,"vouch_account":0,"vouch_award":null,"vouch_times":0,"customer":null,"forst_account":0,"monthly_repayment":0,"each_time":null,"finish_time":null,"open_account":null,"open_borrow":null,"promotion_info":null,"risk_warning":"d","is_false":null,"open_tender":null,"open_credit":null,"success_time":"1500349995","publish":"","verify_user":"超级管理员","verify_user2":"超级管理员","verify_remark2":"a","verify_time2":"1500258357","verify_user3":"超级管理员","verify_remark3":"d","verify_time3":"1500258363","verify_user4":"无","verify_remark4":"自动审核","cancel_user":null,"cancel_remark":null,"cancel_time":null,"family_assets":null,"family_annual_income":null,"social_security_status":null,"credit_card_status":null,"invisible_assets":null,"commercial_insurance_status":null,"bank_credit_record":null,"industry":null,"enterprise_type":null,"brand":null,"patent_num":null,"operation_state":null,"last_month_asset":null,"last_month_debt":null,"last_month_receivable":null,"last_month_borrow":null,"last_year_asset":null,"last_year_debt":null,"last_year_receivable":null,"last_year_borrow":null,"concern":null,"flag":0,"level":"AAA","progress":null,"source":null,"status":5,"order":0,"name":"新手测测测","typeName":null,"id":251,"type":6,"content":"a"}
     * otherBorrows : [{"user_id":1003,"addtime":"1500357799","style":3,"repayment_time":null,"repayment_account":11200,"repayment_yesaccount":0,"repayment_yesinterest":0,"account":10000,"account_yes":0,"most_account":10000,"lowest_account":50,"is_day":0,"time_limit":12,"apr":12,"award":0,"part_account":0,"funds":0,"tender_times":0,"borrow_fee":0,"reward_amount":0,"repayment_periods":12,"number_id":"120170718140319260","vouch_type":0,"end_time":"1501394692","valid_time":12,"verify_time4":null,"vouch_user":"","vouch_card_no":"","litpic":"","verify_time":"1500357883","verify_remark":"申请补充完成！","addip":"218.74.250.185","site_id":0,"is_VIP":0,"dispaly":0,"hits":0,"use":"1212","accept_bank":null,"vouch_account":0,"vouch_award":null,"vouch_times":0,"customer":null,"forst_account":0,"monthly_repayment":0,"each_time":null,"finish_time":null,"open_account":null,"open_borrow":null,"promotion_info":null,"risk_warning":"<img src=\"/gcs/uploadFile/image/20170718/20170718140345_788.jpg\" alt=\"\"/>","is_false":null,"open_tender":null,"open_credit":null,"success_time":null,"publish":"","verify_user":"超级管理员","verify_user2":"超级管理员","verify_remark2":"123","verify_time2":"1500357888","verify_user3":"超级管理员","verify_remark3":"321","verify_time3":"1500357892","verify_user4":null,"verify_remark4":null,"cancel_user":null,"cancel_remark":null,"cancel_time":null,"family_assets":null,"family_annual_income":null,"social_security_status":null,"credit_card_status":null,"invisible_assets":null,"commercial_insurance_status":null,"bank_credit_record":null,"industry":null,"enterprise_type":null,"brand":null,"patent_num":null,"operation_state":null,"last_month_asset":null,"last_month_debt":null,"last_month_receivable":null,"last_month_borrow":null,"last_year_asset":null,"last_year_debt":null,"last_year_receivable":null,"last_year_borrow":null,"concern":null,"flag":0,"level":"AAA","progress":null,"source":null,"status":3,"order":0,"name":"我胖胖哒","typeName":"信用标","id":260,"type":1,"content":"<img src=\"/gcs/uploadFile/image/20170718/20170718140422_277.jpg\" alt=\"\" />"}]
     * account : {"use_money":8.59,"no_use_money":0,"collection":577292.8,"user_id":1003,"virtual_money":null,"total":48.59,"username":null,"id":1002,"type":null,"realName":null}
     * repayments : [{"addtime":"1500349997","repayment_time":"1500781997","borrow_id":251,"repayment_account":500.11,"capital":500,"interest":0.11,"repayment_yesaccount":0,"webstatus":0,"borrow":null,"addip":"218.74.250.185","siteId":0,"advance_time":null,"auto":0,"repayment_yestime":null,"late_days":0,"late_interest":0,"forfeit":null,"reminder_fee":null,"user":null,"userAccount":null,"status":0,"order":1,"id":224}]
     * status : 1
     */

    private UserNameMapBean userNameMap;
    private BorrowBean borrow;
    private AccountBean account;
    private String tendersCount;
    private String status;
    private List<ImgsBean> imgs;
    private List<TendersBean> tenders;
    private List<RedsBean> reds;
    private List<OtherBorrowsBean> otherBorrows;
    private List<RepaymentsBean> repayments;

    public String getTendersCount() {
        return tendersCount;
    }

    public void setTendersCount(String tendersCount) {
        this.tendersCount = tendersCount;
    }

    public UserNameMapBean getUserNameMap() {
        return userNameMap;
    }

    public void setUserNameMap(UserNameMapBean userNameMap) {
        this.userNameMap = userNameMap;
    }

    public BorrowBean getBorrow() {
        return borrow;
    }

    public void setBorrow(BorrowBean borrow) {
        this.borrow = borrow;
    }

    public AccountBean getAccount() {
        return account;
    }

    public void setAccount(AccountBean account) {
        this.account = account;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ImgsBean> getImgs() {
        return imgs;
    }

    public void setImgs(List<ImgsBean> imgs) {
        this.imgs = imgs;
    }

    public List<TendersBean> getTenders() {
        return tenders;
    }

    public void setTenders(List<TendersBean> tenders) {
        this.tenders = tenders;
    }

    public List<RedsBean> getReds() {
        return reds;
    }

    public void setReds(List<RedsBean> reds) {
        this.reds = reds;
    }

    public List<OtherBorrowsBean> getOtherBorrows() {
        return otherBorrows;
    }

    public void setOtherBorrows(List<OtherBorrowsBean> otherBorrows) {
        this.otherBorrows = otherBorrows;
    }

    public List<RepaymentsBean> getRepayments() {
        return repayments;
    }

    public void setRepayments(List<RepaymentsBean> repayments) {
        this.repayments = repayments;
    }

    public static class UserNameMapBean {
        /**
         * 11116 : 15547936451
         * 11117 : 13486096437
         * 11122 : 13056724910
         */

        @SerializedName("11116")
        private String _$11116;
        @SerializedName("11117")
        private String _$11117;
        @SerializedName("11122")
        private String _$11122;

        public String get_$11116() {
            return _$11116;
        }

        public void set_$11116(String _$11116) {
            this._$11116 = _$11116;
        }

        public String get_$11117() {
            return _$11117;
        }

        public void set_$11117(String _$11117) {
            this._$11117 = _$11117;
        }

        public String get_$11122() {
            return _$11122;
        }

        public void set_$11122(String _$11122) {
            this._$11122 = _$11122;
        }
    }

    public static class BorrowBean {
        /**
         * user_id : 11113
         * addtime : 1500258286
         * style : 0
         * repayment_time : 1500781997
         * repayment_account : 500.11
         * repayment_yesaccount : 0
         * repayment_yesinterest : 0
         * account : 500
         * account_yes : 500
         * most_account : 500
         * lowest_account : 80
         * is_day : 1
         * time_limit : 5
         * apr : 1.6
         * award : 2
         * part_account : 0
         * funds : 0.1
         * tender_times : 2
         * borrow_fee : 0
         * reward_amount : 0.5
         * repayment_periods : 1
         * number_id : 620170717102446251
         * vouch_type : 0
         * end_time : 1500431163
         * valid_time : 2
         * verify_time4 : 1500349997
         * vouch_user :
         * vouch_card_no :
         * litpic : /gcs/uploadFile/image/20170717/20170717102538_958.jpg
         * verify_time : 1500258346
         * verify_remark : 申请补充完成！
         * addip : 218.74.248.202
         * site_id : 0
         * is_VIP : 0
         * dispaly : 1
         * hits : 0
         * use : d
         * accept_bank : null
         * vouch_account : 0
         * vouch_award : null
         * vouch_times : 0
         * customer : null
         * forst_account : 0
         * monthly_repayment : 0
         * each_time : null
         * finish_time : null
         * open_account : null
         * open_borrow : null
         * promotion_info : null
         * risk_warning : d
         * is_false : null
         * open_tender : null
         * open_credit : null
         * success_time : 1500349995
         * publish :
         * verify_user : 超级管理员
         * verify_user2 : 超级管理员
         * verify_remark2 : a
         * verify_time2 : 1500258357
         * verify_user3 : 超级管理员
         * verify_remark3 : d
         * verify_time3 : 1500258363
         * verify_user4 : 无
         * verify_remark4 : 自动审核
         * cancel_user : null
         * cancel_remark : null
         * cancel_time : null
         * family_assets : null
         * family_annual_income : null
         * social_security_status : null
         * credit_card_status : null
         * invisible_assets : null
         * commercial_insurance_status : null
         * bank_credit_record : null
         * industry : null
         * enterprise_type : null
         * brand : null
         * patent_num : null
         * operation_state : null
         * last_month_asset : null
         * last_month_debt : null
         * last_month_receivable : null
         * last_month_borrow : null
         * last_year_asset : null
         * last_year_debt : null
         * last_year_receivable : null
         * last_year_borrow : null
         * concern : null
         * flag : 0
         * level : AAA
         * progress : null
         * source : null
         * status : 5
         * order : 0
         * name : 新手测测测
         * typeName : null
         * id : 251
         * type : 6
         * content : a
         */

        private int user_id;
        private String addtime;
        private int style;
        private String repayment_time;
        private double repayment_account;
        private double repayment_yesaccount;
        private double repayment_yesinterest;
        private float account;
        private float account_yes;
        private float most_account;
        private float lowest_account;
        private int is_day;
        private int time_limit;
        private double apr;
        private int award;
        private double part_account;
        private double funds;
        private int tender_times;
        private int borrow_fee;
        private double reward_amount;
        private int repayment_periods;
        private String number_id;
        private int vouch_type;
        private String end_time;
        private int valid_time;
        private String verify_time4;
        private String vouch_user;
        private String vouch_card_no;
        private String litpic;
        private String verify_time;
        private String verify_remark;
        private String addip;
        private int site_id;
        private int is_VIP;
        private int dispaly;
        private int hits;
        private String use;
        private Object accept_bank;
        private int vouch_account;
        private Object vouch_award;
        private int vouch_times;
        private Object customer;
        private int forst_account;
        private float monthly_repayment;
        private Object each_time;
        private Object finish_time;
        private Object open_account;
        private Object open_borrow;
        private String promotion_info;
        private String risk_warning;
        private Object is_false;
        private Object open_tender;
        private Object open_credit;
        private String success_time;
        private String publish;
        private String verify_user;
        private String verify_user2;
        private String verify_remark2;
        private String verify_time2;
        private String verify_user3;
        private String verify_remark3;
        private String verify_time3;
        private String verify_user4;
        private String verify_remark4;
        private Object cancel_user;
        private Object cancel_remark;
        private Object cancel_time;
        private Object family_assets;
        private Object family_annual_income;
        private Object social_security_status;
        private Object credit_card_status;
        private Object invisible_assets;
        private Object commercial_insurance_status;
        private Object bank_credit_record;
        private Object industry;
        private Object enterprise_type;
        private Object brand;
        private Object patent_num;
        private Object operation_state;
        private Object last_month_asset;
        private Object last_month_debt;
        private Object last_month_receivable;
        private Object last_month_borrow;
        private Object last_year_asset;
        private Object last_year_debt;
        private Object last_year_receivable;
        private Object last_year_borrow;
        private Object concern;
        private int flag;
        private String level;
        private Object progress;
        private Object source;
        private int status;
        private int order;
        private String name;
        private Object typeName;
        private int id;
        private int type;
        private String content;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public int getStyle() {
            return style;
        }

        public void setStyle(int style) {
            this.style = style;
        }

        public String getRepayment_time() {
            return repayment_time;
        }

        public void setRepayment_time(String repayment_time) {
            this.repayment_time = repayment_time;
        }

        public double getRepayment_account() {
            return repayment_account;
        }

        public void setRepayment_account(double repayment_account) {
            this.repayment_account = repayment_account;
        }

        public double getRepayment_yesaccount() {
            return repayment_yesaccount;
        }

        public void setRepayment_yesaccount(double repayment_yesaccount) {
            this.repayment_yesaccount = repayment_yesaccount;
        }

        public double getRepayment_yesinterest() {
            return repayment_yesinterest;
        }

        public void setRepayment_yesinterest(double repayment_yesinterest) {
            this.repayment_yesinterest = repayment_yesinterest;
        }

        public float getAccount() {
            return account;
        }

        public void setAccount(float account) {
            this.account = account;
        }

        public float getAccount_yes() {
            return account_yes;
        }

        public void setAccount_yes(float account_yes) {
            this.account_yes = account_yes;
        }

        public float getMost_account() {
            return most_account;
        }

        public void setMost_account(float most_account) {
            this.most_account = most_account;
        }

        public float getLowest_account() {
            return lowest_account;
        }

        public void setLowest_account(float lowest_account) {
            this.lowest_account = lowest_account;
        }

        public int getIs_day() {
            return is_day;
        }

        public void setIs_day(int is_day) {
            this.is_day = is_day;
        }

        public int getTime_limit() {
            return time_limit;
        }

        public void setTime_limit(int time_limit) {
            this.time_limit = time_limit;
        }

        public double getApr() {
            return apr;
        }

        public void setApr(double apr) {
            this.apr = apr;
        }

        public int getAward() {
            return award;
        }

        public void setAward(int award) {
            this.award = award;
        }

        public double getPart_account() {
            return part_account;
        }

        public void setPart_account(double part_account) {
            this.part_account = part_account;
        }

        public double getFunds() {
            return funds;
        }

        public void setFunds(double funds) {
            this.funds = funds;
        }

        public int getTender_times() {
            return tender_times;
        }

        public void setTender_times(int tender_times) {
            this.tender_times = tender_times;
        }

        public int getBorrow_fee() {
            return borrow_fee;
        }

        public void setBorrow_fee(int borrow_fee) {
            this.borrow_fee = borrow_fee;
        }

        public double getReward_amount() {
            return reward_amount;
        }

        public void setReward_amount(double reward_amount) {
            this.reward_amount = reward_amount;
        }

        public int getRepayment_periods() {
            return repayment_periods;
        }

        public void setRepayment_periods(int repayment_periods) {
            this.repayment_periods = repayment_periods;
        }

        public String getNumber_id() {
            return number_id;
        }

        public void setNumber_id(String number_id) {
            this.number_id = number_id;
        }

        public int getVouch_type() {
            return vouch_type;
        }

        public void setVouch_type(int vouch_type) {
            this.vouch_type = vouch_type;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public int getValid_time() {
            return valid_time;
        }

        public void setValid_time(int valid_time) {
            this.valid_time = valid_time;
        }

        public String getVerify_time4() {
            return verify_time4;
        }

        public void setVerify_time4(String verify_time4) {
            this.verify_time4 = verify_time4;
        }

        public String getVouch_user() {
            return vouch_user;
        }

        public void setVouch_user(String vouch_user) {
            this.vouch_user = vouch_user;
        }

        public String getVouch_card_no() {
            return vouch_card_no;
        }

        public void setVouch_card_no(String vouch_card_no) {
            this.vouch_card_no = vouch_card_no;
        }

        public String getLitpic() {
            return litpic;
        }

        public void setLitpic(String litpic) {
            this.litpic = litpic;
        }

        public String getVerify_time() {
            return verify_time;
        }

        public void setVerify_time(String verify_time) {
            this.verify_time = verify_time;
        }

        public String getVerify_remark() {
            return verify_remark;
        }

        public void setVerify_remark(String verify_remark) {
            this.verify_remark = verify_remark;
        }

        public String getAddip() {
            return addip;
        }

        public void setAddip(String addip) {
            this.addip = addip;
        }

        public int getSite_id() {
            return site_id;
        }

        public void setSite_id(int site_id) {
            this.site_id = site_id;
        }

        public int getIs_VIP() {
            return is_VIP;
        }

        public void setIs_VIP(int is_VIP) {
            this.is_VIP = is_VIP;
        }

        public int getDispaly() {
            return dispaly;
        }

        public void setDispaly(int dispaly) {
            this.dispaly = dispaly;
        }

        public int getHits() {
            return hits;
        }

        public void setHits(int hits) {
            this.hits = hits;
        }

        public String getUse() {
            return use;
        }

        public void setUse(String use) {
            this.use = use;
        }

        public Object getAccept_bank() {
            return accept_bank;
        }

        public void setAccept_bank(Object accept_bank) {
            this.accept_bank = accept_bank;
        }

        public int getVouch_account() {
            return vouch_account;
        }

        public void setVouch_account(int vouch_account) {
            this.vouch_account = vouch_account;
        }

        public Object getVouch_award() {
            return vouch_award;
        }

        public void setVouch_award(Object vouch_award) {
            this.vouch_award = vouch_award;
        }

        public int getVouch_times() {
            return vouch_times;
        }

        public void setVouch_times(int vouch_times) {
            this.vouch_times = vouch_times;
        }

        public Object getCustomer() {
            return customer;
        }

        public void setCustomer(Object customer) {
            this.customer = customer;
        }

        public int getForst_account() {
            return forst_account;
        }

        public void setForst_account(int forst_account) {
            this.forst_account = forst_account;
        }

        public float getMonthly_repayment() {
            return monthly_repayment;
        }

        public void setMonthly_repayment(float monthly_repayment) {
            this.monthly_repayment = monthly_repayment;
        }

        public Object getEach_time() {
            return each_time;
        }

        public void setEach_time(Object each_time) {
            this.each_time = each_time;
        }

        public Object getFinish_time() {
            return finish_time;
        }

        public void setFinish_time(Object finish_time) {
            this.finish_time = finish_time;
        }

        public Object getOpen_account() {
            return open_account;
        }

        public void setOpen_account(Object open_account) {
            this.open_account = open_account;
        }

        public Object getOpen_borrow() {
            return open_borrow;
        }

        public void setOpen_borrow(Object open_borrow) {
            this.open_borrow = open_borrow;
        }

        public String getPromotion_info() {
            return promotion_info;
        }

        public void setPromotion_info(String promotion_info) {
            this.promotion_info = promotion_info;
        }

        public String getRisk_warning() {
            return risk_warning;
        }

        public void setRisk_warning(String risk_warning) {
            this.risk_warning = risk_warning;
        }

        public Object getIs_false() {
            return is_false;
        }

        public void setIs_false(Object is_false) {
            this.is_false = is_false;
        }

        public Object getOpen_tender() {
            return open_tender;
        }

        public void setOpen_tender(Object open_tender) {
            this.open_tender = open_tender;
        }

        public Object getOpen_credit() {
            return open_credit;
        }

        public void setOpen_credit(Object open_credit) {
            this.open_credit = open_credit;
        }

        public String getSuccess_time() {
            return success_time;
        }

        public void setSuccess_time(String success_time) {
            this.success_time = success_time;
        }

        public String getPublish() {
            return publish;
        }

        public void setPublish(String publish) {
            this.publish = publish;
        }

        public String getVerify_user() {
            return verify_user;
        }

        public void setVerify_user(String verify_user) {
            this.verify_user = verify_user;
        }

        public String getVerify_user2() {
            return verify_user2;
        }

        public void setVerify_user2(String verify_user2) {
            this.verify_user2 = verify_user2;
        }

        public String getVerify_remark2() {
            return verify_remark2;
        }

        public void setVerify_remark2(String verify_remark2) {
            this.verify_remark2 = verify_remark2;
        }

        public String getVerify_time2() {
            return verify_time2;
        }

        public void setVerify_time2(String verify_time2) {
            this.verify_time2 = verify_time2;
        }

        public String getVerify_user3() {
            return verify_user3;
        }

        public void setVerify_user3(String verify_user3) {
            this.verify_user3 = verify_user3;
        }

        public String getVerify_remark3() {
            return verify_remark3;
        }

        public void setVerify_remark3(String verify_remark3) {
            this.verify_remark3 = verify_remark3;
        }

        public String getVerify_time3() {
            return verify_time3;
        }

        public void setVerify_time3(String verify_time3) {
            this.verify_time3 = verify_time3;
        }

        public String getVerify_user4() {
            return verify_user4;
        }

        public void setVerify_user4(String verify_user4) {
            this.verify_user4 = verify_user4;
        }

        public String getVerify_remark4() {
            return verify_remark4;
        }

        public void setVerify_remark4(String verify_remark4) {
            this.verify_remark4 = verify_remark4;
        }

        public Object getCancel_user() {
            return cancel_user;
        }

        public void setCancel_user(Object cancel_user) {
            this.cancel_user = cancel_user;
        }

        public Object getCancel_remark() {
            return cancel_remark;
        }

        public void setCancel_remark(Object cancel_remark) {
            this.cancel_remark = cancel_remark;
        }

        public Object getCancel_time() {
            return cancel_time;
        }

        public void setCancel_time(Object cancel_time) {
            this.cancel_time = cancel_time;
        }

        public Object getFamily_assets() {
            return family_assets;
        }

        public void setFamily_assets(Object family_assets) {
            this.family_assets = family_assets;
        }

        public Object getFamily_annual_income() {
            return family_annual_income;
        }

        public void setFamily_annual_income(Object family_annual_income) {
            this.family_annual_income = family_annual_income;
        }

        public Object getSocial_security_status() {
            return social_security_status;
        }

        public void setSocial_security_status(Object social_security_status) {
            this.social_security_status = social_security_status;
        }

        public Object getCredit_card_status() {
            return credit_card_status;
        }

        public void setCredit_card_status(Object credit_card_status) {
            this.credit_card_status = credit_card_status;
        }

        public Object getInvisible_assets() {
            return invisible_assets;
        }

        public void setInvisible_assets(Object invisible_assets) {
            this.invisible_assets = invisible_assets;
        }

        public Object getCommercial_insurance_status() {
            return commercial_insurance_status;
        }

        public void setCommercial_insurance_status(Object commercial_insurance_status) {
            this.commercial_insurance_status = commercial_insurance_status;
        }

        public Object getBank_credit_record() {
            return bank_credit_record;
        }

        public void setBank_credit_record(Object bank_credit_record) {
            this.bank_credit_record = bank_credit_record;
        }

        public Object getIndustry() {
            return industry;
        }

        public void setIndustry(Object industry) {
            this.industry = industry;
        }

        public Object getEnterprise_type() {
            return enterprise_type;
        }

        public void setEnterprise_type(Object enterprise_type) {
            this.enterprise_type = enterprise_type;
        }

        public Object getBrand() {
            return brand;
        }

        public void setBrand(Object brand) {
            this.brand = brand;
        }

        public Object getPatent_num() {
            return patent_num;
        }

        public void setPatent_num(Object patent_num) {
            this.patent_num = patent_num;
        }

        public Object getOperation_state() {
            return operation_state;
        }

        public void setOperation_state(Object operation_state) {
            this.operation_state = operation_state;
        }

        public Object getLast_month_asset() {
            return last_month_asset;
        }

        public void setLast_month_asset(Object last_month_asset) {
            this.last_month_asset = last_month_asset;
        }

        public Object getLast_month_debt() {
            return last_month_debt;
        }

        public void setLast_month_debt(Object last_month_debt) {
            this.last_month_debt = last_month_debt;
        }

        public Object getLast_month_receivable() {
            return last_month_receivable;
        }

        public void setLast_month_receivable(Object last_month_receivable) {
            this.last_month_receivable = last_month_receivable;
        }

        public Object getLast_month_borrow() {
            return last_month_borrow;
        }

        public void setLast_month_borrow(Object last_month_borrow) {
            this.last_month_borrow = last_month_borrow;
        }

        public Object getLast_year_asset() {
            return last_year_asset;
        }

        public void setLast_year_asset(Object last_year_asset) {
            this.last_year_asset = last_year_asset;
        }

        public Object getLast_year_debt() {
            return last_year_debt;
        }

        public void setLast_year_debt(Object last_year_debt) {
            this.last_year_debt = last_year_debt;
        }

        public Object getLast_year_receivable() {
            return last_year_receivable;
        }

        public void setLast_year_receivable(Object last_year_receivable) {
            this.last_year_receivable = last_year_receivable;
        }

        public Object getLast_year_borrow() {
            return last_year_borrow;
        }

        public void setLast_year_borrow(Object last_year_borrow) {
            this.last_year_borrow = last_year_borrow;
        }

        public Object getConcern() {
            return concern;
        }

        public void setConcern(Object concern) {
            this.concern = concern;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public Object getProgress() {
            return progress;
        }

        public void setProgress(Object progress) {
            this.progress = progress;
        }

        public Object getSource() {
            return source;
        }

        public void setSource(Object source) {
            this.source = source;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getTypeName() {
            return typeName;
        }

        public void setTypeName(Object typeName) {
            this.typeName = typeName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public static class AccountBean {
        /**
         * use_money : 8.59
         * no_use_money : 0
         * collection : 577292.8
         * user_id : 1003
         * virtual_money : null
         * total : 48.59
         * username : null
         * id : 1002
         * type : null
         * realName : null
         */

        private double use_money;
        private int no_use_money;
        private double collection;
        private int user_id;
        private Object virtual_money;
        private double total;
        private Object username;
        private int id;
        private Object type;
        private Object realName;

        public double getUse_money() {
            return use_money;
        }

        public void setUse_money(double use_money) {
            this.use_money = use_money;
        }

        public int getNo_use_money() {
            return no_use_money;
        }

        public void setNo_use_money(int no_use_money) {
            this.no_use_money = no_use_money;
        }

        public double getCollection() {
            return collection;
        }

        public void setCollection(double collection) {
            this.collection = collection;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public Object getVirtual_money() {
            return virtual_money;
        }

        public void setVirtual_money(Object virtual_money) {
            this.virtual_money = virtual_money;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public Object getUsername() {
            return username;
        }

        public void setUsername(Object username) {
            this.username = username;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public Object getRealName() {
            return realName;
        }

        public void setRealName(Object realName) {
            this.realName = realName;
        }
    }

    public static class ImgsBean {
        /**
         * user_id : null
         * borrow_id : 251
         * img : /gcs/uploadFile/image/20170717/20170717102441_732.jpg
         * id : 5906
         */

        private Object user_id;
        private int borrow_id;
        private String img;
        private int id;

        public Object getUser_id() {
            return user_id;
        }

        public void setUser_id(Object user_id) {
            this.user_id = user_id;
        }

        public int getBorrow_id() {
            return borrow_id;
        }

        public void setBorrow_id(int borrow_id) {
            this.borrow_id = borrow_id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class TendersBean {
        /**
         * user_id : 11117
         * addtime : 1500349995
         * money : 280
         * borrow_id : 251
         * repayment_account : 280.06
         * interest : 0.06
         * repayment_yesaccount : 0
         * repayment_yesinterest : 0
         * borrowName : null
         * borrowNo : null
         * account : 280
         * user_red_id : 0
         * wait_account : 280.06
         * wait_interest : 0.06
         * addip : 218.74.250.185
         * site_id : 0
         * verifyTime4 : null
         * tender_type : 0
         * contract_no : null
         * seconds : 0
         * userName : null
         * status : 1
         * realName : null
         * page : null
         * beginDate : null
         * endDate : null
         * delete_flag : null
         * id : 1444
         */

        private int user_id;
        private String addtime;
        private int money;
        private int borrow_id;
        private double repayment_account;
        private double interest;
        private double repayment_yesaccount;
        private double repayment_yesinterest;
        private Object borrowName;
        private Object borrowNo;
        private int account;
        private int user_red_id;
        private double wait_account;
        private double wait_interest;
        private String addip;
        private int site_id;
        private Object verifyTime4;
        private int tender_type;
        private Object contract_no;
        private int seconds;
        private String userName;
        private int status;
        private Object realName;
        private Object page;
        private Object beginDate;
        private Object endDate;
        private Object delete_flag;
        private int id;
        private String mobile;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public int getBorrow_id() {
            return borrow_id;
        }

        public void setBorrow_id(int borrow_id) {
            this.borrow_id = borrow_id;
        }

        public double getRepayment_account() {
            return repayment_account;
        }

        public void setRepayment_account(double repayment_account) {
            this.repayment_account = repayment_account;
        }

        public double getInterest() {
            return interest;
        }

        public void setInterest(double interest) {
            this.interest = interest;
        }

        public double getRepayment_yesaccount() {
            return repayment_yesaccount;
        }

        public void setRepayment_yesaccount(double repayment_yesaccount) {
            this.repayment_yesaccount = repayment_yesaccount;
        }

        public double getRepayment_yesinterest() {
            return repayment_yesinterest;
        }

        public void setRepayment_yesinterest(double repayment_yesinterest) {
            this.repayment_yesinterest = repayment_yesinterest;
        }

        public Object getBorrowName() {
            return borrowName;
        }

        public void setBorrowName(Object borrowName) {
            this.borrowName = borrowName;
        }

        public Object getBorrowNo() {
            return borrowNo;
        }

        public void setBorrowNo(Object borrowNo) {
            this.borrowNo = borrowNo;
        }

        public int getAccount() {
            return account;
        }

        public void setAccount(int account) {
            this.account = account;
        }

        public int getUser_red_id() {
            return user_red_id;
        }

        public void setUser_red_id(int user_red_id) {
            this.user_red_id = user_red_id;
        }

        public double getWait_account() {
            return wait_account;
        }

        public void setWait_account(double wait_account) {
            this.wait_account = wait_account;
        }

        public double getWait_interest() {
            return wait_interest;
        }

        public void setWait_interest(double wait_interest) {
            this.wait_interest = wait_interest;
        }

        public String getAddip() {
            return addip;
        }

        public void setAddip(String addip) {
            this.addip = addip;
        }

        public int getSite_id() {
            return site_id;
        }

        public void setSite_id(int site_id) {
            this.site_id = site_id;
        }

        public Object getVerifyTime4() {
            return verifyTime4;
        }

        public void setVerifyTime4(Object verifyTime4) {
            this.verifyTime4 = verifyTime4;
        }

        public int getTender_type() {
            return tender_type;
        }

        public void setTender_type(int tender_type) {
            this.tender_type = tender_type;
        }

        public Object getContract_no() {
            return contract_no;
        }

        public void setContract_no(Object contract_no) {
            this.contract_no = contract_no;
        }

        public int getSeconds() {
            return seconds;
        }

        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Object getRealName() {
            return realName;
        }

        public void setRealName(Object realName) {
            this.realName = realName;
        }

        public Object getPage() {
            return page;
        }

        public void setPage(Object page) {
            this.page = page;
        }

        public Object getBeginDate() {
            return beginDate;
        }

        public void setBeginDate(Object beginDate) {
            this.beginDate = beginDate;
        }

        public Object getEndDate() {
            return endDate;
        }

        public void setEndDate(Object endDate) {
            this.endDate = endDate;
        }

        public Object getDelete_flag() {
            return delete_flag;
        }

        public void setDelete_flag(Object delete_flag) {
            this.delete_flag = delete_flag;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class RedsBean {
        /**
         * red_type_name : 满1000减10元
         * user_id : 1003
         * add_time : 1499044048
         * red_id : 1
         * red_type_id : 2
         * red_account : 0
         * start_date : 2017-07-03
         * end_date : 2017-09-01
         * userName : null
         * status : 0
         * id : 9
         */

        private String red_type_name;
        private int user_id;
        private String add_time;
        private int red_id;
        private int red_type_id;
        private int red_account;
        private String start_date;
        private String end_date;
        private Object userName;
        private int status;
        private int id;
        private String red_title;

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

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
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

        public String getEnd_date() {
            return end_date;
        }

        public void setEnd_date(String end_date) {
            this.end_date = end_date;
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

        public String getRed_title() {
            return red_title;
        }

        public void setRed_title(String red_title) {
            this.red_title = red_title;
        }
    }

    public static class OtherBorrowsBean {
        /**
         * user_id : 1003
         * addtime : 1500357799
         * style : 3
         * repayment_time : null
         * repayment_account : 11200
         * repayment_yesaccount : 0
         * repayment_yesinterest : 0
         * account : 10000
         * account_yes : 0
         * most_account : 10000
         * lowest_account : 50
         * is_day : 0
         * time_limit : 12
         * apr : 12
         * award : 0
         * part_account : 0
         * funds : 0
         * tender_times : 0
         * borrow_fee : 0
         * reward_amount : 0
         * repayment_periods : 12
         * number_id : 120170718140319260
         * vouch_type : 0
         * end_time : 1501394692
         * valid_time : 12
         * verify_time4 : null
         * vouch_user :
         * vouch_card_no :
         * litpic :
         * verify_time : 1500357883
         * verify_remark : 申请补充完成！
         * addip : 218.74.250.185
         * site_id : 0
         * is_VIP : 0
         * dispaly : 0
         * hits : 0
         * use : 1212
         * accept_bank : null
         * vouch_account : 0
         * vouch_award : null
         * vouch_times : 0
         * customer : null
         * forst_account : 0
         * monthly_repayment : 0
         * each_time : null
         * finish_time : null
         * open_account : null
         * open_borrow : null
         * promotion_info : null
         * risk_warning : <img src="/gcs/uploadFile/image/20170718/20170718140345_788.jpg" alt=""/>
         * is_false : null
         * open_tender : null
         * open_credit : null
         * success_time : null
         * publish :
         * verify_user : 超级管理员
         * verify_user2 : 超级管理员
         * verify_remark2 : 123
         * verify_time2 : 1500357888
         * verify_user3 : 超级管理员
         * verify_remark3 : 321
         * verify_time3 : 1500357892
         * verify_user4 : null
         * verify_remark4 : null
         * cancel_user : null
         * cancel_remark : null
         * cancel_time : null
         * family_assets : null
         * family_annual_income : null
         * social_security_status : null
         * credit_card_status : null
         * invisible_assets : null
         * commercial_insurance_status : null
         * bank_credit_record : null
         * industry : null
         * enterprise_type : null
         * brand : null
         * patent_num : null
         * operation_state : null
         * last_month_asset : null
         * last_month_debt : null
         * last_month_receivable : null
         * last_month_borrow : null
         * last_year_asset : null
         * last_year_debt : null
         * last_year_receivable : null
         * last_year_borrow : null
         * concern : null
         * flag : 0
         * level : AAA
         * progress : null
         * source : null
         * status : 3
         * order : 0
         * name : 我胖胖哒
         * typeName : 信用标
         * id : 260
         * type : 1
         * content : <img src="/gcs/uploadFile/image/20170718/20170718140422_277.jpg" alt="" />
         */

        private int user_id;
        private String addtime;
        private int style;
        private Object repayment_time;
        private double repayment_account;
        private double repayment_yesaccount;
        private float repayment_yesinterest;
        private float account;
        private float account_yes;
        private int most_account;
        private int lowest_account;
        private int is_day;
        private int time_limit;
        private double apr;
        private int award;
        private Object part_account;
        private Object funds;
        private int tender_times;
        private int borrow_fee;
        private double reward_amount;
        private int repayment_periods;
        private String number_id;
        private int vouch_type;
        private String end_time;
        private int valid_time;
        private Object verify_time4;
        private String vouch_user;
        private String vouch_card_no;
        private String litpic;
        private String verify_time;
        private String verify_remark;
        private String addip;
        private int site_id;
        private int is_VIP;
        private int dispaly;
        private int hits;
        private String use;
        private Object accept_bank;
        private int vouch_account;
        private Object vouch_award;
        private int vouch_times;
        private Object customer;
        private int forst_account;
        private float monthly_repayment;
        private Object each_time;
        private Object finish_time;
        private Object open_account;
        private Object open_borrow;
        private Object promotion_info;
        private String risk_warning;
        private Object is_false;
        private Object open_tender;
        private Object open_credit;
        private Object success_time;
        private String publish;
        private String verify_user;
        private String verify_user2;
        private String verify_remark2;
        private String verify_time2;
        private String verify_user3;
        private String verify_remark3;
        private String verify_time3;
        private Object verify_user4;
        private Object verify_remark4;
        private Object cancel_user;
        private Object cancel_remark;
        private Object cancel_time;
        private Object family_assets;
        private Object family_annual_income;
        private Object social_security_status;
        private Object credit_card_status;
        private Object invisible_assets;
        private Object commercial_insurance_status;
        private Object bank_credit_record;
        private Object industry;
        private Object enterprise_type;
        private Object brand;
        private Object patent_num;
        private Object operation_state;
        private Object last_month_asset;
        private Object last_month_debt;
        private Object last_month_receivable;
        private Object last_month_borrow;
        private Object last_year_asset;
        private Object last_year_debt;
        private Object last_year_receivable;
        private Object last_year_borrow;
        private Object concern;
        private int flag;
        private String level;
        private Object progress;
        private Object source;
        private int status;
        private int order;
        private String name;
        private String typeName;
        private int id;
        private int type;
        private String content;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public int getStyle() {
            return style;
        }

        public void setStyle(int style) {
            this.style = style;
        }

        public Object getRepayment_time() {
            return repayment_time;
        }

        public void setRepayment_time(Object repayment_time) {
            this.repayment_time = repayment_time;
        }

        public double getRepayment_account() {
            return repayment_account;
        }

        public void setRepayment_account(double repayment_account) {
            this.repayment_account = repayment_account;
        }

        public double getRepayment_yesaccount() {
            return repayment_yesaccount;
        }

        public void setRepayment_yesaccount(double repayment_yesaccount) {
            this.repayment_yesaccount = repayment_yesaccount;
        }

        public float getRepayment_yesinterest() {
            return repayment_yesinterest;
        }

        public void setRepayment_yesinterest(float repayment_yesinterest) {
            this.repayment_yesinterest = repayment_yesinterest;
        }

        public float getAccount() {
            return account;
        }

        public void setAccount(float account) {
            this.account = account;
        }

        public float getAccount_yes() {
            return account_yes;
        }

        public void setAccount_yes(float account_yes) {
            this.account_yes = account_yes;
        }

        public int getMost_account() {
            return most_account;
        }

        public void setMost_account(int most_account) {
            this.most_account = most_account;
        }

        public int getLowest_account() {
            return lowest_account;
        }

        public void setLowest_account(int lowest_account) {
            this.lowest_account = lowest_account;
        }

        public int getIs_day() {
            return is_day;
        }

        public void setIs_day(int is_day) {
            this.is_day = is_day;
        }

        public int getTime_limit() {
            return time_limit;
        }

        public void setTime_limit(int time_limit) {
            this.time_limit = time_limit;
        }

        public double getApr() {
            return apr;
        }

        public void setApr(double apr) {
            this.apr = apr;
        }

        public int getAward() {
            return award;
        }

        public void setAward(int award) {
            this.award = award;
        }

        public Object getPart_account() {
            return part_account;
        }

        public void setPart_account(Object part_account) {
            this.part_account = part_account;
        }

        public Object getFunds() {
            return funds;
        }

        public void setFunds(Object funds) {
            this.funds = funds;
        }

        public int getTender_times() {
            return tender_times;
        }

        public void setTender_times(int tender_times) {
            this.tender_times = tender_times;
        }

        public int getBorrow_fee() {
            return borrow_fee;
        }

        public void setBorrow_fee(int borrow_fee) {
            this.borrow_fee = borrow_fee;
        }

        public double getReward_amount() {
            return reward_amount;
        }

        public void setReward_amount(double reward_amount) {
            this.reward_amount = reward_amount;
        }

        public int getRepayment_periods() {
            return repayment_periods;
        }

        public void setRepayment_periods(int repayment_periods) {
            this.repayment_periods = repayment_periods;
        }

        public String getNumber_id() {
            return number_id;
        }

        public void setNumber_id(String number_id) {
            this.number_id = number_id;
        }

        public int getVouch_type() {
            return vouch_type;
        }

        public void setVouch_type(int vouch_type) {
            this.vouch_type = vouch_type;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public int getValid_time() {
            return valid_time;
        }

        public void setValid_time(int valid_time) {
            this.valid_time = valid_time;
        }

        public Object getVerify_time4() {
            return verify_time4;
        }

        public void setVerify_time4(Object verify_time4) {
            this.verify_time4 = verify_time4;
        }

        public String getVouch_user() {
            return vouch_user;
        }

        public void setVouch_user(String vouch_user) {
            this.vouch_user = vouch_user;
        }

        public String getVouch_card_no() {
            return vouch_card_no;
        }

        public void setVouch_card_no(String vouch_card_no) {
            this.vouch_card_no = vouch_card_no;
        }

        public String getLitpic() {
            return litpic;
        }

        public void setLitpic(String litpic) {
            this.litpic = litpic;
        }

        public String getVerify_time() {
            return verify_time;
        }

        public void setVerify_time(String verify_time) {
            this.verify_time = verify_time;
        }

        public String getVerify_remark() {
            return verify_remark;
        }

        public void setVerify_remark(String verify_remark) {
            this.verify_remark = verify_remark;
        }

        public String getAddip() {
            return addip;
        }

        public void setAddip(String addip) {
            this.addip = addip;
        }

        public int getSite_id() {
            return site_id;
        }

        public void setSite_id(int site_id) {
            this.site_id = site_id;
        }

        public int getIs_VIP() {
            return is_VIP;
        }

        public void setIs_VIP(int is_VIP) {
            this.is_VIP = is_VIP;
        }

        public int getDispaly() {
            return dispaly;
        }

        public void setDispaly(int dispaly) {
            this.dispaly = dispaly;
        }

        public int getHits() {
            return hits;
        }

        public void setHits(int hits) {
            this.hits = hits;
        }

        public String getUse() {
            return use;
        }

        public void setUse(String use) {
            this.use = use;
        }

        public Object getAccept_bank() {
            return accept_bank;
        }

        public void setAccept_bank(Object accept_bank) {
            this.accept_bank = accept_bank;
        }

        public int getVouch_account() {
            return vouch_account;
        }

        public void setVouch_account(int vouch_account) {
            this.vouch_account = vouch_account;
        }

        public Object getVouch_award() {
            return vouch_award;
        }

        public void setVouch_award(Object vouch_award) {
            this.vouch_award = vouch_award;
        }

        public int getVouch_times() {
            return vouch_times;
        }

        public void setVouch_times(int vouch_times) {
            this.vouch_times = vouch_times;
        }

        public Object getCustomer() {
            return customer;
        }

        public void setCustomer(Object customer) {
            this.customer = customer;
        }

        public int getForst_account() {
            return forst_account;
        }

        public void setForst_account(int forst_account) {
            this.forst_account = forst_account;
        }

        public float getMonthly_repayment() {
            return monthly_repayment;
        }

        public void setMonthly_repayment(float monthly_repayment) {
            this.monthly_repayment = monthly_repayment;
        }

        public Object getEach_time() {
            return each_time;
        }

        public void setEach_time(Object each_time) {
            this.each_time = each_time;
        }

        public Object getFinish_time() {
            return finish_time;
        }

        public void setFinish_time(Object finish_time) {
            this.finish_time = finish_time;
        }

        public Object getOpen_account() {
            return open_account;
        }

        public void setOpen_account(Object open_account) {
            this.open_account = open_account;
        }

        public Object getOpen_borrow() {
            return open_borrow;
        }

        public void setOpen_borrow(Object open_borrow) {
            this.open_borrow = open_borrow;
        }

        public Object getPromotion_info() {
            return promotion_info;
        }

        public void setPromotion_info(Object promotion_info) {
            this.promotion_info = promotion_info;
        }

        public String getRisk_warning() {
            return risk_warning;
        }

        public void setRisk_warning(String risk_warning) {
            this.risk_warning = risk_warning;
        }

        public Object getIs_false() {
            return is_false;
        }

        public void setIs_false(Object is_false) {
            this.is_false = is_false;
        }

        public Object getOpen_tender() {
            return open_tender;
        }

        public void setOpen_tender(Object open_tender) {
            this.open_tender = open_tender;
        }

        public Object getOpen_credit() {
            return open_credit;
        }

        public void setOpen_credit(Object open_credit) {
            this.open_credit = open_credit;
        }

        public Object getSuccess_time() {
            return success_time;
        }

        public void setSuccess_time(Object success_time) {
            this.success_time = success_time;
        }

        public String getPublish() {
            return publish;
        }

        public void setPublish(String publish) {
            this.publish = publish;
        }

        public String getVerify_user() {
            return verify_user;
        }

        public void setVerify_user(String verify_user) {
            this.verify_user = verify_user;
        }

        public String getVerify_user2() {
            return verify_user2;
        }

        public void setVerify_user2(String verify_user2) {
            this.verify_user2 = verify_user2;
        }

        public String getVerify_remark2() {
            return verify_remark2;
        }

        public void setVerify_remark2(String verify_remark2) {
            this.verify_remark2 = verify_remark2;
        }

        public String getVerify_time2() {
            return verify_time2;
        }

        public void setVerify_time2(String verify_time2) {
            this.verify_time2 = verify_time2;
        }

        public String getVerify_user3() {
            return verify_user3;
        }

        public void setVerify_user3(String verify_user3) {
            this.verify_user3 = verify_user3;
        }

        public String getVerify_remark3() {
            return verify_remark3;
        }

        public void setVerify_remark3(String verify_remark3) {
            this.verify_remark3 = verify_remark3;
        }

        public String getVerify_time3() {
            return verify_time3;
        }

        public void setVerify_time3(String verify_time3) {
            this.verify_time3 = verify_time3;
        }

        public Object getVerify_user4() {
            return verify_user4;
        }

        public void setVerify_user4(Object verify_user4) {
            this.verify_user4 = verify_user4;
        }

        public Object getVerify_remark4() {
            return verify_remark4;
        }

        public void setVerify_remark4(Object verify_remark4) {
            this.verify_remark4 = verify_remark4;
        }

        public Object getCancel_user() {
            return cancel_user;
        }

        public void setCancel_user(Object cancel_user) {
            this.cancel_user = cancel_user;
        }

        public Object getCancel_remark() {
            return cancel_remark;
        }

        public void setCancel_remark(Object cancel_remark) {
            this.cancel_remark = cancel_remark;
        }

        public Object getCancel_time() {
            return cancel_time;
        }

        public void setCancel_time(Object cancel_time) {
            this.cancel_time = cancel_time;
        }

        public Object getFamily_assets() {
            return family_assets;
        }

        public void setFamily_assets(Object family_assets) {
            this.family_assets = family_assets;
        }

        public Object getFamily_annual_income() {
            return family_annual_income;
        }

        public void setFamily_annual_income(Object family_annual_income) {
            this.family_annual_income = family_annual_income;
        }

        public Object getSocial_security_status() {
            return social_security_status;
        }

        public void setSocial_security_status(Object social_security_status) {
            this.social_security_status = social_security_status;
        }

        public Object getCredit_card_status() {
            return credit_card_status;
        }

        public void setCredit_card_status(Object credit_card_status) {
            this.credit_card_status = credit_card_status;
        }

        public Object getInvisible_assets() {
            return invisible_assets;
        }

        public void setInvisible_assets(Object invisible_assets) {
            this.invisible_assets = invisible_assets;
        }

        public Object getCommercial_insurance_status() {
            return commercial_insurance_status;
        }

        public void setCommercial_insurance_status(Object commercial_insurance_status) {
            this.commercial_insurance_status = commercial_insurance_status;
        }

        public Object getBank_credit_record() {
            return bank_credit_record;
        }

        public void setBank_credit_record(Object bank_credit_record) {
            this.bank_credit_record = bank_credit_record;
        }

        public Object getIndustry() {
            return industry;
        }

        public void setIndustry(Object industry) {
            this.industry = industry;
        }

        public Object getEnterprise_type() {
            return enterprise_type;
        }

        public void setEnterprise_type(Object enterprise_type) {
            this.enterprise_type = enterprise_type;
        }

        public Object getBrand() {
            return brand;
        }

        public void setBrand(Object brand) {
            this.brand = brand;
        }

        public Object getPatent_num() {
            return patent_num;
        }

        public void setPatent_num(Object patent_num) {
            this.patent_num = patent_num;
        }

        public Object getOperation_state() {
            return operation_state;
        }

        public void setOperation_state(Object operation_state) {
            this.operation_state = operation_state;
        }

        public Object getLast_month_asset() {
            return last_month_asset;
        }

        public void setLast_month_asset(Object last_month_asset) {
            this.last_month_asset = last_month_asset;
        }

        public Object getLast_month_debt() {
            return last_month_debt;
        }

        public void setLast_month_debt(Object last_month_debt) {
            this.last_month_debt = last_month_debt;
        }

        public Object getLast_month_receivable() {
            return last_month_receivable;
        }

        public void setLast_month_receivable(Object last_month_receivable) {
            this.last_month_receivable = last_month_receivable;
        }

        public Object getLast_month_borrow() {
            return last_month_borrow;
        }

        public void setLast_month_borrow(Object last_month_borrow) {
            this.last_month_borrow = last_month_borrow;
        }

        public Object getLast_year_asset() {
            return last_year_asset;
        }

        public void setLast_year_asset(Object last_year_asset) {
            this.last_year_asset = last_year_asset;
        }

        public Object getLast_year_debt() {
            return last_year_debt;
        }

        public void setLast_year_debt(Object last_year_debt) {
            this.last_year_debt = last_year_debt;
        }

        public Object getLast_year_receivable() {
            return last_year_receivable;
        }

        public void setLast_year_receivable(Object last_year_receivable) {
            this.last_year_receivable = last_year_receivable;
        }

        public Object getLast_year_borrow() {
            return last_year_borrow;
        }

        public void setLast_year_borrow(Object last_year_borrow) {
            this.last_year_borrow = last_year_borrow;
        }

        public Object getConcern() {
            return concern;
        }

        public void setConcern(Object concern) {
            this.concern = concern;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public Object getProgress() {
            return progress;
        }

        public void setProgress(Object progress) {
            this.progress = progress;
        }

        public Object getSource() {
            return source;
        }

        public void setSource(Object source) {
            this.source = source;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public static class RepaymentsBean {
        /**
         * addtime : 1500349997
         * repayment_time : 1500781997
         * borrow_id : 251
         * repayment_account : 500.11
         * capital : 500
         * interest : 0.11
         * repayment_yesaccount : 0
         * webstatus : 0
         * borrow : null
         * addip : 218.74.250.185
         * siteId : 0
         * advance_time : null
         * auto : 0
         * repayment_yestime : null
         * late_days : 0
         * late_interest : 0
         * forfeit : null
         * reminder_fee : null
         * user : null
         * userAccount : null
         * status : 0
         * order : 1
         * id : 224
         */

        private String addtime;
        private String repayment_time;
        private int borrow_id;
        private double repayment_account;
        private float capital;
        private double interest;
        private double repayment_yesaccount;
        private int webstatus;
        private Object borrow;
        private String addip;
        private int siteId;
        private Object advance_time;
        private int auto;
        private Object repayment_yestime;
        private int late_days;
        private int late_interest;
        private Object forfeit;
        private Object reminder_fee;
        private Object user;
        private Object userAccount;
        private int status;
        private int order;
        private int id;

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getRepayment_time() {
            return repayment_time;
        }

        public void setRepayment_time(String repayment_time) {
            this.repayment_time = repayment_time;
        }

        public int getBorrow_id() {
            return borrow_id;
        }

        public void setBorrow_id(int borrow_id) {
            this.borrow_id = borrow_id;
        }

        public double getRepayment_account() {
            return repayment_account;
        }

        public void setRepayment_account(double repayment_account) {
            this.repayment_account = repayment_account;
        }

        public float getCapital() {
            return capital;
        }

        public void setCapital(float capital) {
            this.capital = capital;
        }

        public double getInterest() {
            return interest;
        }

        public void setInterest(double interest) {
            this.interest = interest;
        }

        public double getRepayment_yesaccount() {
            return repayment_yesaccount;
        }

        public void setRepayment_yesaccount(double repayment_yesaccount) {
            this.repayment_yesaccount = repayment_yesaccount;
        }

        public int getWebstatus() {
            return webstatus;
        }

        public void setWebstatus(int webstatus) {
            this.webstatus = webstatus;
        }

        public Object getBorrow() {
            return borrow;
        }

        public void setBorrow(Object borrow) {
            this.borrow = borrow;
        }

        public String getAddip() {
            return addip;
        }

        public void setAddip(String addip) {
            this.addip = addip;
        }

        public int getSiteId() {
            return siteId;
        }

        public void setSiteId(int siteId) {
            this.siteId = siteId;
        }

        public Object getAdvance_time() {
            return advance_time;
        }

        public void setAdvance_time(Object advance_time) {
            this.advance_time = advance_time;
        }

        public int getAuto() {
            return auto;
        }

        public void setAuto(int auto) {
            this.auto = auto;
        }

        public Object getRepayment_yestime() {
            return repayment_yestime;
        }

        public void setRepayment_yestime(Object repayment_yestime) {
            this.repayment_yestime = repayment_yestime;
        }

        public int getLate_days() {
            return late_days;
        }

        public void setLate_days(int late_days) {
            this.late_days = late_days;
        }

        public int getLate_interest() {
            return late_interest;
        }

        public void setLate_interest(int late_interest) {
            this.late_interest = late_interest;
        }

        public Object getForfeit() {
            return forfeit;
        }

        public void setForfeit(Object forfeit) {
            this.forfeit = forfeit;
        }

        public Object getReminder_fee() {
            return reminder_fee;
        }

        public void setReminder_fee(Object reminder_fee) {
            this.reminder_fee = reminder_fee;
        }

        public Object getUser() {
            return user;
        }

        public void setUser(Object user) {
            this.user = user;
        }

        public Object getUserAccount() {
            return userAccount;
        }

        public void setUserAccount(Object userAccount) {
            this.userAccount = userAccount;
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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
