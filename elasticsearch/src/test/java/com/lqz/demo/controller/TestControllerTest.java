package com.lqz.demo.controller;

import com.lqz.demo.entity.PermissionModel;
import com.lqz.demo.entity.UserModel;
import com.lqz.demo.service.UserService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年12月09日 09:08:00
 */
@SpringBootTest
public class TestControllerTest {

    @Autowired
    private UserService userService;


    @Test
    public void add() {
        UserModel userModel = new UserModel();
        userModel.setKeyword("admin");
        userModel.setText("小薇是一家科技公司的前台，开的汽车是保时捷911");
        PermissionModel permissionModel = new PermissionModel();
        permissionModel.setName("manager");
        userModel.setPermissions(Lists.newArrayList(permissionModel));
        Long id = userService.add(userModel);
        System.out.println(id);
    }

    @Test
    public void remove() {
        userService.remove(1639012386171l);
    }

    @Test
    public void removeAll() {
        userService.removeAll();
    }

    @Test
    public void save() {
        UserModel userModel = new UserModel();
        userModel.setKeyword("test2");
        userModel.setText("小俊是一家科技公司创始人，开的汽车是奥迪a8l，加速爽。");
        PermissionModel permissionModel = new PermissionModel();
        permissionModel.setName("test2");
        userModel.setPermissions(Lists.newArrayList(permissionModel));
        Long id = userService.save(userModel);
        System.out.println(id);
    }

    @Test
    public void get() {
        UserModel model = userService.get(1639013268729l);
        System.out.println(model);
    }
    @Test
    public void list() {
        List<UserModel> list = userService.list();
        System.out.println(list);
    }
    @Test
    public void search(){
        Page<UserModel> models = userService.search("汽车公司");
        if(models.getTotalPages() > 0 ){
            List<UserModel> content = models.getContent();
            content.forEach(c->{
                System.out.println(c);
            });
        }
    }
}
