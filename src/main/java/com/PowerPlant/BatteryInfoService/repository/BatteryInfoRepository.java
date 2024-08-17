package com.PowerPlant.BatteryInfoService.repository;

import com.PowerPlant.BatteryInfoService.dto.BatteryInfoDTO;
import com.PowerPlant.BatteryInfoService.model.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BatteryInfoRepository extends JpaRepository<Battery, Long> {


/*    @Query("SELECT Battery(b.name, SUM(b.watcapacity), AVG(b.watcapacity)) " +
            "FROM Battery b WHERE b.postcode BETWEEN :postcodeStart AND :postcodeEnd " +
            "GROUP BY b.name ORDER BY b.name ASC")*/

    /*@Query("select b sum(b.watcapacity) from Battery b")
    Optional<Battery> findRecordsInRange(@Param("postcodeStart") int postcodeStart, @Param("postcodeEnd") int postcodeEnd);
*/
    @Query("select sum(b.watcapacity) from Battery b " +
           "where b.postcode between :postCodeStart and :postCodeEnd")
    Double sumWatCapacity(@Param("postCodeStart") int postCodeStart, @Param("postCodeEnd") int postCodeEnd);

    @Query("select avg(b.watcapacity) from Battery b " +
            "where b.postcode between :postCodeStart and :postCodeEnd")
    int avgWatCapacity(@Param("postCodeStart") int postCodeStart, @Param("postCodeEnd") int postCodeEnd);

    @Query("select b from Battery b")
    List<Battery> getAllBatteryInfo();
}
