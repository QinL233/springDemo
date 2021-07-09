package com.lqz.demo.strategy;

import cn.hutool.poi.excel.sax.Excel03SaxReader;
import com.lqz.demo.util.DorisStreamLoad;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年07月08日 16:11:00
 */
@Service("xls")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class XlsReader implements ReaderStrategy {

    private final DorisStreamLoad dorisStreamLoad;

    @Override
    public void read(MultipartFile file) {
        try {
            StringBuilder builder = new StringBuilder();
            long start = System.currentTimeMillis();
            new Excel03SaxReader((sheetIndex, rowIndex, rowList) -> {
                if (rowIndex > 7) {
                    builder.append(rowList.get(0))
                            .append(",")
                            .append(rowList.get(16))
                            .append(",")
                            .append(rowList.get(1))
                            .append(",")
                            .append(rowList.get(3))
                            .append(",")
                            .append(rowList.get(5))
                            .append(",")
                            .append(rowList.get(2))
                            .append(",")
                            .append(rowList.get(4))
                            .append(",")
                            .append(rowList.get(6))
                            .append(",")
                            .append(rowList.get(7))
                            .append(",")
                            .append(rowList.get(8))
                            .append(",")
                            .append(rowList.get(9))
                            .append(",")
                            .append(rowList.get(10))
                            .append(",")
                            .append(rowList.get(11))
                            .append(",")
                            .append(rowList.get(12))
                            .append(",")
                            .append(rowList.get(13))
                            .append(",")
                            .append(rowList.get(14))
                            .append(",")
                            .append(rowList.get(15))
                            .append("\n");
                }
            }).read(file.getInputStream(), -1);
            System.out.println((System.currentTimeMillis()-start)+"ms");
            builder.deleteCharAt(builder.length() - 1);
            dorisStreamLoad.sendData(builder.toString(), "detail");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
