package com.app.dbperform.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public long id;
    public String dateTime;
    public int siteName;
    public int posaContinent;
    public int userLocationCountry;
    public int userLocationRegion;
    public int userLocationCity;
    public double origDestinationDistance;
    public int userId;
    public short isMobile;
    public int isPackage;
    public int channel;
    public String srchCi;
    public String srchCo;
    public int srchAdultsCnt;
    public int srchChildrenCnt;
    public int srchRmCnt;
    public int srchDestinationId;
    public int srchDestinationTypeId;
    public int hotelContinent;
    public int hotelCountry;
    public int hotelMarket;
    public short isBooking;
    public long cnt;
    public int hotelCluster;

    public Train() {
    }

    public Train(String dateTime, int siteName, int posaContinent, int userLocationCountry, int userLocationRegion, int userLocationCity, double origDestinationDistance, int userId, short isMobile, int isPackage, int channel, String srchCi, String srchCo, int srchAdultsCnt, int srchChildrenCnt, int srchRmCnt, int srchDestinationId, int srchDestinationTypeId, int hotelContinent, int hotelCountry, int hotelMarket, short isBooking, long cnt, int hotelCluster) {
        this.dateTime = dateTime;
        this.siteName = siteName;
        this.posaContinent = posaContinent;
        this.userLocationCountry = userLocationCountry;
        this.userLocationRegion = userLocationRegion;
        this.userLocationCity = userLocationCity;
        this.origDestinationDistance = origDestinationDistance;
        this.userId = userId;
        this.isMobile = isMobile;
        this.isPackage = isPackage;
        this.channel = channel;
        this.srchCi = srchCi;
        this.srchCo = srchCo;
        this.srchAdultsCnt = srchAdultsCnt;
        this.srchChildrenCnt = srchChildrenCnt;
        this.srchRmCnt = srchRmCnt;
        this.srchDestinationId = srchDestinationId;
        this.srchDestinationTypeId = srchDestinationTypeId;
        this.hotelContinent = hotelContinent;
        this.hotelCountry = hotelCountry;
        this.hotelMarket = hotelMarket;
        this.isBooking = isBooking;
        this.cnt = cnt;
        this.hotelCluster = hotelCluster;
    }
}