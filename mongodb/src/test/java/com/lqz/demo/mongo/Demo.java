package com.lqz.demo.mongo;

import com.lqz.demo.entity.UserModel;
import com.mongodb.bulk.BulkWriteResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

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

    @Test
    public void insert() {
        BulkOperations operations = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, UserModel.class);
        operations.insert(new UserModel(1L, "test"));
        operations.insert(new UserModel(2L, "root"));
        operations.insert(new UserModel(3L, "admin"));
        BulkWriteResult result = operations.execute();
        System.out.println(result);
    }
    @Test
    public void update() {
        Update u1 = new Update().set("name","test1");
        Query q1 = new Query(Criteria.where("id").is(1L));
        Update u2 = new Update().set("name","admin2");
        Query q2 = new Query(Criteria.where("id").is(3L));

        BulkOperations ops = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, UserModel.class);
        ops.updateOne(q1,u1);
        ops.updateOne(q2,u2);
        ops.execute();
    }


}
