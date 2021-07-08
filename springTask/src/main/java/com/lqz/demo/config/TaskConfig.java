package com.lqz.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * task 配置
 * @author LiaoQinZhou
 * @date: 2021/2/5 11:37
 */
@Configuration
@EnableScheduling
public class TaskConfig {

    private String name;
}
