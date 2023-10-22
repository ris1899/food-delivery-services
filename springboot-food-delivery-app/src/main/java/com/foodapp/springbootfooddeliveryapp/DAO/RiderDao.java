package com.foodapp.springbootfooddeliveryapp.DAO;

import com.foodapp.springbootfooddeliveryapp.models.RiderDO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class RiderDao {
    HashMap<Integer, RiderDO> riderDOHashMap = new HashMap<>();
    public void registerRider(RiderDO riderDO){

        riderDOHashMap.put(riderDO.getId(),riderDO);
    }

    public void deleteRider(Integer riderId){
        riderDOHashMap.remove(riderId);
    }

    public List<RiderDO> getAll(){
        return new ArrayList<>(riderDOHashMap.values());
    }

    public RiderDO getRiderById(Integer riderId){
        return riderDOHashMap.get(riderId);
    }



}
