package com.foodapp.springbootfooddeliveryapp.Resources;

import com.foodapp.springbootfooddeliveryapp.Services.RestaurantService;
import com.foodapp.springbootfooddeliveryapp.Services.RiderService;
import com.foodapp.springbootfooddeliveryapp.models.MenuItems;
import com.foodapp.springbootfooddeliveryapp.models.RestaurantDO;
import com.foodapp.springbootfooddeliveryapp.models.RiderDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {


    @Autowired
    private RestaurantService restaurantService;

    // API to register a restaurant
    @PostMapping(value = "/register")
    public void registerRestaurant(@RequestBody RestaurantDO restaurantDO) {
        restaurantService.registerRestaurant(restaurantDO);
        log.info("restaurant Added {}",restaurantDO);
    }

    // API to delete a restaurant
    @PostMapping(value = "/delete/{restaurantId}")
    public void removeRestaurant(@PathVariable Integer restaurantId) {
        restaurantService.removeRestaurant(restaurantId);
        log.info("restaurant deleted {}",restaurantId);
    }

    // API to search restaurants based on cuisine and timings(restaurant is available)
    @GetMapping(value = "/search")
    public List<RestaurantDO> searchRestaurant(@RequestParam String cuisine, @RequestParam(required = false) String timing) {
       List<RestaurantDO> response = restaurantService.searchRestaurant(cuisine,timing);
        log.info("search restaurant for {} {}",cuisine,timing);
       return response;
    }

    // API get menu items of restaurant
    @GetMapping(value = "/menu/{restaurantId}")
    public List<MenuItems> restaurantMenu(@PathVariable Integer restaurantId) throws Exception {
       List<MenuItems> response = restaurantService.getMenu(restaurantId);
       log.info("Menu for restaurant {}",response);
       return response;
    }


}
