package com.mytaxi.dataaccessobject;

import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.GeoCoordinate;
import com.mytaxi.domainvalue.OnlineStatus;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Database Access Object for driver table.
 * <p/>
 */

public interface DriverRepository extends CrudRepository<DriverDO, Long> {

    List<DriverDO> findByOnlineStatus(OnlineStatus onlineStatus);

    @Query("SELECT new com.mytaxi.datatransferobject.DriverDTO(d.id, d.coordinate, " +
            "d.date_coordinate_updated, d.date_created, d.deleted, d.online_status, d.username, d.password) " +
            "FROM Driver d " +
            "LEFT JOIN Car c ON d.id = c.selected_driver_id " +
            "WHERE d.username = ? " +
            "OR d.online_status = ? OR c.license_plate = ? OR c.seat_count = ? " +
            "OR c.rating = ? OR c.engine_type = ? OR c.manufacturer = ?;")
    List<DriverDO> fetchDriverCarDataLeftJoin(Long id, GeoCoordinate coordinate, ZonedDateTime dateCoordinateUpdated,
                                               ZonedDateTime dateCreated, Boolean deleted, OnlineStatus onlineStatus,
                                               String username, String password);
}
