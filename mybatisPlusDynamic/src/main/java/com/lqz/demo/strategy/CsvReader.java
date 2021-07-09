package com.lqz.demo.strategy;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import com.lqz.demo.util.DorisStreamLoad;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年07月08日 16:10:00
 */
@Service("csv")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CsvReader implements ReaderStrategy {

    private final DorisStreamLoad dorisStreamLoad;

    @Override
    public void read(MultipartFile file){
        try (BufferedReader reader = IoUtil.getReader(file.getInputStream(), "GB2312")){
            //跳过前7行
            for (int i = 0; i < 7; i++) {
                reader.readLine();
            }
            StringBuilder builder = new StringBuilder();
            String str;
            long start = System.currentTimeMillis();
            while (StrUtil.isNotBlank(str = reader.readLine())) {
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
            System.out.println((System.currentTimeMillis()-start)+"ms");
            builder.deleteCharAt(builder.length() - 1);
            dorisStreamLoad.sendData(builder.toString(), "detail");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
