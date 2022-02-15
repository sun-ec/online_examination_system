package com.oes.service;

import com.oes.model.POIUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PoiTest {

    @Test
    public void readXlsTest() throws FileNotFoundException {
        FileInputStream is=new FileInputStream("F:\\蓝桥学院\\JAVA后端\\阶段项目\\olts\\docs\\20160511_西华大学_考试成绩_模板.xls");
        List<List<String>> readExcel = POIUtils.readExcel(is, 1);
        for (List<String> list : readExcel) {
            System.out.println("该行共"+list.size()+"单元格=>");
            for (String s : list) {
                System.out.print("["+s+"]\t");
            }
            System.out.println();
        }
    }

    @Test
    public void Test(){
        String singleId="1,2,412,3,43,22,4,5,6,7,8,9";
        String single=",4,";
        System.out.println(StringUtils.substringBefore(singleId, single)+","+StringUtils.substringAfter(singleId, single));

    }
}
