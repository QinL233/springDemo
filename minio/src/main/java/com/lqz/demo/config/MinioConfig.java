package com.lqz.demo.config;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/25 17:56
 */
@Configuration
public class MinioConfig {
    @Value("${minio.endpoint}")
    private String endpoint;

    @Value("${minio.port}")
    private int port;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    @Value("${minio.secure}")
    private Boolean secure;

    @Value("${minio.bucketName}")
    private String bucketName;

    @Value("${minio.configDir}")
    private String configDir;

    @Bean
    public MinioClient getMinioClient() throws InvalidEndpointException, InvalidPortException {
        MinioClient minioClient = new MinioClient(endpoint, port, accessKey, secretKey, secure);
        return minioClient;
    }
}
