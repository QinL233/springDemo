package com.lqz.demo.controller;

import com.lqz.demo.entity.UserModel;
import com.lqz.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/5 16:11
 */
@RestController
public class TestController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String add(@RequestBody UserModel userModel){
        String id = userService.add(userModel);
        return id;
    }

    @GetMapping("/get/{id}")
    public UserModel get(@PathVariable Long id){
        UserModel userModel = userService.get(id);
        return userModel;
    }
}
