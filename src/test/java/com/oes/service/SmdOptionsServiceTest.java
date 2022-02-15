package com.oes.service;

import com.oes.model.SmdOptions;
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
public class SmdOptionsServiceTest {

    @Resource
    SmdOptionsService smdOptionsService;

    @Test
    public void selectByPage() {
        SmdOptions smdOptions=new SmdOptions();
        SmdQuestions smdQuestions=new SmdQuestions();
//        smdQuestions.setQuestion("Java");
        smdQuestions.setQuestionType("1");
        smdQuestions.setTechCateId("20");
        smdOptions.setSmdQuestions(smdQuestions);
        List<SmdOptions> list = smdOptionsService.selectByPage(smdOptions, 1, 5);
        for (SmdOptions options : list) {
            System.out.println(options);
        }
    }

    @Test
    public void findBySmdId() {
        System.out.println(smdOptionsService.findBySmdId("11"));
    }

    @Test
    public void findById() {
        System.out.println(smdOptionsService.findById("12"));
    }

    @Test
    public void update() {
        SmdOptions smdOptions1=new SmdOptions("12","java解释器","java编译器","java文档生成器","java类分析器",null,"13",null);
        smdOptionsService.update(smdOptions1);
    }

    @Test
    public void delete() {
        smdOptionsService.delete("12");
    }

    @Test
    public void save() {
        SmdOptions smdOptions=new SmdOptions(null,"在类方法中可用this来调用本类的类方法","在类方法中调用本类的类方法时可直接调用","在类方法中只能调用本类中的类方法","在类方法中绝对不能调用实例方法",null,"12",null);
        smdOptionsService.save(smdOptions);
    }
}
