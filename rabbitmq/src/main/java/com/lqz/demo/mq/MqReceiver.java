package com.lqz.demo.mq;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/5 16:37
 */
@Component
@RabbitListener(queues = "test.msg")
public class MqReceiver {
    private static final Logger logger = LogManager.getLogger(MqReceiver.class);

    @RabbitHandler
    public void handle(String msg) {
        logger.info("receive delay message :{}", msg);
    }
}
