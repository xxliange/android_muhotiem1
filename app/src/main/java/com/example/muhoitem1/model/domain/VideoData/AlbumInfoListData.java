package com.example.muhoitem1.model.domain.VideoData;

public class AlbumInfoListData {
    /**
     * cid : 313
     * collection : 4
     * isfree : 2
     * name : 克里斯·约翰逊 6天双球运球系列教学
     * share_url : https://www.muho.tv/album/video/?c=313&s=18
     * status : 1
     * tags : 克里斯·约翰逊
     * thumb : https://m.muho.tv/bXVob1RW_1592453662.jpg
     * title : 试看 第一集 高中低双手炸球训练
     * video : https://m.muho.tv/bXVob1RW_1592453662.MP4
     * view : 465
     */

    private int cid;
    private int collection;
    private int isfree;
    private String name;
    private String share_url;
    private int status;
    private String tags;
    private String thumb;
    private String title;
    private String video;
    private int view;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getCollection() {
        return collection;
    }

    public void setCollection(int collection) {
        this.collection = collection;
    }

    public int getIsfree() {
        return isfree;
    }

    public void setIsfree(int isfree) {
        this.isfree = isfree;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return "AlbumInfoListData{" +
                "cid=" + cid +
                ", collection=" + collection +
                ", isfree=" + isfree +
                ", name='" + name + '\'' +
                ", share_url='" + share_url + '\'' +
                ", status=" + status +
                ", tags='" + tags + '\'' +
                ", thumb='" + thumb + '\'' +
                ", title='" + title + '\'' +
                ", video='" + video + '\'' +
                ", view=" + view +
                '}';
    }
}
