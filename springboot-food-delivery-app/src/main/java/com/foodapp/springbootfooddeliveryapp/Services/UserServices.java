package com.foodapp.springbootfooddeliveryapp.Services;

import com.foodapp.springbootfooddeliveryapp.DAO.UserDao;
import com.foodapp.springbootfooddeliveryapp.models.UserDO;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserDao userDao;

    public void addUser(UserDO userDo){
        //scope -> can add validation of mobile number through OTP for user registration
        userDao.addUser(userDo);
    }

    public void deleteUser(Integer userId){
        userDao.deleteUser(userId);
    }

    public UserDO getUserDetails(Integer userId) throws Exception {
       UserDO userDO = userDao.getUserByUserId(userId);
       if(userDO==null){
           throw new Exception("No User found  for user");
       }
       return userDO;
    }

    public List<UserDO> getAllUsers() throws Exception {
        List<UserDO> userDOList = userDao.getAllUsers();
        if(userDOList==null){
            throw new Exception("No User found  for user");
        }
        return userDOList;
    }



}
