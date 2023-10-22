package com.foodapp.springbootfooddeliveryapp.DAO;

import com.foodapp.springbootfooddeliveryapp.models.UserDO;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class UserDao {

    HashMap<Integer,UserDO> userDOHashMap = new HashMap<>();
    public void addUser(UserDO userDO){
        userDOHashMap.put(userDO.getId(),userDO);
    }

    public void deleteUser(Integer userId){
        userDOHashMap.remove(userId);
    }

    public UserDO getUserByUserId(Integer userId){
       return userDOHashMap.get(userId);
    }

    public List<UserDO> getAllUsers(){
        return new ArrayList<>(userDOHashMap.values());
    }



}
