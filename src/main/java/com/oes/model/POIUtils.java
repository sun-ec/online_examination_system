package com.oes.model;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.commons.io.IOUtils;
import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
public class POIUtils {

    private static Logger logger= Logger.getLogger(POIUtils.class);

    /**
     * POI方式解析EXCEL表格，将其全部的单元格转化为List形式存储
     *  例如：
     *  list=readExcel(is,0);
     * @param is Excel工作簿的输入流
     * @param sheetNo 第几个工作表,索引从0开始
     * @return 包含工作簿的第sheetNo工作表的全部信息的List
     */
    public static List<List<String>> readExcel(InputStream is,int sheetNo){
        List<List<String>> excelList=new ArrayList<>();
        List<String> list=null;
        try {
            //创建工作簿
            Workbook workbook=new HSSFWorkbook(is);
            //得到工作簿第一个工作表
            Sheet sheet=workbook.getSheetAt(sheetNo);
            //遍历行
            for (Row row:sheet) {
                list=new ArrayList<>();
                //遍历列
                for (Cell cell : row) {
                    list.add(getValue(cell));
                }
                excelList.add(list);
            }

            return excelList;
        } catch (FileNotFoundException e) {
            logger.warn("找不到XLS文件");
            e.printStackTrace();
        } catch (IOException e) {
            logger.warn("创建工作簿异常");
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取单元格的值
     * @param cell 单元格
     * @return 单元格的值
     */
    public static String getValue(Cell cell) {
        if(cell == null){
            return "";
        }
        String  val = null;
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        DecimalFormat df = new DecimalFormat("0");
        switch (cell.getCellTypeEnum()) {
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    //日期型
                    val = fmt.format(cell.getDateCellValue());
                } else {
                    //数字型
                    val = df.format(cell.getNumericCellValue());
                }
                break;
            //文本类型
            case STRING:
                val = cell.getStringCellValue();
                break;
            //布尔型
            case BOOLEAN:
                val = String.valueOf(cell.getBooleanCellValue());
                break;
            //空白
            case BLANK:
                val = cell.getStringCellValue();
                break;
            //错误
            case ERROR:
                val = "错误";
                break;
            //公式
            case FORMULA:
                try {
                    val = String.valueOf(cell.getStringCellValue());
                } catch (IllegalStateException e) {
                    val = cell.getCellFormula();
                }
                break;
            default:
                val = cell.getRichStringCellValue() == null ? null : cell.getRichStringCellValue().toString();
        }
        return val;
    }

}
