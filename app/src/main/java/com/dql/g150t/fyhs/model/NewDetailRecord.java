package com.dql.g150t.fyhs.model;

import java.util.List;

/**
 * Created by ST on 2017/7/24.
 */

public class NewDetailRecord {


    /**
     * imgsList : ["/uploadFile/image/20170915/20170915164900_53.jpg"]
     * msg : 获取成功
     * activity : {"add_time":"1505468341","red_type":null,"keyAndValue":null,"start_time":"2017-09-14","red_id":null,"end_time":"2017-09-30","limit_num":1,"imgs":"/uploadFile/image/20170915/20170915164900_53.jpg","activity_name":"喜大普奔，注册即送888元理财红包！","img":"/uploadFile/image/20170914/20170914162305_63.jpg","status":1,"id":21,"type":2,"content":""}
     * user : {"user_name":"13065863122","real_name":null,"id_card_no":null,"email":null,"mobile_phone_number":"13065863122","login_password":"dc483e80a7a0bd9ef71d8cf973673924","payment_password":"e10adc3949ba59abbe56e057f20f883e","user_type_id":0,"head_img":"image/data/avatar/no_pic.gif","overdue_times":0,"virtual_currency":0,"credit_level":0,"borrow_times":0,"invest_times":0,"first_tender_time":null,"question":null,"answer":null,"login_times":2,"add_time":"1505785255","add_ip":"122.246.144.224","up_time":null,"up_ip":null,"last_time":"1505785255","last_ip":"122.246.144.224","recommend_id":null,"sp_id":null,"investment_status":null,"investment_time":null,"investment_amout":null,"recommend_url":null,"style":1,"platform_id":1,"oldinvest_times":0,"status":0,"id":11213}
     * status : 1
     */

    private String msg;
    private ActivityBean activity;
    private UserBean user;
    private String status;
    private List<String> imgsList;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ActivityBean getActivity() {
        return activity;
    }

    public void setActivity(ActivityBean activity) {
        this.activity = activity;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getImgsList() {
        return imgsList;
    }

    public void setImgsList(List<String> imgsList) {
        this.imgsList = imgsList;
    }

    public static class ActivityBean {
        /**
         * add_time : 1505468341
         * red_type : null
         * keyAndValue : null
         * start_time : 2017-09-14
         * red_id : null
         * end_time : 2017-09-30
         * limit_num : 1
         * imgs : /uploadFile/image/20170915/20170915164900_53.jpg
         * activity_name : 喜大普奔，注册即送888元理财红包！
         * img : /uploadFile/image/20170914/20170914162305_63.jpg
         * status : 1
         * id : 21
         * type : 2
         * content :
         */

        private String add_time;
        private Object red_type;
        private Object keyAndValue;
        private String start_time;
        private Object red_id;
        private String end_time;
        private int limit_num;
        private String imgs;
        private String activity_name;
        private String img;
        private int status;
        private int id;
        private int type;
        private String content;

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public Object getRed_type() {
            return red_type;
        }

        public void setRed_type(Object red_type) {
            this.red_type = red_type;
        }

        public Object getKeyAndValue() {
            return keyAndValue;
        }

        public void setKeyAndValue(Object keyAndValue) {
            this.keyAndValue = keyAndValue;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public Object getRed_id() {
            return red_id;
        }

        public void setRed_id(Object red_id) {
            this.red_id = red_id;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public int getLimit_num() {
            return limit_num;
        }

        public void setLimit_num(int limit_num) {
            this.limit_num = limit_num;
        }

        public String getImgs() {
            return imgs;
        }

        public void setImgs(String imgs) {
            this.imgs = imgs;
        }

        public String getActivity_name() {
            return activity_name;
        }

        public void setActivity_name(String activity_name) {
            this.activity_name = activity_name;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
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

    public static class UserBean {
        /**
         * user_name : 13065863122
         * real_name : null
         * id_card_no : null
         * email : null
         * mobile_phone_number : 13065863122
         * login_password : dc483e80a7a0bd9ef71d8cf973673924
         * payment_password : e10adc3949ba59abbe56e057f20f883e
         * user_type_id : 0
         * head_img : image/data/avatar/no_pic.gif
         * overdue_times : 0
         * virtual_currency : 0
         * credit_level : 0
         * borrow_times : 0
         * invest_times : 0
         * first_tender_time : null
         * question : null
         * answer : null
         * login_times : 2
         * add_time : 1505785255
         * add_ip : 122.246.144.224
         * up_time : null
         * up_ip : null
         * last_time : 1505785255
         * last_ip : 122.246.144.224
         * recommend_id : null
         * sp_id : null
         * investment_status : null
         * investment_time : null
         * investment_amout : null
         * recommend_url : null
         * style : 1
         * platform_id : 1
         * oldinvest_times : 0
         * status : 0
         * id : 11213
         */

        private String user_name;
        private Object real_name;
        private Object id_card_no;
        private Object email;
        private String mobile_phone_number;
        private String login_password;
        private String payment_password;
        private int user_type_id;
        private String head_img;
        private int overdue_times;
        private int virtual_currency;
        private int credit_level;
        private int borrow_times;
        private int invest_times;
        private Object first_tender_time;
        private Object question;
        private Object answer;
        private int login_times;
        private String add_time;
        private String add_ip;
        private Object up_time;
        private Object up_ip;
        private String last_time;
        private String last_ip;
        private Object recommend_id;
        private Object sp_id;
        private Object investment_status;
        private Object investment_time;
        private Object investment_amout;
        private Object recommend_url;
        private int style;
        private int platform_id;
        private int oldinvest_times;
        private int status;
        private int id;

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public Object getReal_name() {
            return real_name;
        }

        public void setReal_name(Object real_name) {
            this.real_name = real_name;
        }

        public Object getId_card_no() {
            return id_card_no;
        }

        public void setId_card_no(Object id_card_no) {
            this.id_card_no = id_card_no;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public String getMobile_phone_number() {
            return mobile_phone_number;
        }

        public void setMobile_phone_number(String mobile_phone_number) {
            this.mobile_phone_number = mobile_phone_number;
        }

        public String getLogin_password() {
            return login_password;
        }

        public void setLogin_password(String login_password) {
            this.login_password = login_password;
        }

        public String getPayment_password() {
            return payment_password;
        }

        public void setPayment_password(String payment_password) {
            this.payment_password = payment_password;
        }

        public int getUser_type_id() {
            return user_type_id;
        }

        public void setUser_type_id(int user_type_id) {
            this.user_type_id = user_type_id;
        }

        public String getHead_img() {
            return head_img;
        }

        public void setHead_img(String head_img) {
            this.head_img = head_img;
        }

        public int getOverdue_times() {
            return overdue_times;
        }

        public void setOverdue_times(int overdue_times) {
            this.overdue_times = overdue_times;
        }

        public int getVirtual_currency() {
            return virtual_currency;
        }

        public void setVirtual_currency(int virtual_currency) {
            this.virtual_currency = virtual_currency;
        }

        public int getCredit_level() {
            return credit_level;
        }

        public void setCredit_level(int credit_level) {
            this.credit_level = credit_level;
        }

        public int getBorrow_times() {
            return borrow_times;
        }

        public void setBorrow_times(int borrow_times) {
            this.borrow_times = borrow_times;
        }

        public int getInvest_times() {
            return invest_times;
        }

        public void setInvest_times(int invest_times) {
            this.invest_times = invest_times;
        }

        public Object getFirst_tender_time() {
            return first_tender_time;
        }

        public void setFirst_tender_time(Object first_tender_time) {
            this.first_tender_time = first_tender_time;
        }

        public Object getQuestion() {
            return question;
        }

        public void setQuestion(Object question) {
            this.question = question;
        }

        public Object getAnswer() {
            return answer;
        }

        public void setAnswer(Object answer) {
            this.answer = answer;
        }

        public int getLogin_times() {
            return login_times;
        }

        public void setLogin_times(int login_times) {
            this.login_times = login_times;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getAdd_ip() {
            return add_ip;
        }

        public void setAdd_ip(String add_ip) {
            this.add_ip = add_ip;
        }

        public Object getUp_time() {
            return up_time;
        }

        public void setUp_time(Object up_time) {
            this.up_time = up_time;
        }

        public Object getUp_ip() {
            return up_ip;
        }

        public void setUp_ip(Object up_ip) {
            this.up_ip = up_ip;
        }

        public String getLast_time() {
            return last_time;
        }

        public void setLast_time(String last_time) {
            this.last_time = last_time;
        }

        public String getLast_ip() {
            return last_ip;
        }

        public void setLast_ip(String last_ip) {
            this.last_ip = last_ip;
        }

        public Object getRecommend_id() {
            return recommend_id;
        }

        public void setRecommend_id(Object recommend_id) {
            this.recommend_id = recommend_id;
        }

        public Object getSp_id() {
            return sp_id;
        }

        public void setSp_id(Object sp_id) {
            this.sp_id = sp_id;
        }

        public Object getInvestment_status() {
            return investment_status;
        }

        public void setInvestment_status(Object investment_status) {
            this.investment_status = investment_status;
        }

        public Object getInvestment_time() {
            return investment_time;
        }

        public void setInvestment_time(Object investment_time) {
            this.investment_time = investment_time;
        }

        public Object getInvestment_amout() {
            return investment_amout;
        }

        public void setInvestment_amout(Object investment_amout) {
            this.investment_amout = investment_amout;
        }

        public Object getRecommend_url() {
            return recommend_url;
        }

        public void setRecommend_url(Object recommend_url) {
            this.recommend_url = recommend_url;
        }

        public int getStyle() {
            return style;
        }

        public void setStyle(int style) {
            this.style = style;
        }

        public int getPlatform_id() {
            return platform_id;
        }

        public void setPlatform_id(int platform_id) {
            this.platform_id = platform_id;
        }

        public int getOldinvest_times() {
            return oldinvest_times;
        }

        public void setOldinvest_times(int oldinvest_times) {
            this.oldinvest_times = oldinvest_times;
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
