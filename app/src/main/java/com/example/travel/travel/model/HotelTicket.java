package com.example.travel.travel.model;

/**
 * Created by yue on 2016/11/1.
 */

public class HotelTicket {
    private String ordersNum;
    private String HotelName;
    private String HotelType;
    private String prices;

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
