package com.example.muhoitem1.model.domain.VideoData;

public class TeachVideoData {

    /**
     * cid : 686
     * comment : 0
     * name : 第三十季
     * share_url : https://www.muho.tv/video/teachVideo?c=686&s=91&t=1
     * sid : 91
     * tags : 幕后教学,运球
     * thumb : https://m.muho.tv/0_1527832476.jpg
     * thumb1 : https://m.muho.tv/0_1527832476.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100
     * title : 托马斯.斯科特教练基本功训练第一课：炸球训练！按照水平的不同，大家务必每次练习直到手酸为止，炸球训练特别有助于第一步突破！
     * type : 1
     * video : https://m.muho.tv/128156_1527832472.mp4
     * view : 3421
     */

    private int cid;
    private int comment;
    private String name;
    private String share_url;
    private int sid;
    private String tags;
    private String thumb;
    private String thumb1;
    private String title;
    private int type;
    private String video;
    private int view;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getThumb1() {
        return thumb1;
    }

    public void setThumb1(String thumb1) {
        this.thumb1 = thumb1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return "TeachVideoData{" +
                "cid=" + cid +
                ", comment=" + comment +
                ", name='" + name + '\'' +
                ", share_url='" + share_url + '\'' +
                ", sid=" + sid +
                ", tags='" + tags + '\'' +
                ", thumb='" + thumb + '\'' +
                ", thumb1='" + thumb1 + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", video='" + video + '\'' +
                ", view=" + view +
                '}';
    }
}
