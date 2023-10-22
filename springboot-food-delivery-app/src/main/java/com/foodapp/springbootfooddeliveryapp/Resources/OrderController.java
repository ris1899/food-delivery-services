package com.foodapp.springbootfooddeliveryapp.Resources;

import com.foodapp.springbootfooddeliveryapp.Services.OrderService;
import com.foodapp.springbootfooddeliveryapp.models.OrderDO;
import com.foodapp.springbootfooddeliveryapp.models.RiderDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // API to submit food order
    @PostMapping(value = "/submit-order")
    public void submitOrder(@RequestBody OrderDO orderDO) throws Exception {
        orderService.placeOrder(orderDO);
    }


    // API to get Orders history of user
    @GetMapping(value = "/user/{userId}")
    public List<OrderDO> getOrdersByUserId(@PathVariable Integer userId) {
       List<OrderDO> response =  orderService.getOrdersByUserId(userId);
       log.info("Response for user order history -{}",response);
       return response;
    }


    // API to get orders history of Rider
    @GetMapping(value = "/rider/{riderId}")
    public List<OrderDO> getOrdersByRiderId(@PathVariable Integer riderId) {
        List<OrderDO> response =  orderService.getOrdersByRiderId(riderId);
        log.info("Response for rider order history -{}",response);
        return response;
    }
}
