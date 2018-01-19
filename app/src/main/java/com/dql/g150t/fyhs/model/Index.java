package com.dql.g150t.fyhs.model;

import java.util.List;

/**
 * Created by G150T on 2017/7/14.
 */

public class Index  {

    private List<BorrowsBean> borrows;
    private List<BorrowNewBean> borrowNew;

    private List<WxBannerBean> wxBanner;


    public List<WxBannerBean> getWxBanner() {
        return wxBanner;
    }

    public void setWxBanner(List<WxBannerBean> wxBanner) {
        this.wxBanner = wxBanner;
    }

    public List<BorrowsBean> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<BorrowsBean> borrows) {
        this.borrows = borrows;
    }

    public List<BorrowNewBean> getBorrowNew() {
        return borrowNew;
    }

    public void setBorrowNew(List<BorrowNewBean> borrowNew) {
        this.borrowNew = borrowNew;
    }

    public static class BorrowsBean {
        private int site_id;
        private int is_VIP;
        private int dispaly;
        private int hits;
        private String use;
        private int vouch_times;
        private float monthly_repayment;
        private String risk_warning;
        private String publish;
        private String verify_user;
        private String verify_user2;
        private String verify_remark2;
        private String verify_time2;
        private String verify_user3;
        private String verify_remark3;
        private String verify_time3;

        private int user_id;
        private String addtime;
        private int style;
        private int is_day;
        private int time_limit;
        private double apr;
        private int award;
        private int tender_times;
        private int borrow_fee;
        private int repayment_periods;
        private String number_id;
        private int vouch_type;
        private int valid_time;
        private String end_time;
        private String vouch_user;
        private String vouch_card_no;
        private String litpic;
        private String addip;
        private String verify_time;
        private String verify_remark;
        private int progress;
        private String level;
        private int flag;
        private String name;
        private String typeName;
        private String id;
        private int type;
        private String content;
        private int status;
        private int order;
        private String lowest_account;


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

        public String getLowest_account() {
            return lowest_account;
        }

        public void setLowest_account(String lowest_account) {
            this.lowest_account = lowest_account;
        }

        public String getUse() {
            return use;
        }

        public void setUse(String use) {
            this.use = use;
        }

        public int getVouch_times() {
            return vouch_times;
        }

        public void setVouch_times(int vouch_times) {
            this.vouch_times = vouch_times;
        }

        public float getMonthly_repayment() {
            return monthly_repayment;
        }

        public void setMonthly_repayment(float monthly_repayment) {
            this.monthly_repayment = monthly_repayment;
        }

        public String getRisk_warning() {
            return risk_warning;
        }

        public void setRisk_warning(String risk_warning) {
            this.risk_warning = risk_warning;
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

        public int getValid_time() {
            return valid_time;
        }

        public void setValid_time(int valid_time) {
            this.valid_time = valid_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
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

        public String getAddip() {
            return addip;
        }

        public void setAddip(String addip) {
            this.addip = addip;
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

        public int getProgress() {
            return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
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
    }


    public static class BorrowNewBean {
        private int site_id;
        private int is_VIP;
        private int dispaly;
        private int hits;
        private String use;
        private int vouch_times;
        private float monthly_repayment;
        private String risk_warning;
        private String publish;
        private String verify_user;
        private String verify_user2;
        private String verify_remark2;
        private String verify_time2;
        private String verify_user3;
        private String verify_remark3;
        private String verify_time3;
        private int user_id;
        private String addtime;
        private int style;
        private int is_day;
        private int time_limit;
        private double apr;
        private int award;
        private int tender_times;
        private int borrow_fee;
        private int repayment_periods;
        private String number_id;
        private int vouch_type;
        private int valid_time;
        private String end_time;
        private String vouch_user;
        private String vouch_card_no;
        private String litpic;
        private String addip;
        private String verify_time;
        private String verify_remark;
        private String level;
        private int flag;
        private String name;
        private String typeName;
        private String id;
        private int type;
        private String content;
        private int status;
        private int order;
        private String lowest_account;

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

        public int getVouch_times() {
            return vouch_times;
        }

        public void setVouch_times(int vouch_times) {
            this.vouch_times = vouch_times;
        }

        public float getMonthly_repayment() {
            return monthly_repayment;
        }

        public void setMonthly_repayment(float monthly_repayment) {
            this.monthly_repayment = monthly_repayment;
        }

        public String getLowest_account() {
            return lowest_account;
        }

        public void setLowest_account(String lowest_account) {
            this.lowest_account = lowest_account;
        }

        public String getRisk_warning() {
            return risk_warning;
        }

        public void setRisk_warning(String risk_warning) {
            this.risk_warning = risk_warning;
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

        public int getValid_time() {
            return valid_time;
        }

        public void setValid_time(int valid_time) {
            this.valid_time = valid_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
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

        public String getAddip() {
            return addip;
        }

        public void setAddip(String addip) {
            this.addip = addip;
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

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
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
    }

    public static class WxBannerBean {
        private String url;
        private String ppt_url;
        private int is_display;
        private int dis_order;
        private String add_person;
        private String add_time;
        private String explanation;
        private int category;
        private int id;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPpt_url() {
            return ppt_url;
        }

        public void setPpt_url(String ppt_url) {
            this.ppt_url = ppt_url;
        }

        public int getIs_display() {
            return is_display;
        }

        public void setIs_display(int is_display) {
            this.is_display = is_display;
        }

        public int getDis_order() {
            return dis_order;
        }

        public void setDis_order(int dis_order) {
            this.dis_order = dis_order;
        }

        public String getAdd_person() {
            return add_person;
        }

        public void setAdd_person(String add_person) {
            this.add_person = add_person;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getExplanation() {
            return explanation;
        }

        public void setExplanation(String explanation) {
            this.explanation = explanation;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }


}
