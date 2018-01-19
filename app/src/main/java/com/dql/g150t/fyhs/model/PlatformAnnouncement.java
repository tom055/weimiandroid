package com.dql.g150t.fyhs.model;

import java.util.List;

/**
 * Created by ST on 2017/7/24.
 */

public class PlatformAnnouncement {

    /**
     * msg : 获取成功
     * status : 1
     * announcement : [{"author":"","title":"321","orderid":"1","hits":null,"issueDate":"1500877918","commentCount":null,"classname":null,"updateTime":"1500877918","updatePerson":"超级管理员","source":"","status":1,"id":589,"type":2,"content":"21321321"}]
     */

    private String msg;
    private String status;
    private List<AnnouncementBean> announcement;

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

    public List<AnnouncementBean> getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(List<AnnouncementBean> announcement) {
        this.announcement = announcement;
    }

    public static class AnnouncementBean {
        /**
         * author :
         * title : 321
         * orderid : 1
         * hits : null
         * issueDate : 1500877918
         * commentCount : null
         * classname : null
         * updateTime : 1500877918
         * updatePerson : 超级管理员
         * source :
         * status : 1
         * id : 589
         * type : 2
         * content : 21321321
         */

        private String author;
        private String title;
        private String orderid;
        private Object hits;
        private String issueDate;
        private Object commentCount;
        private Object classname;
        private String updateTime;
        private String updatePerson;
        private String source;
        private int status;
        private int id;
        private int type;
        private String content;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getOrderid() {
            return orderid;
        }

        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

        public Object getHits() {
            return hits;
        }

        public void setHits(Object hits) {
            this.hits = hits;
        }

        public String getIssueDate() {
            return issueDate;
        }

        public void setIssueDate(String issueDate) {
            this.issueDate = issueDate;
        }

        public Object getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(Object commentCount) {
            this.commentCount = commentCount;
        }

        public Object getClassname() {
            return classname;
        }

        public void setClassname(Object classname) {
            this.classname = classname;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getUpdatePerson() {
            return updatePerson;
        }

        public void setUpdatePerson(String updatePerson) {
            this.updatePerson = updatePerson;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
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
}
