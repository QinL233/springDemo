package com.lqz.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lqz.demo.entity.Detail;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liaoQinZhou
 * @since 2021-02-04
 */
public interface DetailService extends IService<Detail> {

    List<Detail> queryAll();

    boolean upload(MultipartFile file) throws IOException;
}
