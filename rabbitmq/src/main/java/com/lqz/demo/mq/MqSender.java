package com.lqz.demo.mq;

import com.lqz.demo.entity.QueueEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/5 16:37
 */
@Component
public class MqSender {

    private static final Logger logger = LogManager.getLogger(MqSender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(String msg, final long delayTimes) {
        //给延迟队列发送消息
        amqpTemplate.convertAndSend(
                QueueEnum.QUEUE_TTL_TEST_MSG.getExchange(), QueueEnum.QUEUE_TTL_TEST_MSG.getRouteKey(),
                msg,
                new MessagePostProcessor() {
                    @Override
                    public Message postProcessMessage(Message message) throws AmqpException {
                        //给消息设置延迟毫秒值
                        message.getMessageProperties().setExpiration(String.valueOf(delayTimes));
                        return message;
                    }
                });
        logger.info("send delay message:{}", msg);
    }
}
