package com.dql.g150t.fyhs.model;

import java.util.List;

/**
 * Created by ST on 2017/7/24.
 */

public class PlatformAnnouncementDetail {

    /**
     * msg : 获取成功
     * newsDetail : {"author":"","title":"321","orderid":"1","hits":null,"issueDate":"1500877918","commentCount":null,"classname":null,"updateTime":"1500877918","updatePerson":"超级管理员","source":"","status":1,"id":589,"type":2,"content":"21321321"}
     * newsType : {"name":"行业新闻","id":2}
     * newsTypes : [{"name":"关于我们","id":1},{"name":"行业新闻","id":2},{"name":"财生动态","id":4},{"name":"新手指引","id":5},{"name":"用户须知","id":6}]
     * status : 1
     */

    private String msg;
    private NewsDetailBean newsDetail;
    private NewsTypeBean newsType;
    private String status;
    private List<NewsTypesBean> newsTypes;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public NewsDetailBean getNewsDetail() {
        return newsDetail;
    }

    public void setNewsDetail(NewsDetailBean newsDetail) {
        this.newsDetail = newsDetail;
    }

    public NewsTypeBean getNewsType() {
        return newsType;
    }

    public void setNewsType(NewsTypeBean newsType) {
        this.newsType = newsType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<NewsTypesBean> getNewsTypes() {
        return newsTypes;
    }

    public void setNewsTypes(List<NewsTypesBean> newsTypes) {
        this.newsTypes = newsTypes;
    }

    public static class NewsDetailBean {
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

    public static class NewsTypeBean {
        /**
         * name : 行业新闻
         * id : 2
         */

        private String name;
        private int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class NewsTypesBean {
        /**
         * name : 关于我们
         * id : 1
         */

        private String name;
        private int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
