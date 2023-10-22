package com.foodapp.springbootfooddeliveryapp.Services;

import com.foodapp.springbootfooddeliveryapp.DAO.RestaurantDao;
import com.foodapp.springbootfooddeliveryapp.DAO.RiderDao;
import com.foodapp.springbootfooddeliveryapp.models.Coordinates;
import com.foodapp.springbootfooddeliveryapp.models.RestaurantDO;
import com.foodapp.springbootfooddeliveryapp.models.RiderDO;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderService {

    @Autowired
    private RiderDao riderDao;

    @Autowired
    RestaurantDao restaurantDao;

    public void registerRider(RiderDO riderDO){
        //scope -> can add validation of mobile number through OTP for user registration
        riderDao.registerRider(riderDO);
    }

    public void deleteRider(Integer riderId){
        riderDao.deleteRider(riderId);
    }

    public RiderDO getNearByRider(Integer restaurantId) throws Exception {
        RestaurantDO restaurantDO = restaurantDao.getRestaurantById(restaurantId);
        if(restaurantDO==null){
            throw new Exception("Invalid Request");
        }
        Coordinates restaurantLocation = restaurantDO.getCoordinates();
        List<RiderDO>riderDOList = riderDao.getAll();
        RiderDO nearestRider = null;
        Double nearestDistance = null;
        for(RiderDO riderDO : riderDOList){
            //check if rider is available or not
            if(!riderDO.getIsAvailable()) continue;
            Double riderLat = riderDO.getLiveCoordinates().getLatitude();
            Double riderLong = riderDO.getLiveCoordinates().getLongitude();
            Double distance = calculteGeoDistance(riderLat,riderLong,restaurantLocation.getLatitude(),restaurantLocation.getLongitude());
            if(nearestDistance==null || nearestDistance>distance){
                nearestRider=riderDO;
                nearestDistance=distance;
            }
        }
        return nearestRider;

    }

    private double calculteGeoDistance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;
        return (dist);
    }
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0); }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI); }


    public void updateLiveLocation(Coordinates coordinates,Integer riderId) throws Exception {
        RiderDO riderDO = riderDao.getRiderById(riderId);
        if(riderDO==null){
            throw new Exception("no Rider found");
        }
        if(riderDO.getIsAvailable()){
            riderDO.setLiveCoordinates(coordinates);
        }
        riderDao.registerRider(riderDO);

    }


}
