package com.lqz.demo.mongo;

import com.lqz.demo.entity.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/5 16:09
 */
@Repository
public interface MgUserRepository extends MongoRepository<UserModel,Long> {
}
