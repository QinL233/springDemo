package com.lqz.demo.elasticsearch;

import com.lqz.demo.entity.UserModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/5 14:31
 */
@Repository
public interface EsUserRepository extends ElasticsearchRepository<UserModel,Long> {
}
