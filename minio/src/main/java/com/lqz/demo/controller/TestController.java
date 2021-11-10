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

import javax.servlet.http.HttpServletResponse;
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
        String originalFilename = file.getOriginalFilename();
        String type = originalFilename.substring(originalFilename.indexOf("."));
        String filename = "get/"+RandomUtil.randomNumbers(10)+type;
        minioUtil.putObject(bucket, file, filename);
        return filename;
    }

    @PostMapping("/upload2")
    public String upload2(@RequestParam("dir") String dir,@RequestParam("file") MultipartFile file) throws IOException, InvalidResponseException, InvalidKeyException, NoSuchAlgorithmException, InternalException, XmlParserException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException, RegionConflictException {
        if(!minioUtil.bucketExists(dir)){
            minioUtil.makeBucket(dir);
        }
        String originalFilename = file.getOriginalFilename();
        String type = originalFilename.substring(originalFilename.indexOf("."));
        String filename = RandomUtil.randomNumbers(10)+type;
        minioUtil.putObject(dir, file, filename);
        return filename;
    }

    @PostMapping("/upload3")
    public String upload3(@RequestParam("dir") String dir,@RequestParam("file") MultipartFile file) throws IOException, InvalidResponseException, InvalidKeyException, NoSuchAlgorithmException, InternalException, XmlParserException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException, RegionConflictException {
        if(!minioUtil.bucketExists(dir)){
            minioUtil.makeBucket(dir);
        }
        minioUtil.putObject(dir, file, file.getOriginalFilename());
        return file.getOriginalFilename();
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
        while((rc=is.read(buff))>0) {
            baos.write(buff, 0, rc);
        }
        return baos.toByteArray();
    }

    @GetMapping(value = "/file",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] file(HttpServletResponse response,@RequestParam("name") String name) throws IOException, InvalidResponseException, InvalidKeyException, NoSuchAlgorithmException, InternalException, XmlParserException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException {
        String bucket = minioUtil.listBucketNames().get(0);
        String fileName = name.substring(name.lastIndexOf("/")+1);
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        InputStream is = minioUtil.getObject(bucket, name);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buff = new byte[10000];
        int rc = 0;
        while((rc=is.read(buff))>0) {
            baos.write(buff, 0, rc);
        }
        return baos.toByteArray();
    }

}
