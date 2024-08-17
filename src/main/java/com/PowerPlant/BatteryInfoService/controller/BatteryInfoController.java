package com.PowerPlant.BatteryInfoService.controller;

import com.PowerPlant.BatteryInfoService.dto.BatteryInfoDTO;
import com.PowerPlant.BatteryInfoService.model.Battery;
import com.PowerPlant.BatteryInfoService.repository.BatteryInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BatteryInfoController {

    @Autowired
    private BatteryInfoRepository batteryInfoRepository;

    @PostMapping("/addbatteryinfo")
    public Battery saveBatteryInfo(@RequestBody Battery battery) {

        return batteryInfoRepository.save(battery);
    }

    @GetMapping("/statisticsOfBattery")
    public BatteryInfoDTO getAverageWatCapacity(@RequestParam int postCodeStart, @RequestParam int postCodeEnd){

        Double averageWatCapacity = batteryInfoRepository.sumWatCapacity(postCodeStart, postCodeEnd);
        int sumOfWatCapacity = batteryInfoRepository.avgWatCapacity(postCodeStart, postCodeEnd);
        return new BatteryInfoDTO(averageWatCapacity, sumOfWatCapacity);
    }
}
