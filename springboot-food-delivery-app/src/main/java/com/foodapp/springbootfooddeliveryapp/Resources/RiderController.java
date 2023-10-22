package com.foodapp.springbootfooddeliveryapp.Resources;

import com.foodapp.springbootfooddeliveryapp.Services.RiderService;
import com.foodapp.springbootfooddeliveryapp.models.Coordinates;
import com.foodapp.springbootfooddeliveryapp.models.RiderDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/rider")
public class RiderController {

    @Autowired
    private RiderService riderService;



    // API to register a rider
    @PostMapping(value = "/register")
    public void addUser(@RequestBody RiderDO rider) {
        riderService.registerRider(rider);
        log.info("Rider Added {}",rider);
    }

    // API to delete a Rider
    @PostMapping(value = "/delete/{riderId}")
    public void deleteUser(@PathVariable Integer riderId) {
        riderService.deleteRider(riderId);
        log.info("Rider deleted {}",riderId);
    }

    // API for locating riders in proximity to a restaurant.
    @GetMapping(value = "/nearBy/{restaurantId}")
    public RiderDO getNearByRider(@PathVariable Integer restaurantId) throws Exception {
        RiderDO response = riderService.getNearByRider(restaurantId);
        log.info("Nearest rider near by {} is {}",restaurantId,response);
        return response;
    }

    // API to regularly update Riders location
    // this API should be used as polling API if rider is available
    @PostMapping(value = "/update-location/{riderId}")
    public void riderUpdateLocation(@RequestBody Coordinates coordinates,@PathVariable Integer riderId) throws Exception {
        riderService.updateLiveLocation(coordinates,riderId);
        log.info("Rider location updated {}",riderId);
    }



}
