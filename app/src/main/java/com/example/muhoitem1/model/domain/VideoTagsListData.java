package com.example.muhoitem1.model.domain;

public class VideoTagsListData {
    private String title;
    private int type;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
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
                "title='" + title + '\'' +
                ", type=" + type +
                '}';
    }
}
