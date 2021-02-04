package com.lqz.demo.controller;

import com.lqz.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/4 16:16
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisService redisService;

    @PostMapping("/post")
    public String put(@RequestParam String value) {
        String id = UUID.randomUUID().toString();
        redisService.set(id, value);
        return id;
    }

    @GetMapping("/{key}")
    public String get(@PathVariable String key) {
        return redisService.get(key);
    }
}
