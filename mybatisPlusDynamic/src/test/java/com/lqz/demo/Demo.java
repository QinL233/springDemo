package com.lqz.demo;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年07月08日 18:31:00
 */
public class Demo {

    @Test
    public void test() throws IOException {
//        String str="2021/6/1,万科南方,鲲鹏-珠海红树东岸,128486761,项目词,4847443537,32,3,2.36,9.38%,0.79,0,0,0,0,0,12";
        String path = "D:\\project\\idea\\ksh_doc\\danyuan_20210526-20210601_30492883_268088.csv";
        BufferedReader reader = IoUtil.getReader(FileUtil.getInputStream(path), "GB2312");
        //跳过前7行
        for (int i = 0; i < 7; i++) {
            reader.readLine();
        }
        StringBuilder builder = new StringBuilder();
        String str;
        long start = System.currentTimeMillis();
        while (StrUtil.isNotBlank(str=reader.readLine())){
//            t1(str,builder);
            t2(str,builder);
        }
        System.out.println((System.currentTimeMillis()-start)+"ms");
//        System.out.println(builder.toString());
    }

    public void t1(String str,StringBuilder builder){
        int splitCount = 0;
        int begin = -1;
        int first = -1;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c == ','){
                splitCount++;
            }
            if(first < 0 && splitCount == 1){
                first = i;
            }
            if(begin <0 && splitCount == 2 ){
                begin = i;
            }
            if(splitCount==3 || splitCount ==5){
                builder.insert(begin,c);
                begin++;
                continue;
            }
            if(splitCount==16){
                builder.insert(first,c);
                first++;
                continue;
            }
            builder.append(c);
        }
    }

    public void t2(String str,StringBuilder builder){
        String[] cell = str.split(",");
        builder.append(cell[0])
                .append(",")
                .append(cell[16])
                .append(",")
                .append(cell[1])
                .append(",")
                .append(cell[3])
                .append(",")
                .append(cell[5])
                .append(",")
                .append(cell[2])
                .append(",")
                .append(cell[4])
                .append(",")
                .append(cell[6])
                .append(",")
                .append(cell[7])
                .append(",")
                .append(cell[8])
                .append(",")
                .append(cell[9])
                .append(",")
                .append(cell[10])
                .append(",")
                .append(cell[11])
                .append(",")
                .append(cell[12])
                .append(",")
                .append(cell[13])
                .append(",")
                .append(cell[14])
                .append(",")
                .append(cell[15])
                .append("\n");
    }
}
