package com.citycare.dao;

import com.citycare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserDao extends JpaRepository<User,Integer>{
}
