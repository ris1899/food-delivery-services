package com.foodapp.springbootfooddeliveryapp.models;

import lombok.*;

@Getter
@Setter
@ToString
public class UserDO {
    private Integer id;
    private String name;
    private String mailId;
    private String mobileNo;
    private String address;
    private Coordinates coordinates;
    private Integer coupons;
}
