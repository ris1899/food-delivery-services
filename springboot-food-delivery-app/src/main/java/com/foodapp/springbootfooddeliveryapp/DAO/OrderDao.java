package com.foodapp.springbootfooddeliveryapp.DAO;

import com.foodapp.springbootfooddeliveryapp.models.OrderDO;
import com.foodapp.springbootfooddeliveryapp.models.RestaurantDO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class OrderDao {
    HashMap<Integer, OrderDO> orderDOHashMap = new HashMap<>();
    public void placeOrder(OrderDO orderDO){
        orderDOHashMap.put(orderDO.getId(),orderDO);

    }

    public List<OrderDO> getAllOrders(){
        return new ArrayList<>(orderDOHashMap.values());
    }




}

