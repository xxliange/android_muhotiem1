package com.example.muhoitem1.model.domain.VideoData;

import java.util.List;

public class AlbumInfoCachData {

    /**
     * SinPrice : 2.99
     * albumName : 克里斯.约翰逊
     * coachIntro : 美国篮球训练师
     * coachThumb : https://m.muho.tv/bXVob1RW_1586835587.jpg
     * coid : 3
     * cons : 6
     * id : 18
     * info : [{"content":"利用双球，双手同时间运球去提升自己的运球基本功!","title":"课程概要:"},{"content":"克里斯.约翰逊（Chris Johnson），NBA球星御用训练师，层训练过韦德，保罗，维金斯，JR史密斯等众多球星","title":"教练简介:"},{"content":"1,教学专辑视频可专辑购买,也购买教学专区vip所有付费教学都可以观看(详情请联系客服) \n 2,如在使用，购买中遇到任何问题欢迎在小程序/公众号中与我们取得联系","title":"购买须知:"}]
     * ispay : 1
     * name : 克里斯·约翰逊 6天双球运球系列教学
     * price : 15.99
     * priceX : 9.99
     * subjectintro : [{"content":"利用双球，双手同时间运球去提升自己的运球基本功!","type":"text"}]
     * subscrib : 134
     * thumb : https://m.muho.tv/bXVob1RW_1586835587.jpg?imageView2/1/w/300/h/300/format/jpg/interlace/1/q/75
     * video : https://m.muho.tv/bXVob1RW_1592453385.MP4
     */

    private double SinPrice;
    private String albumName;
    private String coachIntro;
    private String coachThumb;
    private int coid;
    private int cons;
    private int id;
    private int ispay;
    private String name;
    private double price;
    private double priceX;
    private int subscrib;
    private String thumb;
    private String video;
    private List<InfoBean> info;
    private List<SubjectintroBean> subjectintro;

    public double getSinPrice() {
        return SinPrice;
    }

    public void setSinPrice(double SinPrice) {
        this.SinPrice = SinPrice;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getCoachIntro() {
        return coachIntro;
    }

    public void setCoachIntro(String coachIntro) {
        this.coachIntro = coachIntro;
    }

    public String getCoachThumb() {
        return coachThumb;
    }

    public void setCoachThumb(String coachThumb) {
        this.coachThumb = coachThumb;
    }

    public int getCoid() {
        return coid;
    }

    public void setCoid(int coid) {
        this.coid = coid;
    }

    public int getCons() {
        return cons;
    }

    public void setCons(int cons) {
        this.cons = cons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIspay() {
        return ispay;
    }

    public void setIspay(int ispay) {
        this.ispay = ispay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceX() {
        return priceX;
    }

    public void setPriceX(double priceX) {
        this.priceX = priceX;
    }

    public int getSubscrib() {
        return subscrib;
    }

    public void setSubscrib(int subscrib) {
        this.subscrib = subscrib;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public List<InfoBean> getInfo() {
        return info;
    }

    public void setInfo(List<InfoBean> info) {
        this.info = info;
    }

    public List<SubjectintroBean> getSubjectintro() {
        return subjectintro;
    }

    public void setSubjectintro(List<SubjectintroBean> subjectintro) {
        this.subjectintro = subjectintro;
    }

    public static class InfoBean {
        /**
         * content : 利用双球，双手同时间运球去提升自己的运球基本功!
         * title : 课程概要:
         */

        private String content;
        private String title;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class SubjectintroBean {
        /**
         * content : 利用双球，双手同时间运球去提升自己的运球基本功!
         * type : text
         */

        private String content;
        private String type;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    @Override
    public String toString() {
        return "AlbumInfoCachData{" +
                "SinPrice=" + SinPrice +
                ", albumName='" + albumName + '\'' +
                ", coachIntro='" + coachIntro + '\'' +
                ", coachThumb='" + coachThumb + '\'' +
                ", coid=" + coid +
                ", cons=" + cons +
                ", id=" + id +
                ", ispay=" + ispay +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", priceX=" + priceX +
                ", subscrib=" + subscrib +
                ", thumb='" + thumb + '\'' +
                ", video='" + video + '\'' +
                ", info=" + info +
                ", subjectintro=" + subjectintro +
                '}';
    }
}
