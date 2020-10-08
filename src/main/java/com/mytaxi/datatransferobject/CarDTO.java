package com.mytaxi.datatransferobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO {

    @JsonIgnore
    private UUID carId = UUID.randomUUID();

    @NotNull(message = "License Plate cannot be null!")
    private String licensePlate;

    @NotNull(message = "Seat Count cannot be null!")
    private int seatCount;

    private boolean convertible;

    private float rating;

    @NotNull(message = "Engine Type cannot be null!")
    private String engineType;

    @NotNull(message = "Manufacturer cannot be null!")
    private String manufacturer;

    private boolean isCarSelected;

    private ZonedDateTime dateCreated = ZonedDateTime.now();

    private ZonedDateTime dateSelected = ZonedDateTime.now();

    private String selectedDriverId;

    private CarDTO() {
    }

    public CarDTO(UUID carId, String licensePlate, int seatCount, boolean convertible, float rating, String engineType, String manufacturer, boolean isCarSelected, ZonedDateTime dateCreated, ZonedDateTime dateSelected, String selectedDriverId) {
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

    @JsonProperty
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

    public String getSelectedDriverId() {
        return selectedDriverId;
    }

    public static CarDTOBuilder newBuilder(){ return new CarDTOBuilder();}

    public static class CarDTOBuilder {
        private UUID carId;
        private ZonedDateTime dateCreated;
        private ZonedDateTime dateSelected;
        private String selectedDriverId;
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

        public CarDTOBuilder setSelectedDriverId(String selectedDriverId) {
            this.selectedDriverId = selectedDriverId;
            return this;
        }

        public CarDTO createCarDTO ()
        {
            return new CarDTO(carId, licensePlate, seatCount, convertible, rating, engineType, manufacturer, isCarSelected, dateCreated, dateSelected, selectedDriverId);
        }
    }
}
