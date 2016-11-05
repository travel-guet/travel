package com.example.travel.travel.model;

/**
 * Created by feng on 2016/10/31.
 */
public class Hotel  {

    /**
     * 酒店图片资源ID
     */
    private int resourceId;
    /**
     * 酒店名称
     */
    private String hotelName;
    /**
     * 酒店评论数
     */
    private int commentNums;
    /**
     * 酒店地址
     */
    private String hotelAddress;
    /**
     * 酒店一晚最低起价
     */
    private int hotelMinStartPrice;

    public Hotel(int resourceId, String hotelName, int commentNums, String hotelAddress, int hotelMinStartPrice) {
        this.resourceId = resourceId;
        this.hotelName = hotelName;
        this.commentNums = commentNums;
        this.hotelAddress = hotelAddress;
        this.hotelMinStartPrice = hotelMinStartPrice;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }


    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }


    public int getHotelMinStartPrice() {
        return hotelMinStartPrice;
    }

    public void setHotelMinStartPrice(int hotelMinStartPrice) {
        this.hotelMinStartPrice = hotelMinStartPrice;
    }


    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getCommentNums() {
        return commentNums;
    }

    public void setCommentNums(int commentNums) {
        this.commentNums = commentNums;
    }
}