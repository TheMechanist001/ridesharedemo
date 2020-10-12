package com.mytaxi.controller;

import com.mytaxi.controller.mapper.CarMapper;
import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.service.driver.CarService;
import com.mytaxi.service.driver.DefaultCarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/cars")
public class CarController {

    private static final Logger LOG = LoggerFactory.getLogger(CarController.class);

    private final CarService carService;

    @Autowired
    public CarController(final CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{carId}")
    public CarDTO getCar(@PathVariable UUID carId) throws EntityNotFoundException
    {
        return CarMapper.makeCarDTO(carService.findById(carId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarDTO createCar(@Valid @RequestBody CarDTO carDTO) throws ConstraintsViolationException {
        CarDO carDO = CarMapper.makeCarDO(carDTO);
        return CarMapper.makeCarDTO(carService.create(carDO));
    }

    @DeleteMapping("/{carId}")
    public void deleteDriver(@PathVariable UUID carId) throws EntityNotFoundException {
        carService.delete(carId);
    }

    @PutMapping("/{carId}")
    public void updateCarSelection(@PathVariable UUID carId, @RequestParam String selectedDriverId) throws EntityNotFoundException {
        carService.updateCarSelection(carId, selectedDriverId);
    }

    @GetMapping
    public List<CarDTO> findCars(@RequestParam boolean isCarSelected)
    {
        return  CarMapper.makeCarDTOList(carService.findCars(isCarSelected));
    }
}
