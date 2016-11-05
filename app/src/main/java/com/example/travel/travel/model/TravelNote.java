package com.example.travel.travel.model;

/**
 * Created by feng on 2016/10/31.
 * 游记实体类
 */

public class TravelNote {

    /**游记图片ID*/
    private int imageResourceId;
    /**游记主题*/
    private String title;
    /**观看过游记的人数*/
    private int people;
    /**发布游记的日期*/
    private String publishDate;


    public TravelNote(int imageResourceId, String title, int people, String publishDate) {
        this.imageResourceId = imageResourceId;
        this.title = title;
        this.people = people;
        this.publishDate = publishDate;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
