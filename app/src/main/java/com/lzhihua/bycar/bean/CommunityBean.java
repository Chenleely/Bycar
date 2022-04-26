package com.lzhihua.bycar.bean;

import java.util.List;

public class CommunityBean {

    public static class Moment {
        public Moment() {

        }

        private int id;
        private String content;
        private int like;
        private String imgUrl;
        private String createTime;
        private String updateTime;

        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setLike(int like) {
            this.like = like;
        }

        public int getLike() {
            return like;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

    }

    public static class Comment {
        public Comment() {

        }

        private int id;
        private String content;
        private int momentId;
        private String createTime;
        private String updateTime;

        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setMomentId(int momentId) {
            this.momentId = momentId;
        }

        public int getMomentId() {
            return momentId;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

    }

    public static class MomentList {
        public MomentList() {
        }

        private String status;
        private Data data;

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public Data getData() {
            return data;
        }

        public static class Data {
            public Data() {
            }

            private int limit;
            private int offset;
            private List<Moment> list;

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public int getLimit() {
                return limit;
            }

            public void setOffset(int offset) {
                this.offset = offset;
            }

            public int getOffset() {
                return offset;
            }

            public void setList(List<Moment> list) {
                this.list = list;
            }

            public List<Moment> getList() {
                return list;
            }

        }
    }

    public static class SelfMomentList {
        public SelfMomentList() {

        }

        private String status;
        private Data data;

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public Data getData() {
            return data;
        }

        public static class Data {
            public Data(){

            }
            private int limit;
            private int offset;
            private List<Moment> list;

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public int getLimit() {
                return limit;
            }

            public void setOffset(int offset) {
                this.offset = offset;
            }

            public int getOffset() {
                return offset;
            }

            public void setList(List<Moment> list) {
                this.list = list;
            }

            public List<Moment> getList() {
                return list;
            }

        }
    }


}
