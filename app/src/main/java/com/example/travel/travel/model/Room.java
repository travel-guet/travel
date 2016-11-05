package com.example.travel.travel.model;

/**
 * Created by feng on 2016/11/4.
 */

public class Room {

    /**图片资源ID*/
    private int imageResourceId;
    /**房间类型名称*/
    private String roomTypeName;
    /**房间的面积*/
    private int area;
    /**房间的最低起价*/
    private int startValue;

    public Room(int imageResourceId, String roomTypeName, int area, int startValue) {
        this.imageResourceId = imageResourceId;
        this.roomTypeName = roomTypeName;
        this.area = area;
        this.startValue = startValue;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getStartValue() {
        return startValue;
    }

    public void setStartValue(int startValue) {
        this.startValue = startValue;
    }
}
