package com.example.users.controller;

import com.example.users.VO.ResponseTemplateVO;
import com.example.users.entity.User;
import com.example.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithOrder(@PathVariable("id") Long userId){
        for(int i =0; i<10;i++){
            System.out.println(i + " " +userService.getUserWithOrder(userId));
        }
        return userService.getUserWithOrder(userId);
    }
}
