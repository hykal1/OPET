package com.example.projectuas.admin;

public class OrderData {

    int Id;


    String services;
    int prices;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }


    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }
}
