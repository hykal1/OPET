package com.example.projectuas.feature.Grooming;

import android.os.Parcel;
import android.os.Parcelable;

public class Grooming implements Parcelable {

    private String name_groom;
    private String desc_groom;
    private int price_groom;
    private String detail_groom;
    private int id_groom;

    public String getName_groom() {
        return name_groom;
    }

    public void setName_groom(String name_groom) {
        this.name_groom = name_groom;
    }

    public String getDesc_groom() {
        return desc_groom;
    }

    public void setDesc_groom(String desc_groom) {
        this.desc_groom = desc_groom;
    }

    public int getPrice_groom() {
        return price_groom;
    }

    public void setPrice_groom(int price_groom) {
        this.price_groom = price_groom;
    }

    public String getDetail_groom() {
        return detail_groom;
    }

    public void setDetail_groom(String detail_groom) {
        this.detail_groom = detail_groom;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name_groom);
        dest.writeString(this.desc_groom);
        dest.writeInt(this.price_groom);
        dest.writeString(this.detail_groom);
        dest.writeInt(this.id_groom);
    }

    public int getId_groom() {
        return id_groom;
    }

    public void setId_groom(int id_groom) {
        this.id_groom = id_groom;
    }

    public void readFromParcel(Parcel source) {
        this.name_groom = source.readString();
        this.desc_groom = source.readString();
        this.price_groom = source.readInt();
        this.detail_groom = source.readString();
        this.id_groom = source.readInt();
    }

    public Grooming() {
    }

    protected Grooming(Parcel in) {
        this.name_groom = in.readString();
        this.desc_groom = in.readString();
        this.price_groom = in.readInt();
        this.detail_groom = in.readString();
        this.id_groom = in.readInt();
    }

    public static final Parcelable.Creator<Grooming> CREATOR = new Parcelable.Creator<Grooming>() {
        @Override
        public Grooming createFromParcel(Parcel source) {
            return new Grooming(source);
        }

        @Override
        public Grooming[] newArray(int size) {
            return new Grooming[size];
        }
    };
}
