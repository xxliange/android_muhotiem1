package com.example.muhoitem1.model.domain.VipStarData;

public class VipStarListData {

    /**
     * avatar : https://m.muho.tv/bXVob1RW_1584419476.jpg?imageView2/1/w/300/h/300/q/75
     * intro : 菲利宾球员
     * name : Kai Sotto
     * playerid : 22
     * symbol : https://m.muho.tv/bXVob1RW_1584957948.jpg
     * symbolpic : https://m.muho.tv/bXVob1RW_1583393159.png
     * theme : #400000
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
        return "VipStarListData{" +
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
