package com.mytaxi.domainobject;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table( name = "car", uniqueConstraints = @UniqueConstraint(name = "uc_licensePlate", columnNames = {"licensePlate"}))
public class CarDO {

    @Id
    @Column(nullable = false)
    @NotNull(message = "Car Id cannot be null!")
    private UUID carId;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column(nullable = false)
    @NotNull(message = "License Plate cannot be null!")
    private String licensePlate;

    @Column(nullable = false)
    @NotNull(message = "Seat Count cannot be null!")
    private int seatCount;

    @Column(nullable = false)
    private boolean convertible = false;

    @Column(nullable = false)
    private float rating;

    @Column(nullable = false)
    @NotNull(message = "Engine Type cannot be null!")
    private String engineType;

    @Column(nullable = false)
    @NotNull(message = "Manufacturer cannot be null!")
    private String manufacturer;

    @Column
    private String selectedDriverId;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateSelected;

    @Column(nullable = false)
    private boolean isCarSelected;

    @OneToMany(targetEntity = DriverDO.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<DriverDO> driverDO;

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

    public String getSelectedDriverId() {
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

    public void setSelectedDriverId(String selectedDriverId) {
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

    public CarDO(UUID carId, ZonedDateTime dateCreated, String licensePlate, int seatCount, boolean convertible, float rating, String engineType, String manufacturer, String selectedDriverId, ZonedDateTime dateSelected, boolean isCarSelected) {
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[carId= " + carId + ", dateCreated= " + dateCreated + ", licensePlate= " + licensePlate + ", seatCount= " + seatCount
                + ", convertible= " + convertible + ", rating= " + rating + ", engineType= " + engineType + ", manufacturer= " + manufacturer
                + ", selectedDriverId= " + selectedDriverId + ", dateSelected= " + dateSelected + ", isCarSelected= " + isCarSelected + "]";
    }

}
