package com.lqz.demo.config;

import org.kurento.client.KurentoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/26 15:16
 */
@Configuration
public class KurentoConfig {

    @Bean
    public KurentoClient kurentoClient() {
        return KurentoClient.create("ws://192.168.110.197:8888/kurento");
    }
}
