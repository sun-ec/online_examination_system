package com.oes.controller;

import com.github.pagehelper.Page;
import com.oes.model.*;
import com.oes.service.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: He Changjie  on  2018-10-05
 * @description: 试题控制器
 * 还未完成的功能：
 *      为试卷添加单选题、多选题、判断题、简答题、编程题
 */
@Controller
@RequestMapping("/test")
public class TestController implements ServletContextAware {
    @Resource
    FspQuestionsService fspQuestionsService;
    @Resource
    SmdQuestionsService smdQuestionsService;
    @Resource
    SmdOptionsService smdOptionsService;
    @Resource
    ExaminationSerivce examinationSerivce;
    @Resource
    OltsUsersService oltsUsersService;
    @Resource
    FspAnswerService fspAnswerService;
    @Resource
    OltsScoreService oltsScoreService;
    @Resource
    TechCategoryService techCategoryService;

    /**Servlet容器对象，通过 ServletContextAware 接口注入*/
    ServletContext servletContext;

    static Logger logger= Logger.getLogger(TestController.class);

    /**
     * AJAX通过课程编号查询所属知识点
     * @param courId 课程编号
     * @return 所属知识点List
     */
    @ResponseBody
    @RequestMapping("/queryTech")
    public List<TechCategory> queryTech(@RequestParam String courId){
        return techCategoryService.findByCourId(courId);
    }

    /**
     * 试题新增-添加单选题/多选题
     * @param smdQuestions 试题表(单选题，多选)
     * @param smdOptions 单选、多选题选项表
     * @param type 1为单选，2为多选
     * @return JSP视图
     */
    @RequestMapping("/addChoice{type}")
    public String addChoice(SmdQuestions smdQuestions, SmdOptions smdOptions,@PathVariable String type){
        try {
            smdQuestions.setQuestionType(type);
            smdQuestionsService.save(smdQuestions);
            smdOptions.setQuestionId(smdQuestions.getId());
            smdOptionsService.save(smdOptions);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("试题新增-添加单选题/多选题失败！");
            //添加失败，返回到原添加的JSP视图
            if("1".equals(type)){
                return "forward:/addSingleChoiceForm.jsp?status=false";
            }else{
                return "forward:/addMultipleChoiceForm.jsp?status=false";
            }
        }
        if("1".equals(type)){
            return "forward:/addSingleChoiceForm.jsp?status=true";
        }else{
            return "forward:/addMultipleChoiceForm.jsp?status=true";
        }
        //添加成功，返回到原添加的JSP视图
    }

    /**
     * 试题新增-添加判断题
     * @param smdQuestions 试题表(判断题)
     * @return JSP视图
     */
    @RequestMapping("/addTrueFalse")
    public String addTrueFalse(SmdQuestions smdQuestions){
        try {
            smdQuestions.setQuestionType("3");
            smdQuestionsService.save(smdQuestions);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("试题新增-添加判断题失败！");
            //添加失败，返回到原添加的JSP视图
            return "forward:/addJudgeForm.jsp?status=false";
        }
        //添加成功，返回到原添加的JSP视图
        return "forward:/addJudgeForm.jsp?status=true";
    }

    /**
     * 试题新增-添加简答题/编程题
     * @param fspQuestions 试题表(简答题，编程题)
     * @param type 4为简答题，5为编程题
     * @return JSP视图
     */
    @RequestMapping("/addSimpleAnwser{type}")
    public String addSimpleAnwser(FspQuestions fspQuestions,@PathVariable String type){
        try {
            fspQuestions.setQuestionType(type);
            fspQuestionsService.save(fspQuestions);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("试题新增-添加简答题/编程题失败！");
            //添加失败，返回到原添加的JSP视图
            if("4".equals(type)){
                return "forward:/addShortAnswerForm.jsp?status=false";
            }else{
                return "forward:/addProgrammingForm.jsp?status=false";
            }
        }
        //添加成功，返回到原添加的JSP视图
        if("4".equals(type)){
            return "forward:/addShortAnswerForm.jsp?status=true";
        }else{
            return "forward:/addProgrammingForm.jsp?status=true";
        }
    }



    /**
     * 试题查询-分页查询单选题/多选题
     * @param smdQuestions 试题（单选题,多选题）
     * @param pageNum 当前页号
     * @param type 试题类型
     * @param modelMap modelMap对象
     * @return JSP视图
     */
    @RequestMapping("/queryChoice{type}")
    public String queryChoice(SmdQuestions smdQuestions,Integer pageNum,@PathVariable String type,ModelMap modelMap){
        SmdOptions smdOptions=new SmdOptions();
        smdQuestions.setQuestionType(type);
        smdOptions.setSmdQuestions(smdQuestions);

        Page<SmdOptions> page=null;
        if(pageNum == null){
            page= (Page<SmdOptions>) smdOptionsService.selectByPage(smdOptions,1,5);
        }else{
            page= (Page<SmdOptions>) smdOptionsService.selectByPage(smdOptions,pageNum,5);
        }
        List<Examination> allExamNo = examinationSerivce.findAllExamNo();
        List<String> list=new ArrayList<>();
        for (Examination examination : allExamNo) {
            list.add(examination.getExamNo());
        }
        modelMap.addAttribute("examNo",list);
        modelMap.addAttribute("page",page);
        if("1".equals(type)){
            //添加成功，跳转到单选题查询JSP视图
            return "forward:/singleSelectForm.jsp";
        }else{
            //添加成功，跳转到多选题查询JSP视图
            return "forward:/multipleSelectForm.jsp";
        }
    }

    /**
     * 试题查询-分页查询判断题
     * @param smdQuestions 试题（判断题）
     * @param pageNum 当前页号
     * @param modelMap request对象
     * @return JSP视图
     */
    @RequestMapping("/queryTrueFalse")
    public String queryTrueFalse(SmdQuestions smdQuestions, Integer pageNum,ModelMap modelMap){
        Page<SmdQuestions> page=null;
        smdQuestions.setQuestionType("3");
        if(pageNum == null){
            page= (Page<SmdQuestions>) smdQuestionsService.selectByPage(smdQuestions,1,5);
        }else{
            page= (Page<SmdQuestions>) smdQuestionsService.selectByPage(smdQuestions,pageNum,5);
        }
        List<Examination> allExamNo = examinationSerivce.findAllExamNo();
        List<String> list=new ArrayList<>();
        for (Examination examination : allExamNo) {
            list.add(examination.getExamNo());
        }
        modelMap.addAttribute("examNo",list);
        modelMap.addAttribute("page",page);
        //添加成功，跳转到判断题查询JSP视图
        return "forward:/judgeSelectForm.jsp";
    }

    /**
     * 试题查询-分页查询试题（简答题、编程题）
     * @param fspQuestions 试题（简答题、编程题）
     * @param pageNum 当前页号
     * @param type 试题类型
     * @param modelMap request对象
     * @return
     */
    @RequestMapping("/querySimple{type}")
    public String querySimple(FspQuestions fspQuestions,Integer pageNum,@PathVariable String type, ModelMap modelMap){
        Page<FspQuestions> page=null;
        fspQuestions.setQuestionType(type);
        if(pageNum == null){
            page= (Page<FspQuestions>) fspQuestionsService.selectByPage(fspQuestions, 1, 5);
        }else{
            page= (Page<FspQuestions>) fspQuestionsService.selectByPage(fspQuestions, pageNum, 5);
        }
        modelMap.addAttribute("page",page);
        if("4".equals(type)){
            //添加成功，跳转到简答题查询JSP视图
            return "";
        }else{
            //添加成功，跳转到编程题查询JSP视图
            return "";
        }
    }

    /**
     * AJAX更新单选/多选试题
     * @return JSON
     */
    @ResponseBody
    @RequestMapping("/updateChoice")
    public String updateChoice( String id, String optionA,String optionB,String optionC,String optionD,String correct,String question){
        try {
            SmdOptions smdOptions1 = smdOptionsService.findById(id);
            smdOptions1.setOptionA(optionA);
            smdOptions1.setOptionB(optionB);
            smdOptions1.setOptionC(optionC);
            smdOptions1.setOptionD(optionD);
            smdOptionsService.update(smdOptions1);
            SmdQuestions questions = smdQuestionsService.findById(smdOptions1.getSmdQuestions().getId());
            questions.setCorrect(correct);
            questions.setQuestion(question);
            smdQuestionsService.update(questions);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("AJAX更新单选/多选试题失败");
            return "{\"status\":false}";
        }
        return "{\"status\":true}";
    }

    /**
     * AJAX更新判断题
     * @param smdQuestions 判断题model
     * @return JSON
     */
    @ResponseBody
    @RequestMapping("/updateTrueFalse")
    public String updateTrueFalse(SmdQuestions smdQuestions){
        try {
            SmdQuestions smdQuestions1 = smdQuestionsService.findById(smdQuestions.getId());
            smdQuestions1.setQuestion(smdQuestions.getQuestion());
            smdQuestions1.setCorrect(smdQuestions.getCorrect());
            smdQuestionsService.update(smdQuestions1);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("AJAX更新判断题失败");
            return "{\"status\":false}";
        }
        return "{\"status\":true}";
    }

    /**
     * AJAX更新简答/编程题
     * @param fspQuestions 简答/编程题model
     * @return JSON
     */
    @ResponseBody
    @RequestMapping("/updateSimple{type}")
    public String updateSimple(FspQuestions fspQuestions){
        try {
            FspQuestions byId = fspQuestionsService.findById(fspQuestions.getId());
            byId.setQuestion(fspQuestions.getQuestion());
            byId.setStdAnswer(fspQuestions.getStdAnswer());
            fspQuestionsService.update(byId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{\"status\":true}";
    }



    /**
     * AJAX从题库删除题目
     * @param id 题目编号
     * @param type 题目类型
     * @return JSON
     */
    @ResponseBody
    @RequestMapping("/deleteTopic{type}")
    public String deleteChoice(String id,@PathVariable String type){
        try {
            switch (type){
                case "1":
                case "2":{
                    SmdOptions smdOptions = smdOptionsService.findBySmdId(id);
                    smdOptionsService.delete(smdOptions.getId());
                    smdQuestionsService.delete(id);
                }break;
                case "3":{
                    smdQuestionsService.delete(id);
                }break;
                case "4":
                case "5":{
                    fspQuestionsService.delete(id);
                }break;
                default:break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("AJAX删除题目错误");
            return "{\"status\":false}";
        }
        return "{\"status\":true}";
    }

    /**
     * AJAX试卷查询-为试卷加入**题
     * @param topics 题目编号（以,间隔）
     * @param examNo 试卷编号
     * @param type 题目类型
     * @param userId 用户编号
     * @return JSON
     */
    @ResponseBody
    @RequestMapping("/addTopicToExam{type}")
    public String addSingleToExam(String topics,String examNo,@PathVariable String type, String userId){
        try {
            Examination examination = examinationSerivce.findById(examNo);
            //无该试卷，则添加该试卷后，再为其添加题目
            if(examination == null){
                examination=new Examination(topics,userId,null,null,null,null,null,null,null,null,null);
                examinationSerivce.save(examination);
            }
            examinationSerivce.addTopic(examNo,topics,type);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("AJAX试卷查询-为试卷加入**题失败");
            return "{\"status\":false}";
        }
        return "{\"status\":true}";
    }

    /**
     * 显示试卷
     * @param examNo 试卷编号
     * @return JSP视图
     */
    @ResponseBody
    @RequestMapping("/showPaper")
    public String showPaper(String examNo, HttpSession session){

        try {
            Map<String, List<Object>> paper = examinationSerivce.queryPaper(examNo);
            session.setAttribute("paper",paper);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("");
            return "{\"status\":false}";
        }
        //跳转到指定JSP视图
        return "{\"status\":true}";
    }

    /**
     * AJAX删除试卷中某道题
     * @param topic 被删除的题目编号
     * @param type 试题类型
     * @return JSON
     */
    @ResponseBody
    @RequestMapping("/ajaxRemove{type}")
    public String ajaxRemove(String topic,@PathVariable String type){
        String examNo= (String) servletContext.getAttribute("exam");
        try {
            examinationSerivce.removeTopic(examNo,topic,type);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("AJAX删除试卷中某道题失败");
            return "{\"status\":false}";
        }
        return "{\"status\":true}";
    }

    /**
     * AJAX返回所有试卷编号
     * @return 所有试卷编号List
     */
    @RequestMapping("/findAllExamNo{type}")
    public String findAllExamNo(ModelMap modelMap,@RequestParam String type){
        List<Examination> allExamNo = examinationSerivce.findAllExamNo();
        List<String> list=new ArrayList<>();
        for (Examination examination : allExamNo) {
            list.add(examination.getExamNo());
        }
        modelMap.addAttribute("examNo",list);
        if(type.equals("maintain")){
            return "forward:/papersMaintain.jsp";
        }else{
            return "forward:/paperNum.jsp";
        }
    }

    /**
     * AJAX设置当堂考试
     * @param exa 考试编号
     * @return JSON
     */
    @ResponseBody
    @RequestMapping("/addExam")
    public String addExam(String exa){
        servletContext.setAttribute("exam",exa);
        return "{\"status\":true}";
    }

    /**
     * 显示改卷页面
     * @return 该堂考试所有学生的答题内容
     */
    @RequestMapping("/showCorrect")
    public String showCorrect(HttpServletRequest request){
        String id= (String) servletContext.getAttribute("exam");
        //返回结果map
        Map<String, Map<String,List<String>>> resultMap=new HashMap<>();
        //一名学生的答题情况
        Map<String,List<String>> map=null;
        //该试卷的所有主观题内容
        Map<String, List<FspQuestions>> queryPaper = examinationSerivce.querySubjectiveProblem(id);
        //该试卷的所有学生成绩
        List<OltsScore> oltsScores = oltsScoreService.findByExamNo(id);
        //简答题
        List<FspQuestions> simpleAnwserList=queryPaper.get("simpleAnwser");
        //编程题
        List<FspQuestions> programList=queryPaper.get("program");

        //信息存储list
        List<String> list=null;
        //答题model
        FspAnswer fspAnswer=new FspAnswer();
        //设置考试编号
        fspAnswer.setExamNo(id);
        //对当堂考试的所有学生进行遍历
        for (OltsScore oltsScore : oltsScores) {
            //基本信息list
            list=new ArrayList<>();
            //学生答题信息map
            map=new HashMap<>();
            //学生姓名
            String stuName=oltsUsersService.findById(oltsScore.getUserId()).getUserName();
            //学生成绩
            String score=oltsScore.getScore();

            list.add(oltsScore.getId());
            list.add(oltsScore.getUserId());
            list.add(stuName);
            list.add(score);
            //向map插入基本信息list（成绩编号、学生编号、学生姓名、学生客观题成绩）
            map.put("basicInfo",list);

            //考题内容信息list
            list=new ArrayList<>();
            for (FspQuestions fspQuestions : simpleAnwserList) {
                //简答题题干
                String question = fspQuestions.getQuestion();
                //简答题题干对应的标准答案
                String stdAnswer = fspQuestions.getStdAnswer();
                //设置(简答题，编程题)学生答题表的编号
                fspAnswer.setUserId(oltsScore.getUserId());
                //设置(简答题，编程题)学生答题表的题号
                fspAnswer.setFspId(fspQuestions.getId());
                //查询该用户作答的简答题，编程题答题内容
                String answerStr = fspAnswerService.findAnswerStr(fspAnswer);
                list.add(question);
                list.add(answerStr);
            }
            //向map插入考题内容信息list（题干、标准答案、学生作答内容）
            map.put("examInfo",list);
            //向结果map插入一名学生的答题情况map（学生编号，答题信息map）
            resultMap.put(oltsScore.getUserId(),map);
        }
        request.setAttribute("correct",resultMap);
        //JSP视图
        return "forward:/subItemForm.jsp";
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext=servletContext;
    }
}
