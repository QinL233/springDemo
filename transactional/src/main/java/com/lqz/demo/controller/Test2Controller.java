package com.lqz.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lqz.demo.entity.Test2;
import com.lqz.demo.service.Test2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liaoQinZhou
 * @since 2022-04-06
 */
@RestController
@RequestMapping("/test2")
public class Test2Controller {
    @Autowired
    private Test2Service test2Service;

    @PostMapping("/list")
    public List<Test2> list(@RequestBody(required = false) Test2 entity) {
        QueryWrapper<Test2> wrapper = new QueryWrapper<>();
        wrapper.setEntity(entity);
        return test2Service.list(wrapper);
    }

    @PostMapping("/page")
    public IPage<Test2> page(@RequestParam(value = "current", defaultValue = "1") int current,
                             @RequestParam(value = "size", defaultValue = "10") int size,
                             @RequestBody(required = false) Test2 entity) {
        IPage<Test2> page = new Page<>(current, size);
        QueryWrapper<Test2> wrapper = new QueryWrapper<>();
        wrapper.setEntity(entity);
        return test2Service.page(page, wrapper);
    }

    @PostMapping("/required1")
    public Boolean required1(@RequestBody Test2 entity) {
        return test2Service.required1(entity);
    }

    @PostMapping("/required2")
    public Boolean required2(@RequestBody Test2 entity) {
        return test2Service.required2(entity);
    }

    @PostMapping("/required3")
    public Boolean required3(@RequestBody Test2 entity) {
        return test2Service.required3(entity);
    }

    @PostMapping("/required4")
    public Boolean required4(@RequestBody Test2 entity) {
        return test2Service.required4(entity);
    }

    @PostMapping("/required5")
    public Boolean required5(@RequestBody Test2 entity) {
        return test2Service.required5(entity);
    }

    @PostMapping("/supports1")
    public Boolean supports1(@RequestBody Test2 entity) {
        return test2Service.supports1(entity);
    }

    @PostMapping("/supports2")
    public Boolean supports2(@RequestBody Test2 entity) {
        return test2Service.supports2(entity);
    }

    @PostMapping("/supports3")
    public Boolean supports3(@RequestBody Test2 entity) {
        return test2Service.supports3(entity);
    }

    @PostMapping("/supports4")
    public Boolean supports4(@RequestBody Test2 entity) {
        return test2Service.supports4(entity);
    }

    @PostMapping("/mandatory1")
    public Boolean mandatory1(@RequestBody Test2 entity) {
        return test2Service.mandatory1(entity);
    }

    @PostMapping("/mandatory2")
    public Boolean mandatory2(@RequestBody Test2 entity) {
        return test2Service.mandatory2(entity);
    }

    @PostMapping("/mandatory3")
    public Boolean mandatory3(@RequestBody Test2 entity) {
        return test2Service.mandatory3(entity);
    }

    @PostMapping("/requiresNew1")
    public Boolean requiresNew1(@RequestBody Test2 entity) {
        return test2Service.requiresNew1(entity);
    }

    @PostMapping("/requiresNew2")
    public Boolean requiresNew2(@RequestBody Test2 entity) {
        return test2Service.requiresNew2(entity);
    }

    @PostMapping("/requiresNew3")
    public Boolean requiresNew3(@RequestBody Test2 entity) {
        return test2Service.requiresNew3(entity);
    }

    @PostMapping("/requiresNew4")
    public Boolean requiresNew4(@RequestBody Test2 entity) {
        return test2Service.requiresNew4(entity);
    }

    @PostMapping("/notSupported1")
    public Boolean notSupported1(@RequestBody Test2 entity) {
        return test2Service.notSupported1(entity);
    }

    @PostMapping("/notSupported2")
    public Boolean notSupported2(@RequestBody Test2 entity) {
        return test2Service.notSupported2(entity);
    }

    @PostMapping("/notSupported3")
    public Boolean notSupported3(@RequestBody Test2 entity) {
        return test2Service.notSupported3(entity);
    }

    @PostMapping("/notSupported4")
    public Boolean notSupported4(@RequestBody Test2 entity) {
        return test2Service.notSupported4(entity);
    }

    @PostMapping("/never1")
    public Boolean never1(@RequestBody Test2 entity) {
        return test2Service.never1(entity);
    }

    @PostMapping("/never2")
    public Boolean never2(@RequestBody Test2 entity) {
        return test2Service.never2(entity);
    }

    @PostMapping("/never3")
    public Boolean never3(@RequestBody Test2 entity) {
        return test2Service.never3(entity);
    }

    @PostMapping("/nested1")
    public Boolean nested1(@RequestBody Test2 entity) {
        return test2Service.nested1(entity);
    }

    @PostMapping("/nested2")
    public Boolean nested2(@RequestBody Test2 entity) {
        return test2Service.nested2(entity);
    }

    @PostMapping("/nested3")
    public Boolean nested3(@RequestBody Test2 entity) {
        return test2Service.nested3(entity);
    }

    @PostMapping("/nested4")
    public Boolean nested4(@RequestBody Test2 entity) {
        return test2Service.nested4(entity);
    }

    @PostMapping("/nested5")
    public Boolean nested5(@RequestBody Test2 entity) {
        return test2Service.nested5(entity);
    }
}
