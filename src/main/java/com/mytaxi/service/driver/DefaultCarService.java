package com.mytaxi.service.driver;

import com.mytaxi.dataaccessobject.CarRepository;
import com.mytaxi.dataaccessobject.DriverRepository;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.exception.CarAlreadyInUseException;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.DriverNotOnlineException;
import com.mytaxi.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import static com.mytaxi.domainvalue.OnlineStatus.ONLINE;

@Service
public class DefaultCarService implements CarService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultCarService.class);

    private final CarRepository carRepository;

    private final DriverRepository driverRepository;

    public DefaultCarService(final CarRepository carRepository, DriverRepository driverRepository) {
        this.carRepository = carRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public CarDO findById(UUID carId) throws EntityNotFoundException {
        return findCarChecked(carId);
    }


    @Override
    public CarDO create(CarDO carDO) throws ConstraintsViolationException {
        CarDO car;
        try {
            car = carRepository.save(carDO);
        } catch (DataIntegrityViolationException e) {
            LOG.error("ConstraintsViolationException while creating a car: {}", carDO.toString(), e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return car;
    }

    //Used to deselect a car
    @Override
    @Transactional
    public void delete(UUID carId) throws EntityNotFoundException {

        CarDO carDO = findCarChecked(carId);
        carDO.setSelectedDriverId(null);
        carDO.setDateSelected(ZonedDateTime.now());
        carDO.setCarSelected(false);

    }

    //Used to select a car
    @Override
    @Transactional
    public void updateCarSelection(UUID carId, String selectedDriverId) throws EntityNotFoundException {

        CarDO carDO = findCarChecked(carId);
        //Checks if the driver is online and if car is already in use. Throws exception.
        try {
            if (driverOnlineStatus(selectedDriverId)) {
                try {
                    if (carDO.getSelectedDriverId() == null) {
                        carDO.setSelectedDriverId(selectedDriverId);
                        carDO.setDateSelected(ZonedDateTime.now());
                        carDO.setCarSelected(true);
                    } else {
                        LOG.error("Car already in use.");
                        String msg = "Car already in use.";
                        throw new CarAlreadyInUseException(msg);
                    }
                } catch (CarAlreadyInUseException ex) {
                    LOG.error("CarAlreadyInUseException while selecting a car: {}", carDO.toString(), ex);
                }
            } else {
                LOG.error("Driver has to be online to select a car.");
                String msg = "Driver has to be online to select a car.";
                throw new DriverNotOnlineException(msg);
            }
        } catch (DriverNotOnlineException ex2) {
            LOG.error("DriverNotOnlineException while selecting a car: {}", carDO.toString(), ex2);
        }


    }

    @Override
    public List<CarDO> findCars(boolean isCarSelected) {
        return carRepository.findByIsCarSelected(isCarSelected);
    }

    private CarDO findCarChecked(UUID carId) throws EntityNotFoundException {
        return carRepository.findById(carId)
                .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + carId));
    }

    //Search driver entry by driver ID to lookup online status
    private DriverDO findDriverStatus(Long driverId) throws EntityNotFoundException {
        return driverRepository.findById(driverId)
                .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + driverId));
    }
    //Checks if driver status is Online. Returns True if it is.
    private Boolean driverOnlineStatus(String driverId) throws EntityNotFoundException {
        DriverDO driverDO = findDriverStatus(Long.valueOf(driverId));
        OnlineStatus onlineStatus = driverDO.getOnlineStatus();
        return onlineStatus.equals(ONLINE);
    }
}
