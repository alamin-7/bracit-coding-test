package com.PowerPlant.BatteryInfoService.model;

import jakarta.persistence.*;

@Entity
@Table(name = "battry")
public class Battery {

    // battery ID will be use as unique id in database table
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long batteryid;
    private String name;
    private int postcode;
    private int watcapacity;

    public Battery(Long batteryid, String name, int postcode, int watcapacity) {
        this.batteryid = batteryid;
        this.name = name;
        this.postcode = postcode;
        this.watcapacity = watcapacity;
    }

    public Long getBatteryid() {
        return batteryid;
    }

    public void setBatteryid(Long batteryid) {
        this.batteryid = batteryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public int getWatcapacity() {
        return watcapacity;
    }

    public void setWatcapacity(int watcapacity) {
        this.watcapacity = watcapacity;
    }
}
