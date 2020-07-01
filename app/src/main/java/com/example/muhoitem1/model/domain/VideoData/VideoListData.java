package com.example.muhoitem1.model.domain.VideoData;

public class VideoListData {

    /**
     * cid : 848
     * name : 私人训练
     * sid : 81
     * thumb : https://m.muho.tv/bXVob1RW_1570593694.jpg
     * title : 西蒙斯，维金斯等NBA球员的野球训练
     * type : 1
     */

    private int cid;
    private String name;
    private int sid;
    private String thumb;
    private String title;
    private int type;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
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

    @Override
    public String toString() {
        return "VideoListData{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", sid=" + sid +
                ", thumb='" + thumb + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                '}';
    }
}
