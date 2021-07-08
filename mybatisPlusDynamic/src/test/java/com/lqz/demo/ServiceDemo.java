package com.lqz.demo;

import com.lqz.demo.entity.Detail;
import com.lqz.demo.entity.SysUser;
import com.lqz.demo.service.DetailService;
import com.lqz.demo.service.SysUserService;
import com.lqz.demo.util.DorisStreamLoad;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年07月07日 17:36:00
 */
@SpringBootTest
public class ServiceDemo {

    @Autowired
    private SysUserService userService;
    @Autowired
    private DetailService detailService;
    @Autowired
    private DorisStreamLoad dorisStreamLoad;

    @Test
    public void userTest() {
        List<SysUser> users = userService.queryAll();
        System.out.println(users);
    }

    @Test
    public void detailTest(){
        List<Detail> details = detailService.queryAll();
        System.out.println(details);
    }

    @Test
    public void sendData(){
//        String msg = "2021/6/1,0,万科南方,128486761,4847443537,鲲鹏-珠海红树东岸,项目词,32,3,2.36,9.38%,0.79,0,0,0,0,0\n" +
//                "2021/6/1,1,万科南方,128486761,4847443537,鲲鹏-珠海红树东岸,项目词,15,0,0,0.00%,0,0,0,0,0,0";
        String msg = "128486761,鲲鹏,珠海红树东岸,,";
        try {
            dorisStreamLoad.sendData(msg,"detail_plan");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sendCsv(){
        String file = "D:\\project\\idea\\ksh_doc\\test.csv";
        try {
            dorisStreamLoad.sendCsv(file,"detail");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
