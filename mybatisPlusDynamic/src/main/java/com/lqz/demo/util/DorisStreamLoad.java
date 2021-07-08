package com.lqz.demo.util;

// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

import cn.hutool.core.io.FileUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * This class is a java demo for doris stream load
 * <p>
 * The pom.xml dependency:
 *
 * <dependency>
 * <groupId>org.apache.httpcomponents</groupId>
 * <artifactId>httpclient</artifactId>
 * <version>4.5.3</version>
 * </dependency>
 * <p>
 * How to use:
 * <p>
 * 1 create a table in doris with any mysql client
 * <p>
 * CREATE TABLE `stream_test` (
 * `id` bigint(20) COMMENT "",
 * `id2` bigint(20) COMMENT "",
 * `username` varchar(32) COMMENT ""
 * ) ENGINE=OLAP
 * DUPLICATE KEY(`id`)
 * DISTRIBUTED BY HASH(`id`) BUCKETS 20;
 * <p>
 * <p>
 * 2 change the Doris cluster, db, user config in this class
 * <p>
 * 3 run this class, you should see the following output:
 * <p>
 * {
 * "TxnId": 27,
 * "Label": "39c25a5c-7000-496e-a98e-348a264c81de",
 * "Status": "Success",
 * "Message": "OK",
 * "NumberTotalRows": 10,
 * "NumberLoadedRows": 10,
 * "NumberFilteredRows": 0,
 * "NumberUnselectedRows": 0,
 * "LoadBytes": 50,
 * "LoadTimeMs": 151
 * }
 * <p>
 * Attention:
 * <p>
 * 1 wrong dependency version(such as 4.4) of httpclient may cause shaded.org.apache.http.ProtocolException
 * Caused by: shaded.org.apache.http.ProtocolException: Content-Length header already present
 * at shaded.org.apache.http.protocol.RequestContent.process(RequestContent.java:96)
 * at shaded.org.apache.http.protocol.ImmutableHttpProcessor.process(ImmutableHttpProcessor.java:132)
 * at shaded.org.apache.http.impl.execchain.ProtocolExec.execute(ProtocolExec.java:182)
 * at shaded.org.apache.http.impl.execchain.RetryExec.execute(RetryExec.java:88)
 * at shaded.org.apache.http.impl.execchain.RedirectExec.execute(RedirectExec.java:110)
 * at shaded.org.apache.http.impl.client.InternalHttpClient.doExecute(InternalHttpClient.java:184)
 * <p>
 * 2 run this class more than once, the status code for http response is still ok, and you will see
 * the following output:
 * <p>
 * {
 * "TxnId": -1,
 * "Label": "39c25a5c-7000-496e-a98e-348a264c81de",
 * "Status": "Label Already Exists",
 * "ExistingJobStatus": "FINISHED",
 * "Message": "Label [39c25a5c-7000-496e-a98e-348a264c81de"] has already been used.",
 * "NumberTotalRows": 0,
 * "NumberLoadedRows": 0,
 * "NumberFilteredRows": 0,
 * "NumberUnselectedRows": 0,
 * "LoadBytes": 0,
 * "LoadTimeMs": 0
 * }
 * 3 when the response statusCode is 200, that doesn't mean your stream load is ok, there may be still
 * some stream problem unless you see the output with 'ok' message
 */
@Component
public class DorisStreamLoad {
    @Value("${doris.http.host}")
    private String DORIS_HOST;
    @Value("${doris.http.port}")
    private int DORIS_HTTP_PORT;
    @Value("${doris.http.dbname}")
    private String DORIS_DB;
    @Value("${doris.http.username}")
    private String DORIS_USER;
    @Value("${doris.http.password}")
    private String DORIS_PASSWORD;

    public void sendData(String content,String table) throws Exception {
        final String loadUrl = String.format("http://%s:%s/api/%s/%s/_stream_load",
                DORIS_HOST,
                DORIS_HTTP_PORT,
                DORIS_DB,
                table);

        final HttpClientBuilder httpClientBuilder = HttpClients
                .custom()
                .setRedirectStrategy(new DefaultRedirectStrategy() {
                    @Override
                    protected boolean isRedirectable(String method) {
                        return true;
                    }
                });

        try (CloseableHttpClient client = httpClientBuilder.build()) {
            HttpPut put = new HttpPut(loadUrl);
            StringEntity entity = new StringEntity(content, "UTF-8");
            put.setHeader(HttpHeaders.EXPECT, "100-continue");
            put.setHeader(HttpHeaders.AUTHORIZATION, basicAuthHeader(DORIS_USER, DORIS_PASSWORD));
            put.setHeader("label", UUID.randomUUID().toString());
            put.setHeader("column_separator", ",");
            put.setEntity(entity);

            try (CloseableHttpResponse response = client.execute(put)) {
                String loadResult = "";
                if (response.getEntity() != null) {
                    loadResult = EntityUtils.toString(response.getEntity());
                }
                final int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode != 200) {
                    throw new IOException(
                            String.format("Stream load failed, statusCode=%s load result=%s", statusCode, loadResult));
                }

                System.out.println(loadResult);
            }
        }
    }

    public void sendCsv(String file,String table) throws Exception {
        final String loadUrl = String.format("http://%s:%s/api/%s/%s/_stream_load",
                DORIS_HOST,
                DORIS_HTTP_PORT,
                DORIS_DB,
                table);

        final HttpClientBuilder httpClientBuilder = HttpClients
                .custom()
                .setRedirectStrategy(new DefaultRedirectStrategy() {
                    @Override
                    protected boolean isRedirectable(String method) {
                        return true;
                    }
                });

        try (CloseableHttpClient client = httpClientBuilder.build()) {
            HttpPut put = new HttpPut(loadUrl);
            FileEntity entity = new FileEntity(FileUtil.file(file));
            put.setHeader(HttpHeaders.EXPECT, "100-continue");
            put.setHeader(HttpHeaders.AUTHORIZATION, basicAuthHeader(DORIS_USER, DORIS_PASSWORD));
            put.setHeader("label", UUID.randomUUID().toString());
            put.setHeader("column_separator", ",");
            put.setEntity(entity);

            try (CloseableHttpResponse response = client.execute(put)) {
                String loadResult = "";
                if (response.getEntity() != null) {
                    loadResult = EntityUtils.toString(response.getEntity());
                }
                final int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode != 200) {
                    throw new IOException(
                            String.format("Stream load failed, statusCode=%s load result=%s", statusCode, loadResult));
                }

                System.out.println(loadResult);
            }
        }
    }

    private String basicAuthHeader(String username, String password) {
        final String tobeEncode = username + ":" + password;
        byte[] encoded = Base64.encodeBase64(tobeEncode.getBytes(StandardCharsets.UTF_8));
        return "Basic " + new String(encoded);
    }
}