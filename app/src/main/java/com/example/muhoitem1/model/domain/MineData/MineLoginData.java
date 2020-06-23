package com.example.muhoitem1.model.domain.MineData;

public class MineLoginData {

    /**
     * data : {"avatar":"https://wx.qlogo.cn/mmopen/vi_32/LMCia5mKG5zmJYZrfjkiaibw40YzaoBWE41b2wiahCqIibYAyldz6iaZdYiaXSN6F22KM7VxvfO9Pnkfk2uAiclmnKibBeg/132","mid":141465,"mobile":"18670786540","nickname":"XIAO小恋歌","playerVip":false,"player_time":"","subjectVip":true,"subject_time":"2020-12-18","token":"eyJtaWQiOiAxNDE0NjV9","type":3}
     * message : SUCCESS
     * stateCode : 200
     */

    private DataBean data;
    private String message;
    private int stateCode;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

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

    public static class DataBean {
        /**
         * avatar : https://wx.qlogo.cn/mmopen/vi_32/LMCia5mKG5zmJYZrfjkiaibw40YzaoBWE41b2wiahCqIibYAyldz6iaZdYiaXSN6F22KM7VxvfO9Pnkfk2uAiclmnKibBeg/132
         * mid : 141465
         * mobile : 18670786540
         * nickname : XIAO小恋歌
         * playerVip : false
         * player_time :
         * subjectVip : true
         * subject_time : 2020-12-18
         * token : eyJtaWQiOiAxNDE0NjV9
         * type : 3
         */

        private String avatar;
        private int mid;
        private String mobile;
        private String nickname;
        private boolean playerVip;
        private String player_time;
        private boolean subjectVip;
        private String subject_time;
        private String token;
        private int type;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public boolean isPlayerVip() {
            return playerVip;
        }

        public void setPlayerVip(boolean playerVip) {
            this.playerVip = playerVip;
        }

        public String getPlayer_time() {
            return player_time;
        }

        public void setPlayer_time(String player_time) {
            this.player_time = player_time;
        }

        public boolean isSubjectVip() {
            return subjectVip;
        }

        public void setSubjectVip(boolean subjectVip) {
            this.subjectVip = subjectVip;
        }

        public String getSubject_time() {
            return subject_time;
        }

        public void setSubject_time(String subject_time) {
            this.subject_time = subject_time;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "avatar='" + avatar + '\'' +
                    ", mid=" + mid +
                    ", mobile='" + mobile + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", playerVip=" + playerVip +
                    ", player_time='" + player_time + '\'' +
                    ", subjectVip=" + subjectVip +
                    ", subject_time='" + subject_time + '\'' +
                    ", token='" + token + '\'' +
                    ", type=" + type +
                    '}';
        }
    }
}
