package com.oes.service;

import com.oes.model.Examination;
import com.oes.model.FspQuestions;
import com.oes.model.SmdOptions;
import com.oes.model.SmdQuestions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ExaminationSerivceTest {

    @Resource
    ExaminationSerivce examinationSerivce;

    @Test
    public void save() {
        Examination examination=new Examination("SCGS18100703","1",null,null,null,null,null,null,null,null,null);
        examinationSerivce.save(examination);
    }

    @Test
    public void addTopic() {
        System.out.println(examinationSerivce.addTopic("SCGS18100703", "1,9,2,5,7,8", "1"));
    }

    @Test
    public void removeTopic() {
        System.out.println(examinationSerivce.removeTopic("SCGS18100703", "5", "1"));
    }

    @Test
    public void findAllExamNo() {
        List<Examination> allExamNo = examinationSerivce.findAllExamNo();
        for (Examination examination : allExamNo) {
            System.out.println(examination);
        }
    }

    @Test
    public void update() {
        Examination examination=new Examination();
        examination.setExamNo("SCGS18100703");
        examination.setUserId("1");
        examination.setSingleId("1,2,3,4,5");
        examination.setMultipleId("7,8,9,10,11");
        examination.setTrueFalseId("12,13,14,15,16,17,18");
        examination.setSimpleAnwserId("1,2,3,4");
        examination.setProgramId("7,8");
        examinationSerivce.update(examination);
    }

    @Test
    public void querySubjectiveProblem() {
        Map<String, List<FspQuestions>> map = examinationSerivce.querySubjectiveProblem("SCGS18100703");
        List<FspQuestions> simpleAnwser = map.get("simpleAnwser");
        List<FspQuestions> program = map.get("program");
        System.out.println("简答题：");
        for (FspQuestions questions : simpleAnwser) {
            System.out.println(questions);
        }
        System.out.println("编程题：");
        for (FspQuestions fspQuestions : program) {
            System.out.println(fspQuestions);
        }
    }

    @Test
    public void queryPaper() {
        Map<String, List<Object>> map = examinationSerivce.queryPaper("SCGS18100703");
        List<Object> single = map.get("single");
        List<Object> multiple = map.get("multiple");
        List<Object> trueFalse = map.get("trueFalse");
        List<Object> simpleAnwser = map.get("simpleAnwser");
        List<Object> program = map.get("program");
        SmdOptions smdOptions=null;
        SmdQuestions smdQuestions=null;
        FspQuestions fspQuestions=null;
        System.out.println("单选题：");
        for (Object o : single) {
            smdOptions= (SmdOptions) o;
            System.out.println(smdOptions);
        }
        System.out.println("多选题：");
        for (Object o : multiple) {
            smdOptions= (SmdOptions) o;
            System.out.println(smdOptions);
        }
        System.out.println("判断题：");
        for (Object o : trueFalse) {
            smdQuestions= (SmdQuestions) o;
            System.out.println(smdQuestions);
        }
        System.out.println("简答题：");
        for (Object o : simpleAnwser) {
            fspQuestions= (FspQuestions) o;
            System.out.println(fspQuestions);
        }
        System.out.println("编程题：");
        for (Object o : program) {
            fspQuestions= (FspQuestions) o;
            System.out.println(fspQuestions);
        }

    }

    @Test
    public void findById() {
        System.out.println(examinationSerivce.findById("SCGS18100703"));
    }
}
