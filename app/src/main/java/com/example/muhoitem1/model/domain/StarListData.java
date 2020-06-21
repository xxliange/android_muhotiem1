package com.example.muhoitem1.model.domain;

import java.util.List;

public class StarListData {

    /**
     * data : [{"avatar":"https://m.muho.tv/bXVob1RW_1591183947.jpg?imageView2/1/w/300/h/300/q/75","intro":"娱乐性丰富的篮球训练师","name":"AJ训练师","playerid":26,"symbol":"https://m.muho.tv/bXVob1RW_1591184227.png","symbolpic":"https://m.muho.tv/bXVob1RW_1591184163.png","theme":"#9d9eb4"},{"avatar":"https://m.muho.tv/bXVob1RW_1590559109.jpg?imageView2/1/w/300/h/300/q/75","intro":"2022届美高中控卫","name":"Skyy Clark","playerid":25,"symbol":"https://m.muho.tv/bXVob1RW_1590559477.jpg","symbolpic":"https://m.muho.tv/bXVob1RW_1590561137.png","theme":"#97999b"},{"avatar":"https://m.muho.tv/bXVob1RW_1570429502.jpg?imageView2/1/w/300/h/300/q/75","intro":"NBA训练师","name":"克里斯·约翰逊","playerid":17,"symbol":"https://m.muho.tv/bXVob1RW_1573117396.jpg","symbolpic":"https://m.muho.tv/bXVob1RW_1570441723.png","theme":"#02387E"},{"avatar":"https://m.muho.tv/bXVob1RW_1566198242.jpg?imageView2/1/w/300/h/300/q/75","intro":"Rob","name":" Rob","playerid":6,"symbol":"https://m.muho.tv/bXVob1RW_1573117443.jpg","symbolpic":"https://m.muho.tv/90764_1558080825157_207x100.png","theme":"#b4352e"},{"avatar":"https://m.muho.tv/bXVob1RW_1584419476.jpg?imageView2/1/w/300/h/300/q/75","intro":"菲利宾球员","name":"Kai Sotto","playerid":22,"symbol":"https://m.muho.tv/bXVob1RW_1584957948.jpg","symbolpic":"https://m.muho.tv/bXVob1RW_1583393159.png","theme":"#400000"},{"avatar":"https://m.muho.tv/bXVob1RW_1566198199.jpg?imageView2/1/w/300/h/300/q/75","intro":"76人传奇球星","name":"艾弗森","playerid":2,"symbol":"https://m.muho.tv/bXVob1RW_1573117411.jpg","symbolpic":"https://m.muho.tv/club_1530858601zsp.png","theme":"#DB3128"},{"avatar":"https://m.muho.tv/bXVob1RW_1566198179.jpg?imageView2/1/w/300/h/300/q/75","intro":"Nick Young","name":"尼克杨","playerid":1,"symbol":"https://m.muho.tv/bXVob1RW_1573117364.jpg","symbolpic":"https://m.muho.tv/club_1530858593zsp.png","theme":"#F8A70B"},{"avatar":"https://m.muho.tv/bXVob1RW_1566198254.jpg?imageView2/1/w/300/h/300/q/75","intro":"Phil Handy","name":"菲尔-汉迪","playerid":15,"symbol":"https://m.muho.tv/bXVob1RW_1573117426.jpg","symbolpic":"https://m.muho.tv/90764_1564468659447_200x66.png","theme":"#521D85"},{"avatar":"https://m.muho.tv/bXVob1RW_1581318047.png?imageView2/1/w/300/h/300/q/75","intro":"幕后独家","name":"幕后独家","playerid":20,"symbol":"https://m.muho.tv/bXVob1RW_1581318371.png","symbolpic":"https://m.muho.tv/bXVob1RW_1581318312.png","theme":"#02387E"},{"avatar":"https://m.muho.tv/bXVob1RW_1566198229.jpg?imageView2/1/w/300/h/300/q/75","intro":" 斯潘塞 丁威迪","name":" 斯潘塞 丁威迪","playerid":5,"symbol":"https://m.muho.tv/bXVob1RW_1573117475.jpg","symbolpic":"https://m.muho.tv/90764_1561956703745_661x216.png","theme":"#AF352E\r\n"},{"avatar":"https://m.muho.tv/bXVob1RW_1584690039.jpg?imageView2/1/w/300/h/300/q/75","intro":"CloseUp360","name":"CloseUp360","playerid":21,"symbol":"https://m.muho.tv/bXVob1RW_1584620224.jpg","symbolpic":"https://m.muho.tv/bXVob1RW_1584690054.jpg","theme":"#c44327"},{"avatar":"https://m.muho.tv/bXVob1RW_1566198277.jpg?imageView2/1/w/300/h/300/q/75","intro":"塞拉峡谷中学","name":"塞拉峡谷中学","playerid":16,"symbol":"https://m.muho.tv/bXVob1RW_1573117460.jpg","symbolpic":"https://m.muho.tv/90764_1565606115440_210x67.png","theme":"#02387E"},{"avatar":"https://m.muho.tv/bXVob1RW_1574313258.jpeg?imageView2/1/w/300/h/300/q/75","intro":"Jaylen Hands","name":"Jaylen Hands","playerid":18,"symbol":"https://m.muho.tv/bXVob1RW_1574677643.jpg","symbolpic":"https://m.muho.tv/bXVob1RW_1574316674.png","theme":"#02387E"}]
     * message : SUCCESS
     * stateCode : 200
     */

    private String message;
    private int stateCode;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * avatar : https://m.muho.tv/bXVob1RW_1591183947.jpg?imageView2/1/w/300/h/300/q/75
         * intro : 娱乐性丰富的篮球训练师
         * name : AJ训练师
         * playerid : 26
         * symbol : https://m.muho.tv/bXVob1RW_1591184227.png
         * symbolpic : https://m.muho.tv/bXVob1RW_1591184163.png
         * theme : #9d9eb4
         */

        private String avatar;
        private String intro;
        private String name;
        private int playerid;
        private String symbol;
        private String symbolpic;
        private String theme;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPlayerid() {
            return playerid;
        }

        public void setPlayerid(int playerid) {
            this.playerid = playerid;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbolpic() {
            return symbolpic;
        }

        public void setSymbolpic(String symbolpic) {
            this.symbolpic = symbolpic;
        }

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "avatar='" + avatar + '\'' +
                    ", intro='" + intro + '\'' +
                    ", name='" + name + '\'' +
                    ", playerid=" + playerid +
                    ", symbol='" + symbol + '\'' +
                    ", symbolpic='" + symbolpic + '\'' +
                    ", theme='" + theme + '\'' +
                    '}';
        }
    }
}
