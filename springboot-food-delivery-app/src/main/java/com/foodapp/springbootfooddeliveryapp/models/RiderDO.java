package com.foodapp.springbootfooddeliveryapp.models;

import lombok.*;

@Getter
@Setter
@ToString
public class RiderDO {
    private Integer id;
    private String name;
    private String mobileNo;
    private String address;
    private Coordinates liveCoordinates;
    private Boolean isAvailable;
    private Double ratings;
}
