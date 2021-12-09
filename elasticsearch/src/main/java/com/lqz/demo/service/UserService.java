package com.lqz.demo.service;

import com.lqz.demo.elasticsearch.EsUserRepository;
import com.lqz.demo.entity.UserModel;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/5 14:34
 */
@Service
public class UserService {
    @Autowired
    private EsUserRepository userRepository;


    public Long add(UserModel userModel) {
        userModel.setId(System.currentTimeMillis());
        userRepository.save(userModel);
        return userModel.getId();
    }

    public Boolean remove(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    public Boolean removeAll() {
        userRepository.deleteAll();
        return true;
    }

    public Long save(UserModel userModel) {
        if (Objects.nonNull(userModel.getId()) && userRepository.existsById(userModel.getId())) {
            remove(userModel.getId());
        } else {
            userModel.setId(System.currentTimeMillis());
        }
        userRepository.save(userModel);
        return userModel.getId();
    }

    public UserModel get(Long id) {
        Optional<UserModel> userModel = userRepository.findById(id);
        if (userModel.isPresent()) {
            return userModel.get();
        }
        return null;
    }

    public List<UserModel> list() {
        List<UserModel> list = new ArrayList<>();
        userRepository.findAll().forEach(list::add);
        return list;
    }

    public Page<UserModel> search(String param) {
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.queryStringQuery(param))
                .withPageable(PageRequest.of(0, 10))
                .build();
        Page<UserModel> search = userRepository.search(query);
        return search;
    }
}
