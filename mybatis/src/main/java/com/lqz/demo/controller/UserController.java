package com.lqz.demo.controller;

import com.lqz.demo.module.SysUser;
import com.lqz.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LiaoQinZhou
 * @date: 2021/1/29 15:14
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<SysUser> queryAll(){
        return userService.queryAll();
    }

}
