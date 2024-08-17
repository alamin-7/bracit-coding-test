package com.PowerPlant.BatteryInfoService.dto;

import lombok.Data;

@Data
public class BatteryInfoDTO {

    private Double watcapacity;
    private int sumOfWatCapacity;

    public BatteryInfoDTO(){}

    public BatteryInfoDTO( Double watcapacity, int sumOfWatCapacity) {

        this.watcapacity = watcapacity;
        this.sumOfWatCapacity = sumOfWatCapacity;
    }
}

