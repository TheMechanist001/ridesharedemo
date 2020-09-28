package com.mytaxi.domainobject;

import java.time.ZonedDateTime;
import java.util.UUID;

public class CarDO {

    private UUID carId;
    private ZonedDateTime dateCreated;
    private String licensePlate;
    private int seatCount;
    private boolean convertible;
    private float rating;
    private String engineType;
    private String manufacturer;
    private long selectedDriverId;
    private ZonedDateTime dateSelected;
    private boolean isCarSelected;

    public UUID getCarId() {
        return carId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public float getRating() {
        return rating;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public long getSelectedDriverId() {
        return selectedDriverId;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public ZonedDateTime getDateSelected() {
        return dateSelected;
    }

    public boolean isCarSelected() {
        return isCarSelected;
    }

    public void setCarId(UUID carId) {
        this.carId = carId;
    }

    public void setSelectedDriverId(long selectedDriverId) {
        this.selectedDriverId = selectedDriverId;
    }

    public void setDateSelected(ZonedDateTime dateSelected) {
        this.dateSelected = dateSelected;
    }

    public void setCarSelected(boolean carSelected) {
        isCarSelected = carSelected;
    }

    private CarDO() {
    }

    public CarDO(UUID carId, ZonedDateTime dateCreated, String licensePlate, int seatCount, boolean convertible, float rating, String engineType, String manufacturer, long selectedDriverId, ZonedDateTime dateSelected, boolean isCarSelected) {
        this.carId = carId;
        this.dateCreated = dateCreated;
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
        this.convertible = convertible;
        this.rating = rating;
        this.engineType = engineType;
        this.manufacturer = manufacturer;
        this.selectedDriverId = selectedDriverId;
        this.dateSelected = dateSelected;
        this.isCarSelected = isCarSelected;
    }

}
