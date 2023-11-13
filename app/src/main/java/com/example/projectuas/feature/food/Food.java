package com.example.projectuas.feature.food;

public class Food {
    private String name;
    private String desc;
    private int imageResourceId;
    private String linkTokped;
    private String linkShopee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getLinkTokped() {
        return linkTokped;
    }

    public void setLinkTokped(String linkTokped) {
        this.linkTokped = linkTokped;
    }

    public String getLinkShopee() {
        return linkShopee;
    }

    public void setLinkShopee(String linkShopee) {
        this.linkShopee = linkShopee;
    }
}
