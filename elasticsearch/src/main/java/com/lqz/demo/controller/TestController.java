package com.lqz.demo.controller;

import com.lqz.demo.entity.UserModel;
import com.lqz.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/5 14:32
 */
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<UserModel> list(){
        List<UserModel> list = userService.list();
        return list;
    }

    @PostMapping("/add")
    public String add(@RequestBody UserModel userModel){
        Long id = userService.add(userModel);
        return id.toString();
    }

    @GetMapping("/get/{id}")
    public UserModel get(@PathVariable Long id){
        UserModel userModel = userService.get(id);
        return userModel;
    }
}
