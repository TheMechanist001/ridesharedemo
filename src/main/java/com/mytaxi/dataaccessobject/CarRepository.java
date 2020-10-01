package com.mytaxi.dataaccessobject;

import com.mytaxi.domainobject.CarDO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends CrudRepository<CarDO, UUID> {
    List<CarDO> findByIsCarSelected (boolean isCarSelected);
}
