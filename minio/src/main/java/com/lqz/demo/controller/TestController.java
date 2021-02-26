package com.lqz.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import com.lqz.demo.util.MinioUtil;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/25 17:54
 */
@RestController
public class TestController {

    @Autowired
    private MinioUtil minioUtil;

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException, InvalidResponseException, InvalidKeyException, NoSuchAlgorithmException, InternalException, XmlParserException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException {
        String bucket = minioUtil.listBucketNames().get(0);
        String filename = RandomUtil.randomNumbers(10);
        minioUtil.putObject(bucket, file, filename);
        return filename;
    }

    @PostMapping("/remove")
    public boolean remove(@RequestParam("name") String name) throws IOException, InvalidResponseException, InvalidKeyException, NoSuchAlgorithmException, InternalException, XmlParserException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException {
        String bucket = minioUtil.listBucketNames().get(0);
        boolean rs = minioUtil.removeObject(bucket, name);
        return rs;
    }

    @GetMapping(value = "/get",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] get(@RequestParam("name") String name) throws IOException, InvalidResponseException, InvalidKeyException, NoSuchAlgorithmException, InternalException, XmlParserException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException {
        String bucket = minioUtil.listBucketNames().get(0);
        InputStream is = minioUtil.getObject(bucket, name);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while((rc=is.read(buff, 0, 100))>0) {
            baos.write(buff, 0, rc);
        }
        return baos.toByteArray();
    }

}
