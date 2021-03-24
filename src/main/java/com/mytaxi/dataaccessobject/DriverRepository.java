package com.mytaxi.dataaccessobject;

import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.GeoCoordinate;
import com.mytaxi.domainvalue.OnlineStatus;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Database Access Object for driver table.
 * <p/>
 */

public interface DriverRepository extends CrudRepository<DriverDO, Long> {

    List<DriverDO> findByOnlineStatus(OnlineStatus onlineStatus);

    @Query("SELECT new com.mytaxi.datatransferobject.DriverDTO(d.id, d.username, " +
            "d.password, d.coordinate, d.deleted, d.onlineStatus) " +
            "FROM DriverDO d " +
            "LEFT JOIN CarDO c ON d.id = c.selectedDriverId " +
            "WHERE d.username = :username " +
            "OR d.onlineStatus = :onlineStatus OR c.licensePlate = :licensePlate OR c.seatCount = :seatCount " +
            "OR c.rating = :rating OR c.engineType = :engineType OR c.manufacturer = :manufacturer")
    List<DriverDO> fetchDriverCarDataLeftJoin(@Param("username") String username, @Param("onlineStatus") OnlineStatus onlineStatus, @Param("licensePlate") String licensePlate, @Param("seatCount") int seatCount, @Param("rating") float rating, @Param("engineType") String engineType, @Param("manufacturer") String manufacturer);
}
