package com.foodapp.springbootfooddeliveryapp.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
public class RestaurantDO {
    private Integer id;
    private String name;
    private String mailId;
    private String mobileNo;
    private String address;
    private Coordinates coordinates;
    private List<MenuItems> menuItems;
    private String openingTime;
    private String closingTime;
    private String avgRating;
    private String isAvailable;

}
