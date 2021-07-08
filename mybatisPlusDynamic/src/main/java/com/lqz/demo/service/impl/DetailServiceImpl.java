package com.lqz.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lqz.demo.entity.Detail;
import com.lqz.demo.mapper.DetailMapper;
import com.lqz.demo.service.DetailService;
import com.lqz.demo.strategy.ExcelHandler;
import com.lqz.demo.util.DorisStreamLoad;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年07月07日 17:57:00
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DetailServiceImpl extends ServiceImpl<DetailMapper, Detail> implements DetailService {
    private final DorisStreamLoad dorisStreamLoad;

    private final ExcelHandler excelHandler;

    @Override
    public List<Detail> queryAll() {
        return list();
    }

    @Override
    public boolean upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String type = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        excelHandler.execute(type, file.getInputStream());
        return true;
    }

}
