package com.lqz.demo.strategy;

import cn.hutool.core.lang.Console;
import cn.hutool.poi.excel.sax.Excel07SaxReader;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年07月08日 15:30:00
 */
@Service("xlsx")
public class XlsxReader implements ReaderStrategy {

    @Override
    public void read(InputStream is){
        Excel07SaxReader reader = new Excel07SaxReader((sheetIndex, rowIndex, rowList)-> {
            Console.log("[{}] [{}] {}", sheetIndex, rowIndex, rowList);
        });
        reader.read(is, -1);
    }
}
