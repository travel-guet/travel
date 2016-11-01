package com.example.travel.travel.model;

import java.sql.Date;

/**
 * Created by yue on 2016/11/1.
 */

public class Ticket {
    private String ticketName;

    //private Company company;

    private Double rackRate;

    private Double peerPrice;

    private Double touristPrice;

    private String openingHours;

    private Date dateStart;

    private Date dateEnd;

    private String bookingNotes;


    private String description;

    private String address;//"景点地址"

    //private BoatSalesStateEnum saleState;//销售状态

    private String delState = "1";//删除状态

    private Double vipPriceA;//总代理价

    private Double vipPriceB;//VIP会员价

    private Double vipPriceC;//普通会员价

    //private Company comp;//景区

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public Double getRackRate() {
        return rackRate;
    }

    public void setRackRate(Double rackRate) {
        this.rackRate = rackRate;
    }

    public Double getPeerPrice() {
        return peerPrice;
    }

    public void setPeerPrice(Double peerPrice) {
        this.peerPrice = peerPrice;
    }

    public Double getTouristPrice() {
        return touristPrice;
    }

    public void setTouristPrice(Double touristPrice) {
        this.touristPrice = touristPrice;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getBookingNotes() {
        return bookingNotes;
    }

    public void setBookingNotes(String bookingNotes) {
        this.bookingNotes = bookingNotes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getVipPriceA() {
        return vipPriceA;
    }

    public void setVipPriceA(Double vipPriceA) {
        this.vipPriceA = vipPriceA;
    }

    public String getDelState() {
        return delState;
    }

    public void setDelState(String delState) {
        this.delState = delState;
    }

    public Double getVipPriceB() {
        return vipPriceB;
    }

    public void setVipPriceB(Double vipPriceB) {
        this.vipPriceB = vipPriceB;
    }

    public Double getVipPriceC() {
        return vipPriceC;
    }

    public void setVipPriceC(Double vipPriceC) {
        this.vipPriceC = vipPriceC;
    }
    public Ticket(){

    }

    public Ticket(String ticketName, Double rackRate, Double peerPrice,
                  Double touristPrice, String openingHours, Date dateStart,
                  Date dateEnd, String bookingNotes, String description, String address,
                  String delState, Double vipPriceA, Double vipPriceB, Double vipPriceC) {
        this.ticketName = ticketName;
        this.rackRate = rackRate;
        this.peerPrice = peerPrice;
        this.touristPrice = touristPrice;
        this.openingHours = openingHours;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.bookingNotes = bookingNotes;
        this.description = description;
        this.address = address;
        this.delState = delState;
        this.vipPriceA = vipPriceA;
        this.vipPriceB = vipPriceB;
        this.vipPriceC = vipPriceC;
    }
}
