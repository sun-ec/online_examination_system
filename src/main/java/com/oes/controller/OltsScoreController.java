package com.oes.controller;

import com.oes.model.*;
import com.oes.service.ExaminationSerivce;
import com.oes.service.FspAnswerService;
import com.oes.service.OltsScoreService;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: He Changjie  on  2018-10-05
 * @description: 成绩控制层
 */
@Controller
@RequestMapping("/score")
public class OltsScoreController implements ServletContextAware {

    static org.apache.log4j.Logger logger= Logger.getLogger(OltsScoreController.class);

    @Resource
    OltsScoreService oltsScoreService;

    @Resource
    ExaminationSerivce examinationSerivce;

    @Resource
    FspAnswerService fspAnswerService;

    /**Servlet容器对象，通过 ServletContextAware 接口注入*/
    ServletContext servletContext;

    /**
     * 学生提交考试作答，系统自动计算客观题得分，保存主观题作答
     * @param choiceAnswer 答案字符串(以<>间隔每题作答)
     * @param examNo 试卷编号
     * @param userId 用户编号
     * @return JSP视图
     */
    @RequestMapping("/submit")
    public String objective(@RequestParam String choiceAnswer,@RequestParam String examNo,@RequestParam String userId){
        //查询是否重复提交作答
        OltsScore oltsScore=new OltsScore();
        oltsScore.setExamNo(examNo);
        oltsScore.setUserId(userId);
        OltsScore byExamNoAndUserId = oltsScoreService.findByExamNoAndUserId(oltsScore);

        //重复提交作答
        if(byExamNoAndUserId != null){
            //重复提交作答JSP视图
            return "";
        }else{//非重复提交作答
            //试卷的所有考题内容
            Map<String, List<Object>> queryPaper = examinationSerivce.queryPaper(examNo);
            //试卷单选题
            List<Object> singleList = queryPaper.get("single");
            //试卷多选题
            List<Object> multipleList = queryPaper.get("multiple");
            //试卷判断题
            List<Object> trueFalseList = queryPaper.get("trueFalse");
            //简答题
            List<Object> simpleAnwserList = queryPaper.get("simpleAnwser");
            //编程题
            List<Object> programList = queryPaper.get("program");

            String[] str = choiceAnswer.split("<>");;
            //客观题总得分
            double sum=0.0;
            //题目索引
            int index=0;
            //单选题、多选题model
            SmdOptions smdOptions=null;
            //计算单选题得分
            for (Object o : singleList) {
                smdOptions=(SmdOptions)o;
                if(str[index].equalsIgnoreCase(smdOptions.getSmdQuestions().getCorrect())){
                    sum+=2;
                }
                index++;
            }
            //计算多选题得分
            for (Object o : multipleList) {
                smdOptions=(SmdOptions)o;
                if(str[index].equalsIgnoreCase(smdOptions.getSmdQuestions().getCorrect())){
                    sum+=4;
                }
                index++;
            }
            //判断题model
            SmdQuestions smdQuestions=null;
            //计算判断题得分
            for (Object o : trueFalseList) {
                smdQuestions=(SmdQuestions) o;
                if(str[index].equalsIgnoreCase(smdQuestions.getCorrect())){
                    sum+=2;
                }
                index++;
            }
            //设置客观题成绩
            byExamNoAndUserId.setScore(sum+"");
            //添加一条新的成绩
            oltsScoreService.save(byExamNoAndUserId);

            //作答model
            FspAnswer fspAnswer=new FspAnswer();
            //设置考试编号
            fspAnswer.setExamNo(examNo);
            //设置用户编号
            fspAnswer.setUserId(userId);
            //试题(简答题，编程题)model
            FspQuestions fspQuestions=null;
            //保存主观题作答
            for (Object o : simpleAnwserList) {
                fspQuestions= (FspQuestions) o;
                //试题表(简答题，编程题)编号
                String id = fspQuestions.getId();
                //设置简答题，编程题的题号
                fspAnswer.setFspId(id);
                fspAnswer.setAnswer(str[index]);
                fspAnswerService.save(fspAnswer);
                index++;
            }
            //结束考试JSP视图
            return "";
        }
    }

    /**
     * AJAX计算主观题得分
     * @param id 成绩编号
     * @param scores 老师打分字符串(以,间隔每题得分)
     * @return JSON字符串{"status":"success"}
     */
    @RequestMapping("/subjective")
    @ResponseBody
    public String subjective(String id, String scores){
        double score1,su;
        try {
            String[] scoreArr = scores.split("[,，]");
            //每题得分
            double score=0.0;
            //主观题总得分
            double sum=0.0;
            for (String s : scoreArr) {
                score=Double.valueOf(s);
                sum+=score;
            }
            OltsScore byId = oltsScoreService.findById(id);
            score1= Double.valueOf(byId.getScore());
            su=score1+sum;
            byId.setFspScore(sum+"");
            oltsScoreService.update(byId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            logger.warn("AJAX计算主观题得分失败");
            return "{\"status\":false}";
        }
        return "{\"status\":true,\"score\":"+su+"}";
    }

    /**
     * 显示成绩页面
     * 向modelMap中添加了List<List<String>> scoreList用于页面显示
     * 单行list内容：成绩编号 | 姓名 | 成绩 | 性别 | 在读/毕业院校 | 专业 | 最高学历
     * @param modelMap modelMap对象
     * @return JSP视图
     */
    @RequestMapping("/query")
    public String query( ModelMap modelMap){
        String examNo= (String) servletContext.getAttribute("exam");
        //该堂考试所有学生成绩list
        List<OltsScore> oltsScoreList = oltsScoreService.findByExamNo(examNo);
        //存入modelMap中所需list
        List<List<String>> scoreList=new ArrayList<>();

        List<String> list=null;
        //学生model
        OltsUsers oltsUsers=null;
        for (OltsScore oltsScore : oltsScoreList) {
            list=new ArrayList<>();
            //成绩编号 | 姓名 | 成绩 | 性别 | 在读/毕业院校 | 专业 | 最高学历
            list.add(oltsScore.getId());
            list.add(oltsScore.getOltsUsers().getUserName());
            list.add((Double.valueOf(oltsScore.getScore())+Double.valueOf(oltsScore.getFspScore()))+"");
            list.add(oltsScore.getOltsUsers().getGender());
            list.add(oltsScore.getOltsUsers().getGraduateSchool());
            list.add(oltsScore.getOltsUsers().getMarjor());
            list.add(oltsScore.getOltsUsers().getEduBackground());

            scoreList.add(list);
        }
        modelMap.addAttribute("scoreList",scoreList);
        //JSP视图
        return "forward:/resultsView.jsp";
    }


    /**
     * AJAX删除学生成绩
     * @param id 成绩编号
     * @return JSON
     */
    @ResponseBody
    @RequestMapping("/deleteScore")
    public String deleteScore(String id){
        try {
            oltsScoreService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("AJAX删除学生成绩失败！");
            return "{\"status\":false}";
        }
        return "{\"status\":true}";
    }

    /**
     * 将页面<input type="file">所选择的excel文件读入内存，再插入新的学生成绩数据，再返回一个新的excel文件供老师下载
     * @param excelFile 页面<input type="file" name="excelFile">所选择的excel文件
     * @param servletResponse 响应
     */
    @RequestMapping("/export")
    public void export(@RequestParam CommonsMultipartFile excelFile, HttpServletResponse servletResponse){
        String examNo= (String) servletContext.getAttribute("exam");
        //得到文件上传的目标目录
        String tempDirectory = servletContext.getRealPath("/temp/");
        // 上传的原文件名称
        String originalFilename = excelFile.getOriginalFilename();
        //输出流
        ServletOutputStream sos=null;
        //该堂考试的所有学生成绩list
        List<OltsScore> oltsScoreList = oltsScoreService.findByExamNo(examNo);
        //日期格式化
        SimpleDateFormat sdf=new SimpleDateFormat("MM月dd日");
        //将要插入到excel的数据
        Map<String,String> map=new HashMap<>();
        //考试时间
        Date testDate1 = oltsScoreList.get(0).getTestDate();
        if(testDate1 == null){
            testDate1=new Date();
        }
        String testDate = sdf.format(testDate1);
        //向map插入考试时间
        map.put("testDate",testDate);
        //成绩
        double score=0.0;
        //向map插入考试成绩（"学生姓名",成绩）
        for (OltsScore oltsScore : oltsScoreList) {
            score=Double.valueOf(oltsScore.getScore())+Double.valueOf(oltsScore.getFspScore());
            map.put(oltsScore.getOltsUsers().getUserName(),score+"");
        }

        try {
            //将excelFile转化为输入流
            InputStream is = excelFile.getInputStream();
            //创建工作簿
            Workbook workbook=new HSSFWorkbook(is);
            //得到工作簿第二个工作表
            Sheet sheet=workbook.getSheetAt(1);
            //第一个空列的索引
            int column=2;
            //根据第二行判断哪一列为空值
            Row row1 = sheet.getRow(1);
            for (int i=2;i<row1.getPhysicalNumberOfCells();i++) {
                String tempstr=POIUtils.getValue(row1.getCell(i));
                if(tempstr!=null && tempstr.length()==0){
                    column=i;
                    break;
                }
            }
            //设置excel的考试场次
            row1.getCell(column).setCellValue(map.get("testDate")+"考试成绩");
            //获得总行数
            int rowNum = sheet.getLastRowNum();
            rowNum++;
            //向xls插入成绩
            for(int i=2;i<rowNum;i++){
                Row row = sheet.getRow(i);
                String userName = POIUtils.getValue(row.getCell(1));
                if(map.containsKey(userName)){
                    Cell cell = row.getCell(column);
                    String s = map.get(userName);
                    cell.setCellValue(s);
                }
            }
            FileOutputStream fileOut = new FileOutputStream(tempDirectory+originalFilename);
            //写入文件
            workbook.write(fileOut);

            servletResponse.reset();
            //设置下载文件的头部信息， 以附件的形式下载filename为客户端弹出的下载框中的默认文件名
            servletResponse.setHeader("Content-type", "application/vnd.ms-excel");
            servletResponse.setHeader("Content-Disposition", "attachment; filename="
                    + new String(originalFilename.getBytes("gb2312"), "ISO8859-1")
                    + ".xls");
            // 将文件 读成字节数组
            byte[] buf = FileUtils.readFileToByteArray(new File(tempDirectory+originalFilename));
            sos = servletResponse.getOutputStream();
            sos.write(buf);
        } catch (IOException e) {
            e.printStackTrace();
            logger.warn("IO流异常");
        }finally {
            try {
                sos.close();
            } catch (IOException e) {
                e.printStackTrace();
                logger.warn("ServletOutputStream流关闭异常");
            }
        }
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
