package com.foodapp.springbootfooddeliveryapp.Services;

import com.foodapp.springbootfooddeliveryapp.DAO.RestaurantDao;
import com.foodapp.springbootfooddeliveryapp.models.MenuItems;
import com.foodapp.springbootfooddeliveryapp.models.RestaurantDO;
import com.foodapp.springbootfooddeliveryapp.models.RiderDO;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantDao restaurantDao;
    public void registerRestaurant(RestaurantDO restaurantDO){
        //scope -> can add validation of mobile number through OTP for registration
        restaurantDao.registerRestaurant(restaurantDO);
    }

    public void removeRestaurant(Integer restaurantId){
        restaurantDao.removeRestaurant(restaurantId);
    }

    public List<RestaurantDO> searchRestaurant(String cuisine, String timing){
       Date currentDate = new Date();
       Integer currentTime = (timing!=null)? Integer.parseInt(timing):currentDate.getHours()*100;
        List<RestaurantDO>restaurantDOList = restaurantDao.getAll();
        List<RestaurantDO>finalRestaurantList= new ArrayList<>();

        for(RestaurantDO restaurantDO : restaurantDOList){
            List<MenuItems> menuItems = restaurantDO.getMenuItems();
            Boolean isCuisinePresent = false;
            for(MenuItems menu : menuItems){
                if(menu.getCuisineTypes().contains(cuisine)){
                    isCuisinePresent=true;
                    break;
                }
            }
            if(isCuisinePresent  && Long.parseLong(String.valueOf(currentTime))>Long.parseLong(restaurantDO.getOpeningTime()) && Long.parseLong(String.valueOf(currentTime))<=Long.parseLong(restaurantDO.getClosingTime())){
                finalRestaurantList.add(restaurantDO);
            }
        }

        return finalRestaurantList;
    }

    public List<MenuItems> getMenu(Integer restaurantId) throws Exception {
        RestaurantDO restaurantDO = restaurantDao.getRestaurantById(restaurantId);
        if(restaurantDO==null){
            throw new Exception("No restaurant found");
        }
        return restaurantDO.getMenuItems();
    }

}
