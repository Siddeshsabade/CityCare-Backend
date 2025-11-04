package com.citycare.service;

import com.citycare.dao.UserDao;
import com.citycare.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userdao;

    public User createUser(User user){
        return userdao.save(user);
    }

    public List<User> getall(){
        return userdao.findAll();
    }



}
