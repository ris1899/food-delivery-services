package com.foodapp.springbootfooddeliveryapp.models;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Serialization
public class OrderDO {
    private Integer id;
    private Integer userId;
    private Integer restaurantId;
    private Integer riderId;
    private List<MenuItems> menuItemList;
    private OrderStatus orderStatus;

    public enum OrderStatus{
        DELIVERED,ON_THE_WAY,PREPARING,CANCEL,ACCEPTED
    }

}
