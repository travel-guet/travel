package com.example.travel.travel.model;

/**
 * Created by yue on 2016/11/1.
 */

public class BoatTicket {
    private String name;
    private String ordersNum;
    private String boatType;
    private String sailingTime;
    private String riversType;
    private String company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrdersNum() {
        return ordersNum;
    }

    public void setOrdersNum(String ordersNum) {
        this.ordersNum = ordersNum;
    }

    public String getBoatType() {
        return boatType;
    }

    public void setBoatType(String boatType) {
        this.boatType = boatType;
    }

    public String getSailingTime() {
        return sailingTime;
    }

    public void setSailingTime(String sailingTime) {
        this.sailingTime = sailingTime;
    }

    public String getRiversType() {
        return riversType;
    }

    public void setRiversType(String riversType) {
        this.riversType = riversType;
    }
    public BoatTicket(){

    }

    public BoatTicket(String name, String ordersNum, String boatType,
                      String sailingTime, String riversType, String company) {
        this.name = name;
        this.ordersNum = ordersNum;
        this.boatType = boatType;
        this.sailingTime = sailingTime;
        this.riversType = riversType;
        this.company = company;
    }

}
