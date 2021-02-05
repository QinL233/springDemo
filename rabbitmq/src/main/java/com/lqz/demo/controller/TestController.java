package com.lqz.demo.controller;

import com.lqz.demo.mq.MqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/5 16:44
 */
@RestController
public class TestController {
    @Autowired
    private MqSender mqSender;

    @GetMapping("/send")
    public String send(@RequestParam String msg, @RequestParam Long delayTimes){
        mqSender.sendMessage(msg,delayTimes);
        return "send success:"+msg;
    }
}
