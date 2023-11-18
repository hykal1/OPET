package com.example.projectuas.feature.Veterinary;

import android.os.Parcel;
import android.os.Parcelable;

public class Veterinary implements Parcelable {

    private String name_vet;
    private String desc_vet;
    private int id_vet;
    private int price_vet;

    public int getId_vet() {
        return id_vet;
    }

    public void setId_vet(int id_vet) {
        this.id_vet = id_vet;
    }

    private int photo;
    private int photo_land;
    private String detail_vet;

    public String getName_vet() {
        return name_vet;
    }

    public void setName_vet(String name_vet) {
        this.name_vet = name_vet;
    }

    public String getDesc_vet() {
        return desc_vet;
    }

    public void setDesc_vet(String desc_vet) {
        this.desc_vet = desc_vet;
    }

    public int getPrice_vet() {
        return price_vet;
    }

    public void setPrice_vet(int price_vet) {
        this.price_vet = price_vet;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getPhoto_land() {
        return photo_land;
    }

    public void setPhoto_land(int photo_land) {
        this.photo_land = photo_land;
    }

    public String getDetail_vet() {
        return detail_vet;
    }

    public void setDetail_vet(String detail_vet) {
        this.detail_vet = detail_vet;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id_vet);
        dest.writeString(this.name_vet);
        dest.writeString(this.desc_vet);
        dest.writeInt(this.price_vet);
        dest.writeInt(this.photo);
        dest.writeInt(this.photo_land);
        dest.writeString(this.detail_vet);
    }

    public void readFromParcel(Parcel source) {
        this.id_vet = source.readInt();
        this.name_vet = source.readString();
        this.desc_vet = source.readString();
        this.price_vet = source.readInt();
        this.photo = source.readInt();
        this.photo_land = source.readInt();
        this.detail_vet = source.readString();
    }

    public Veterinary() {
    }

    protected Veterinary(Parcel in) {
        this.id_vet = in.readInt();
        this.name_vet = in.readString();
        this.desc_vet = in.readString();
        this.price_vet = in.readInt();
        this.photo = in.readInt();
        this.photo_land = in.readInt();
        this.detail_vet = in.readString();
    }

    public static final Parcelable.Creator<Veterinary> CREATOR = new Parcelable.Creator<Veterinary>() {
        @Override
        public Veterinary createFromParcel(Parcel source) {
            return new Veterinary(source);
        }

        @Override
        public Veterinary[] newArray(int size) {
            return new Veterinary[size];
        }
    };
}
