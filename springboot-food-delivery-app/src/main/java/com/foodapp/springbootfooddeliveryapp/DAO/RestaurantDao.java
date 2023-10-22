package com.foodapp.springbootfooddeliveryapp.DAO;

import com.foodapp.springbootfooddeliveryapp.models.RestaurantDO;
import com.foodapp.springbootfooddeliveryapp.models.RiderDO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class RestaurantDao {

    HashMap<Integer, RestaurantDO> restaurantDOHashMap = new HashMap<>();
    public void registerRestaurant(RestaurantDO restaurantDO){
        restaurantDOHashMap.put(restaurantDO.getId(),restaurantDO);
    }

    public void removeRestaurant(Integer restaurantId){
        restaurantDOHashMap.remove(restaurantId);
    }

    public List<RestaurantDO>getAll(){
        return new ArrayList<>(restaurantDOHashMap.values());
    }
    public RestaurantDO getRestaurantById(Integer id){
        return restaurantDOHashMap.get(id);
    }

}
