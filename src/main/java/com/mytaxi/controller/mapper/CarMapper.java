package com.mytaxi.controller.mapper;

import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CarMapper {
    public static CarDO makeCarDO(CarDTO carDTO)
    {
        return new CarDO(carDTO.getCarId(), carDTO.getDateCreated(),carDTO.getLicensePlate(), carDTO.getSeatCount(),carDTO.isConvertible(), carDTO.getRating(), carDTO.getEngineType(), carDTO.getManufacturer(), carDTO.getSelectedDriverId(), carDTO.getDateSelected(), carDTO.isCarSelected());
    }

    public static CarDTO makeCarDTO(CarDO carDO)
    {
        CarDTO.CarDTOBuilder carDTOBuilder = CarDTO.newBuilder()
                .setCarId(carDO.getCarId())
                .setLicensePlate(carDO.getLicensePlate())
                .setSeatCount(carDO.getSeatCount())
                .setConvertible(carDO.isConvertible())
                .setRating(carDO.getRating())
                .setEngineType(carDO.getEngineType())
                .setManufacturer(carDO.getManufacturer())
                .setCarSelected(carDO.isCarSelected());
        return carDTOBuilder.createCarDTO();
    }

    public static List<CarDTO> makeCarDTOList(Collection<CarDO> cars)
    {
        return cars.stream()
                .map(CarMapper::makeCarDTO)
                .collect(Collectors.toList());
    }
}

