package com.example.projectuas.feature.toys;

public class Toys {
    private String name;
    private String desc;
    private int imageResourceId;
    private String linkTokped;
    private String linkShopee;

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getDesc() {
        return desc;
    }
    public String getLinkTokped() {
        return linkTokped;
    }

    public String getLinkShopee() {
        return linkShopee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public void setLinkTokped(String linkTokped) {
        this.linkTokped = linkTokped;
    }

    public void setLinkShopee(String linkShopee) {
        this.linkShopee = linkShopee;
    }

}
