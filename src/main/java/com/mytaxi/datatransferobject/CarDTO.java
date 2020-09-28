package com.mytaxi.datatransferobject;

import java.time.ZonedDateTime;
import java.util.UUID;

public class CarDTO {

    private UUID carId;
    private String licensePlate;
    private int seatCount;
    private boolean convertible;
    private float rating;
    private String engineType;
    private String manufacturer;
    private boolean isCarSelected;
    private ZonedDateTime dateCreated;
    private ZonedDateTime dateSelected;
    private long selectedDriverId;

    private CarDTO() {
    }

    public CarDTO(UUID carId, String licensePlate, int seatCount, boolean convertible, float rating, String engineType, String manufacturer, boolean isCarSelected, ZonedDateTime dateCreated, ZonedDateTime dateSelected, long selectedDriverId) {
        this.carId = carId;
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
        this.convertible = convertible;
        this.rating = rating;
        this.engineType = engineType;
        this.manufacturer = manufacturer;
        this.isCarSelected = isCarSelected;
        this.dateCreated = dateCreated;
        this.dateSelected = dateSelected;
        this.selectedDriverId = selectedDriverId;
    }

    public UUID getCarId() {
        return carId;
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

    public String getLicensePlate() {
        return licensePlate;
    }

    public boolean isCarSelected() {
        return isCarSelected;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public ZonedDateTime getDateSelected() {
        return dateSelected;
    }

    public long getSelectedDriverId() {
        return selectedDriverId;
    }

    public static CarDTOBuilder newBuilder(){ return new CarDTOBuilder();}

    public static class CarDTOBuilder {
        private UUID carId;
        private ZonedDateTime dateCreated;
        private ZonedDateTime dateSelected;
        private long selectedDriverId;
        private String licensePlate;
        private int seatCount;
        private boolean convertible;
        private float rating;
        private String engineType;
        private String manufacturer;
        private boolean isCarSelected;

        public CarDTOBuilder setCarId(UUID carId) {
            this.carId = carId;
            return this;
        }

        public CarDTOBuilder setLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public CarDTOBuilder setSeatCount(int seatCount) {
            this.seatCount = seatCount;
            return this;
        }

        public CarDTOBuilder setConvertible(boolean convertible) {
            this.convertible = convertible;
            return this;
        }

        public CarDTOBuilder setRating(float rating) {
            this.rating = rating;
            return this;
        }

        public CarDTOBuilder setEngineType(String engineType) {
            this.engineType = engineType;
            return this;
        }

        public CarDTOBuilder setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public CarDTOBuilder setCarSelected(boolean carSelected) {
            isCarSelected = carSelected;
            return this;
        }

        public CarDTOBuilder setDateCreated(ZonedDateTime dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public CarDTOBuilder setDateSelected(ZonedDateTime dateSelected) {
            this.dateSelected = dateSelected;
            return this;
        }

        public CarDTOBuilder setSelectedDriverId(long selectedDriverId) {
            this.selectedDriverId = selectedDriverId;
            return this;
        }

        public CarDTO createCarDTO ()
        {
            return new CarDTO(carId, licensePlate, seatCount, convertible, rating, engineType, manufacturer, isCarSelected, dateCreated, dateSelected, selectedDriverId);
        }
    }
}
