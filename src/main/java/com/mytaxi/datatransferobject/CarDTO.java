package com.mytaxi.datatransferobject;

import java.util.UUID;

public class CarDTO {

    private UUID carId;
    private String licensePlate;
    private int seatCount;
    private boolean convertible;
    private long rating;
    private String engineType;
    private String manufacturer;
    private boolean isCarSelected;

    private CarDTO() {
    }

    private CarDTO(UUID carId, String licensePlate, int seatCount, boolean convertible, long rating, String engineType, String manufacturer, boolean isCarSelected) {
        this.carId = carId;
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
        this.convertible = convertible;
        this.rating = rating;
        this.engineType = engineType;
        this.manufacturer = manufacturer;
        this.isCarSelected = isCarSelected;
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

    public long getRating() {
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

    public static CarDTOBuilder newBuilder(){ return new CarDTOBuilder();}

    public static class CarDTOBuilder {
        private UUID carId;
        private String licensePlate;
        private int seatCount;
        private boolean convertible;
        private long rating;
        private String engineType;
        private String manufacturer;
        private boolean isCarSelected;

        public void setCarId(UUID carId) {
            this.carId = carId;
        }

        public void setLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
        }

        public void setSeatCount(int seatCount) {
            this.seatCount = seatCount;
        }

        public void setConvertible(boolean convertible) {
            this.convertible = convertible;
        }

        public void setRating(long rating) {
            this.rating = rating;
        }

        public void setEngineType(String engineType) {
            this.engineType = engineType;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public void setCarSelected(boolean carSelected) {
            isCarSelected = carSelected;
        }

        public CarDTO createCarDTO ()
        {
            return new CarDTO(carId, licensePlate, seatCount, convertible, rating, engineType, manufacturer, isCarSelected);
        }
    }
}
