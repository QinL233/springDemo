package com.lqz.demo.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import org.jodconverter.core.DocumentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年12月29日 13:59:00
 */
@Controller
public class ViewController {

    @Value("${view.file.path}")
    private String path;

    @Autowired
    private DocumentConverter converter;

    @Autowired
    private HttpServletResponse response;

    @PostMapping
    public void convert(MultipartFile file) throws Exception {
        String filename = StrUtil.format("{}/{}.pdf",path,IdUtil.fastUUID());
        converter.convert(file.getInputStream()).to(new File(filename)).execute();
        FileInputStream is = new FileInputStream(new File(filename));
        IoUtil.copy(is,response.getOutputStream());
        is.close();
    }

    @GetMapping
    public void pdf(String file) throws Exception {
        String filename = StrUtil.format("{}/{}",path,file);
        FileInputStream is = new FileInputStream(new File(filename));
        IoUtil.copy(is,response.getOutputStream());
        is.close();
    }
}
