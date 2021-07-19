package com.lqz.demo.config;

import com.mongodb.*;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MongoConfig {

    @Autowired
    private MongoProp mongoProp;

    @Bean(name = "datastore")
    public Datastore datastore() {
        Morphia morphia = new Morphia();
        // .writeConcern(WriteConcern.UNACKNOWLEDGED);// 写入操作不确认，仅可提示网络异常，比ACKNOWLEDGED规则性能高一倍
        // .readPreference(ReadPreference.secondary());// 读写分离，读操作仅通过从属节点
        MongoClientOptions options = MongoClientOptions.builder()
                .writeConcern(WriteConcern.ACKNOWLEDGED)
                .readPreference(ReadPreference.secondary())
                .maxWaitTime(mongoProp.getMaxWaitTime())
                .connectTimeout(mongoProp.getConnectTimeout())
                .socketTimeout(mongoProp.getSocketTimeout())
                .connectionsPerHost(mongoProp.getConnectionsPerHost())
                .build();
        MongoClientOptions.Builder builder = MongoClientOptions.builder(options);

        MongoClient client = new MongoClient(new MongoClientURI(mongoProp.getUri(), builder));
        return morphia.createDatastore(client, mongoProp.getDatabase());
    }

}
