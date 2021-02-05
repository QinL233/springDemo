package com.lqz.demo.service;

import com.lqz.demo.elasticsearch.EsUserRepository;
import com.lqz.demo.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/5 14:34
 */
@Service
public class UserService {
    @Autowired
    private EsUserRepository userRepository;

    public List<UserModel> list(){
        List<UserModel> list = new ArrayList<>();
        userRepository.findAll().forEach(list::add);
        return list;
    }

    public Long add(UserModel userModel){
        long id = System.currentTimeMillis();
        userModel.setId(id);
        userRepository.save(userModel);
        return id;
    }

    public UserModel get(Long id){
        Optional<UserModel> userModel = userRepository.findById(id);
        if(userModel.isPresent()){
            return userModel.get();
        }
        return null;
    }
}
