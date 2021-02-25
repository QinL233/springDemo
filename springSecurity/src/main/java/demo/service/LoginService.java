package demo.service;

import demo.global.Admin;
import demo.utils.JwtTokenUtil;
import demo.vo.CurrentUserDetails;
import demo.vo.Permission;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/4 16:38
 */
@Service
public class LoginService {

    @Autowired
    private JwtTokenUtil tokenUtil;

    public CurrentUserDetails getCurrentUser(String username){
        if(Admin.user.getUsername().equals(username)){
            return Admin.user;
        }
        return null;
    }

    public String login(){
        String token = tokenUtil.generateToken(Admin.user);
        return token;
    }
}
