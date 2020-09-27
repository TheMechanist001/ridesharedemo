package com.mytaxi.service.driver;

import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public interface CarService {
    CarDO findById(UUID carId) throws EntityNotFoundException;

    CarDO create(CarDO carDO) throws ConstraintsViolationException;

    void delete(UUID carId) throws EntityNotFoundException;

    void updateCarSelection(UUID carId, ZonedDateTime dateSelected, boolean isCarSelected, long selectedDriverId) throws EntityNotFoundException;

    List<CarDO> findCars(boolean isCarSelected);
}
