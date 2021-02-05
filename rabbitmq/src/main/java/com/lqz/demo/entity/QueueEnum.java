package com.lqz.demo.entity;


/**
 * 消息队列枚举配置
 * Created by macro on 2018/9/14.
 */
public enum QueueEnum {
    /**
     * 消息通知队列
     */
    QUEUE_TEST_MSG("test.direct", "test.msg", "test.msg"),
    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_TEST_MSG("test.direct.ttl", "test.msg.ttl", "test.msg.ttl");

    /**
     * 交换名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRouteKey() {
        return routeKey;
    }

    public void setRouteKey(String routeKey) {
        this.routeKey = routeKey;
    }
}
