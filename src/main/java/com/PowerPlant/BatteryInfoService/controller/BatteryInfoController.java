package com.PowerPlant.BatteryInfoService.controller;

import com.PowerPlant.BatteryInfoService.model.Battery;
import com.PowerPlant.BatteryInfoService.repository.BatteryInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BatteryInfoController {

    @Autowired
    private BatteryInfoRepository batteryInfoRepository;

    @PostMapping("/addbatteryinfo")
    public Battery saveBatteryInfo(@RequestBody Battery battery) {

        return batteryInfoRepository.save(battery);
    }

    @GetMapping("/getbatteryInfo")
    public List<Battery> getBatteryInfo(@RequestParam int postcodeStart, @RequestParam int postcodeEnd){

        return batteryInfoRepository.findRecordsInRange(postcodeStart,postcodeEnd);
    }

}
