package com.example.travel.travel.model;

/**
 * Created by yue on 2016/11/1.
 */

public class HotelTicket {
    private String ordersNum=null;
    private String HotelName=null;
    private String HotelType=null;
    private String prices=null;
    private String hotelLv=null;
    private String compName=null;
    private String HotelId=null;
    private String description=null;
    private String comAddr=null;

    public String getHotelLv() {
        return hotelLv;
    }

    public void setHotelLv(String hotelLv) {
        this.hotelLv = hotelLv;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getHotelId() {
        return HotelId;
    }

    public void setHotelId(String hotelId) {
        HotelId = hotelId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComAddr() {
        return comAddr;
    }

    public void setComAddr(String comAddr) {
        this.comAddr = comAddr;
    }



    public String getOrdersNum() {
        return ordersNum;
    }

    public void setOrdersNum(String ordersNum) {
        this.ordersNum = ordersNum;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    public String getHotelType() {
        return HotelType;
    }

    public void setHotelType(String hotelType) {
        HotelType = hotelType;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }



    public HotelTicket(){

    }

    public HotelTicket(String ordersNum, String hotelName,
                       String hotelType, String prices) {
        this.ordersNum = ordersNum;
        HotelName = hotelName;
        HotelType = hotelType;
        this.prices = prices;
    }
}
