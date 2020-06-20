package com.example.muhoitem1.model.domain;

import java.util.List;

public class BannerData {

    /**
     * data : [{"data":{"cid":613,"playerid":22},"id":106,"pagetype":1,"pic":"https://m.muho.tv/bXVob1RW_1592370472.jpg","title":"Rob Mac x 凯索托 训练集锦"},{"data":{"cid":612,"playerid":26},"id":104,"pagetype":1,"pic":"https://m.muho.tv/bXVob1RW_1592316728.jpg","title":"看我这球"},{"data":{"cid":611,"playerid":25},"id":105,"pagetype":1,"pic":"https://m.muho.tv/bXVob1RW_1592297414.jpg","title":"Skyy Clark野球集锦"},{"data":{"cid":51642},"id":97,"pagetype":3,"pic":"https://m.muho.tv/bXVob1RW_1591460088.jpg","title":"更新至特别版 - 前后胯下交叉 胯下变向炸球欧洲步"},{"data":{"cid":609,"playerid":2},"id":103,"pagetype":1,"pic":"https://m.muho.tv/bXVob1RW_1592060554.jpg","title":"艾弗森感谢大家的生日祝福"}]
     * message : SUCCESS
     * stateCode : 200
     */

    private String message;
    private int stateCode;
    private List<DataBeanX> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public List<DataBeanX> getData() {
        return data;
    }

    public void setData(List<DataBeanX> data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * data : {"cid":613,"playerid":22}
         * id : 106
         * pagetype : 1
         * pic : https://m.muho.tv/bXVob1RW_1592370472.jpg
         * title : Rob Mac x 凯索托 训练集锦
         */

        private DataBean data;
        private int id;
        private int pagetype;
        private String pic;
        private String title;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPagetype() {
            return pagetype;
        }

        public void setPagetype(int pagetype) {
            this.pagetype = pagetype;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public static class DataBean {
            /**
             * cid : 613
             * playerid : 22
             */

            private int cid;
            private int playerid;

            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
            }

            public int getPlayerid() {
                return playerid;
            }

            public void setPlayerid(int playerid) {
                this.playerid = playerid;
            }

            @Override
            public String toString() {
                return "DataBean{" +
                        "cid=" + cid +
                        ", playerid=" + playerid +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBeanX{" +
                    "data=" + data +
                    ", id=" + id +
                    ", pagetype=" + pagetype +
                    ", pic='" + pic + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "BannerData{" +
                "message='" + message + '\'' +
                ", stateCode=" + stateCode +
                ", data=" + data +
                '}';
    }
}
