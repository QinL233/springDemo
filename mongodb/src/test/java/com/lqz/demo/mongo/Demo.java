package com.lqz.demo.mongo;

import com.lqz.demo.entity.AndroidData;
import com.lqz.demo.entity.UserModel;
import com.mongodb.*;
import dev.morphia.Datastore;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年07月13日 09:34:00
 */
@SpringBootTest
public class Demo {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private Datastore datastore;

    @Test
    public void insert() {
        BulkOperations operations = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, UserModel.class);
        operations.insert(new UserModel(1L, "test"));
        operations.insert(new UserModel(2L, "root"));
        operations.insert(new UserModel(3L, "admin"));

//        BulkWriteResult result = operations.execute();
//        System.out.println(result);
    }

    @Test
    public void update() {
        Update u1 = new Update().set("name", "test1");
        Query q1 = new Query(Criteria.where("id").is(1L));
        Update u2 = new Update().set("name", "admin2");
        Query q2 = new Query(Criteria.where("id").is(3L));

        BulkOperations ops = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, UserModel.class);

        ops.updateOne(q1, u1);

        ops.updateOne(q2, u2);

        ops.execute();
    }

    @Test
    public void test() {
        DBCollection coll = datastore.getCollection(UserModel.class);
        BulkWriteOperation bulk = coll.initializeUnorderedBulkOperation();
//        bulk.find(new BasicDBObject("id", 2)).upsert().update(new BasicDBObject("$inc", new BasicDBObject("id",2)));
//        bulk.find(new BasicDBObject("_id", new ObjectId("60ef94b3f2395964a369be29"))).upsert().update(new BasicDBObject("$set", new BasicDBObject("name", "ad3123123min112")));
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("name", "3333");
        basicDBObject.put("id", 4444);
//        bulk.find(new BasicDBObject("_id", 2)).upsert().update(new BasicDBObject("$set",basicDBObject ));
        bulk.find(new BasicDBObject("_id", 2)).update(new BasicDBObject("$set",basicDBObject ));
        bulk.find(new BasicDBObject("_id", 3)).upsert().update(new BasicDBObject("$set",basicDBObject ));
//        bulk.find(new BasicDBObject("id", 3)).upsert().update(new BasicDBObject("$set", new BasicDBObject("name", "admin3")));
//        bulk.find(new BasicDBObject("id", 4)).upsert().update(new BasicDBObject("$set", new BasicDBObject("name", "admin4")));
//        bulk.find(new BasicDBObject("id", 5)).upsert().update(new BasicDBObject("$set", new BasicDBObject("name", "admin5")));
//        bulk.find(new BasicDBObject("id", 6)).upsert().update(new BasicDBObject("$set", new BasicDBObject("name", "admin6")));
//        bulk.find(new BasicDBObject("id", 7)).upsert().update(new BasicDBObject("$set", new BasicDBObject("name", "admin7")));
        BulkWriteResult execute = bulk.execute();
        System.out.println(execute);
    }

    @Test
    public void test2() {
        DBCollection coll = datastore.getCollection(AndroidData.class);
        BulkWriteOperation bulk = coll.initializeUnorderedBulkOperation();
        BasicDBObject basicDBObject = new BasicDBObject();
//        basicDBObject.put("type", "手游经典111");
//        basicDBObject.put("sort", 4444);
        basicDBObject.put("type", "手游经典");
        basicDBObject.put("sort", 15);
//        bulk.find(new BasicDBObject("gameName", "全民奇迹")).upsert().update(new BasicDBObject("$set",basicDBObject ));
        BulkWriteRequestBuilder builder = bulk.find(new BasicDBObject("_id", new ObjectId("60e8124cdd0a040eb59c9f81")));
        builder.upsert().update(new BasicDBObject("$set",basicDBObject ));
        BulkWriteResult execute = bulk.execute();
        System.out.println(execute);
    }


}
