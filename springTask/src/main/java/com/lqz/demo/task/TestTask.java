package com.lqz.demo.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/5 11:36
 */
@Component
public class TestTask {
    private static final Logger logger = LogManager.getLogger(TestTask.class);

    /**
     * cron表达式：Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
     */
    @Scheduled(cron = "0/10 * * * * ?")
    private void cancelTimeOutOrder() {
        System.out.println("test");
        logger.info("test");
    }
}
