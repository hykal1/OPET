package com.example.projectuas.navbar;

public class DataHistoryGroom {
    int Id_user;
    int Id_groom;
    String nama;
    String desc;
    int price;
    String status;

    public int getId_user() {
        return Id_user;
    }

    public void setId_user(int id_user) {
        Id_user = id_user;
    }

    public int getId_groom() {
        return Id_groom;
    }

    public void setId_groom(int id_groom) {
        Id_groom = id_groom;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
