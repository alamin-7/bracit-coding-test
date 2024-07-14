package com.PowerPlant.BatteryInfoService.repository;

import com.PowerPlant.BatteryInfoService.model.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BatteryInfoRepository extends JpaRepository<Battery, Long> {


    @Query("SELECT BatteryStatistics(b.name, SUM(b.watcapacity), AVG(b.watcapacity)) " +
            "FROM Battery b WHERE b.postcode BETWEEN :postcodeStart AND :postcodeEnd " +
            "GROUP BY b.name ORDER BY b.name ASC")

    List<Battery> findRecordsInRange(@Param("postcodeStart") int postcodeStart, @Param("postcodeEnd") int postcodeEnd);
}
