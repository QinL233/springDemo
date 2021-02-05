package com.lqz.demo.service;

import com.lqz.demo.entity.UserModel;
import com.lqz.demo.mongo.MgUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/5 16:11
 */
@Service
public class UserService {
    @Autowired
    private MgUserRepository userRepository;

    public String add(UserModel userModel){
        userModel.setId(System.currentTimeMillis());
        UserModel rs = userRepository.save(userModel);
        return rs.getId().toString();
    }

    public UserModel get(Long id){
        Optional<UserModel> userModel = userRepository.findById(id);
        if(userModel.isPresent()){
            return userModel.get();
        }
        return null;
    }
}
