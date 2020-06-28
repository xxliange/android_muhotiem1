package com.example.muhoitem1.model.domain.VideoData;

public class TeachVideoRandomData {

    /**
     * count : 21
     * icon : https://m.muho.tv/skill@icon_06.png
     * name : 胯下运球
     * sid : 56
     * thumb : https://m.muho.tv/bXVob1RW_1570607451.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100
     * type : 4
     */

    private int count;
    private String icon;
    private String name;
    private int sid;
    private String thumb;
    private int type;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TeachVideoRandomData{" +
                "count=" + count +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", sid=" + sid +
                ", thumb='" + thumb + '\'' +
                ", type=" + type +
                '}';
    }
}
