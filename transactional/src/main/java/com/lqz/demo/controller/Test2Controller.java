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

    @PostMapping("/request1")
    public Boolean request1(@RequestBody Test2 entity) {
        return test2Service.request1(entity);
    }

    @PostMapping("/request2")
    public Boolean request2(@RequestBody Test2 entity) {
        return test2Service.request2(entity);
    }

    @PostMapping("/request3")
    public Boolean request3(@RequestBody Test2 entity) {
        return test2Service.request3(entity);
    }

    @PostMapping("/request4")
    public Boolean request4(@RequestBody Test2 entity) {
        return test2Service.request4(entity);
    }

    @PostMapping("/request5")
    public Boolean request5(@RequestBody Test2 entity) {
        return test2Service.request5(entity);
    }

}
