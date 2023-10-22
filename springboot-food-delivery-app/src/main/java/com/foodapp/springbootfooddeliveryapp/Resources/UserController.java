package com.foodapp.springbootfooddeliveryapp.Resources;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.foodapp.springbootfooddeliveryapp.Services.OrderService;
import com.foodapp.springbootfooddeliveryapp.Services.UserServices;
import com.foodapp.springbootfooddeliveryapp.models.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {



    @Autowired
    private UserServices userService;

    @Autowired
    private OrderService orderService;


    //API to register a user
    @PostMapping(value = "/register")
    public void addUser(@RequestBody UserDO user) {
        userService.addUser(user);
        log.info("User Added {}",user);
    }

    //API to delete user
    @PostMapping(value = "/delete/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        log.info("User deleted {}",userId);
    }


    //API to fetch user from userID
     @GetMapping(value = "/{userId}")
    public UserDO getUserDetails(@PathVariable Integer userId) throws Exception {
        UserDO response = userService.getUserDetails(userId);
        log.info("User Response -{}",response);
        return response;
    }


    //API to get ALL users
    @GetMapping(value = "/all")
    public List<UserDO> getAllUsers() throws Exception {
        List<UserDO> response = userService.getAllUsers();
        log.info("User Response -{}",response);
        return response;
    }


}
