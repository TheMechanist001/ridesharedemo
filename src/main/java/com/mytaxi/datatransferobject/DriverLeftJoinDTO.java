package com.mytaxi.datatransferobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mytaxi.domainvalue.GeoCoordinate;
import com.mytaxi.domainvalue.OnlineStatus;

import javax.validation.constraints.NotNull;

/**
 * This DTO is for Task 3 only
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DriverLeftJoinDTO {
    @JsonIgnore
    private Long id;

    @NotNull(message = "Username can not be null!")
    private String username;

    @NotNull(message = "Password can not be null!")
    private String password;

    private GeoCoordinate coordinate;

    private Boolean deleted;

    private OnlineStatus onlineStatus;


    private DriverLeftJoinDTO() {
    }

    //for Task 3
    public DriverLeftJoinDTO(Long id, String username, String password, GeoCoordinate coordinate, Boolean deleted, OnlineStatus onlineStatus) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.coordinate = coordinate;
        this.deleted = deleted;
        this.onlineStatus = onlineStatus;
    }


    public static DriverLeftJoinDTOBuilder newBuilder() {
        return new DriverLeftJoinDTOBuilder();
    }


    @JsonProperty
    public Long getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public GeoCoordinate getCoordinate() {
        return coordinate;
    }

    public Boolean getDeleted() { return deleted; }

    public OnlineStatus getOnlineStatus() { return onlineStatus; }

    public static class DriverLeftJoinDTOBuilder {
        private Long id;
        private String username;
        private String password;
        private GeoCoordinate coordinate;
        private Boolean deleted;
        private OnlineStatus onlineStatus;


        public DriverLeftJoinDTOBuilder setId(Long id) {
            this.id = id;
            return this;
        }


        public DriverLeftJoinDTOBuilder setUsername(String username) {
            this.username = username;
            return this;
        }


        public DriverLeftJoinDTOBuilder setPassword(String password) {
            this.password = password;
            return this;
        }


        public DriverLeftJoinDTOBuilder setCoordinate(GeoCoordinate coordinate) {
            this.coordinate = coordinate;
            return this;
        }


        public DriverLeftJoinDTOBuilder setDeleted(Boolean deleted) {
            this.deleted = deleted;
            return this;
        }


        public DriverLeftJoinDTOBuilder setOnlineStatus(OnlineStatus onlineStatus) {
            this.onlineStatus = onlineStatus;
            return this;
        }


        public DriverLeftJoinDTO createDriverLeftJoinDTO() {
            return new DriverLeftJoinDTO(id, username, password, coordinate, deleted, onlineStatus);
        }

    }
}
