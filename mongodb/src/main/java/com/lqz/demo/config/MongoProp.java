package com.lqz.demo.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "mongo")
public class MongoProp {

    private String uri;

    private String host ;

    private Integer port;

    private String username;

    private String password;

    private String database;

    private int threadsAllowed;

    private int connectionsPerHost;

    private int maxWaitTime;

    private int connectTimeout;

    private int socketTimeout;
}
