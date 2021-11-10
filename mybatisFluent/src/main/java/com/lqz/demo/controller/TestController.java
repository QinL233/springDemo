package com.lqz.demo.controller;

import com.lqz.demo.dao.intf.DataSignOrderDetailTempDao;
import com.lqz.demo.entity.SumByDeptWithSign;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年11月10日 15:24:00
 */
@Api(tags = "test")
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class TestController {

    private final DataSignOrderDetailTempDao dataSignOrderDetailTempDao;

    @GetMapping("/sum")
    public List<SumByDeptWithSign> sum() {
        return dataSignOrderDetailTempDao.sum();
    }
}
