package com.lqz.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/5 17:24
 */
@Api(tags = "TestController", description = "测试")
@RestController
public class TestController {

    @ApiOperation("测试")
    @GetMapping("/get/{test}")
    public String get(@PathVariable String test) {
        System.out.println(test);
        return Thread.currentThread().getName();
    }
}
