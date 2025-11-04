package com.citycare.Controller;

import com.citycare.model.User;
import com.citycare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "https://citycare-siddesh.netlify.app")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/all")
    public List<User> getall(){
        return userService.getall();
    }

}

