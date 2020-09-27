package com.mytaxi.service.driver;

import com.mytaxi.dataaccessobject.CarRepository;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DefaultCarService implements CarService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultCarService.class);

    private final CarRepository carRepository;

    public DefaultCarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarDO find(UUID carId) throws EntityNotFoundException {
        return findCarChecked(carId);
    }



    @Override
    public CarDO create(CarDO carDO) throws ConstraintsViolationException {
        CarDO car;
        try
        {
            car = carRepository.save(carDO);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("ConstraintsViolationException while creating a car: {}", carDO, e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return car;
    }

    @Override
    @Transactional
    public void delete(UUID carId) throws EntityNotFoundException {
        CarDO car;
        try
        {
            carRepository.deleteById(carId);
        }
        catch (Exception e)
        {
            LOG.error("Exception while deleting a car with ID: {}", carId, e);
        }

    }

    @Override
    public void updateCarSelection(UUID carId, ZonedDateTime dateSelected, boolean isCarSelected, long selectedDriverId) throws EntityNotFoundException {

        CarDO carDO = findCarChecked(carId);
        carDO.setDateSelected(dateSelected);
        carDO.setCarSelected(isCarSelected);
        carDO.setSelectedDriverId(selectedDriverId);

    }

    @Override
    public List<CarDO> find(boolean isCarSelected) {
        return carRepository.findBySelectedStatus(isCarSelected);
    }

    private CarDO findCarChecked(UUID carId) throws EntityNotFoundException {
        return carRepository.findById(carId)
                .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + carId));
    }
}
