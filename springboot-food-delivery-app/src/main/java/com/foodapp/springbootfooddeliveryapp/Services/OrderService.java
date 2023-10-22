package com.foodapp.springbootfooddeliveryapp.Services;

import com.foodapp.springbootfooddeliveryapp.DAO.OrderDao;
import com.foodapp.springbootfooddeliveryapp.models.OrderDO;
import com.foodapp.springbootfooddeliveryapp.models.UserDO;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserServices userServices;

    public void placeOrder(OrderDO orderDO) throws Exception {

        orderDao.placeOrder(orderDO);

        try{
            //Increasing discount coupon count for user when order is delivered
            if(orderDO.getOrderStatus().name().equalsIgnoreCase("DELIVERED")){
                UserDO userDO = userServices.getUserDetails(orderDO.getUserId());
                userDO.setCoupons( (userDO.getCoupons()==null)?1:userDO.getCoupons()+1 );
                userServices.addUser(userDO);
            }
        }catch (Exception ex){

        }
    }

    public List<OrderDO> getOrdersByUserId(Integer userId){
        List<OrderDO>listOfOrdersByUserId = new ArrayList<>();
        for(OrderDO orderDO : orderDao.getAllOrders()){
            if(orderDO.getUserId().equals(userId)){
                listOfOrdersByUserId.add(orderDO);
            }
        }
        return listOfOrdersByUserId;
    }


    public List<OrderDO> getOrdersByRiderId(Integer riderId){
        List<OrderDO>listOfOrdersByRiderId = new ArrayList<>();
        for(OrderDO orderDO : orderDao.getAllOrders()){
            if(orderDO.getUserId().equals(riderId)){
                listOfOrdersByRiderId.add(orderDO);
            }
        }
        return listOfOrdersByRiderId;
    }

}
