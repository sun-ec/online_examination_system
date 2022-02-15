package com.oes.service;

import com.oes.model.SmdQuestions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SmdQuestionsServiceTest {

    @Resource
    SmdQuestionsService smdQuestionsService;

    @Test
    public void selectByPage() {
        SmdQuestions smdQuestions=new SmdQuestions();
        smdQuestions.setQuestionType("1");
        smdQuestions.setTechCateId("2");
        smdQuestions.setQuestion("Java");
        List<SmdQuestions> list = smdQuestionsService.selectByPage(smdQuestions,1,5);
        for (SmdQuestions smdQuestion : list) {
            System.out.println(smdQuestion);
        }
    }

    @Test
    public void findById() {
        System.out.println(smdQuestionsService.findById("11"));
    }

    @Test
    public void delete() {
        System.out.println(smdQuestionsService.delete("6"));
    }

    @Test
    public void update() {
        SmdQuestions questions=new SmdQuestions("6","test","A","1","3",null,null,null);
        smdQuestionsService.update(questions);
    }

    @Test
    public void save() {
        SmdQuestions questions1 = new SmdQuestions(null, "application是从其中的main()方法开始运行的。", "对", "3", "20", null, null, null);
        System.out.println(questions1.getId());
        smdQuestionsService.save(questions1);

    }
}
