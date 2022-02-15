package com.oes.service;

import com.oes.model.FspQuestions;
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
public class FspQuestionsServiceTest {

    @Resource
    FspQuestionsService fspQuestionsService;

    @Test
    public void selectByPage() {
        FspQuestions fspQuestions=new FspQuestions();
        fspQuestions.setQuestionType("4");
        fspQuestions.setQuestion("说明");
        fspQuestions.setTechCateId("1");
        List<FspQuestions> list = fspQuestionsService.selectByPage(fspQuestions, 1, 5);
        for (FspQuestions fspQuestion : list) {
            System.out.println(fspQuestion);
        }
    }

    @Test
    public void findById() {
        System.out.println(fspQuestionsService.findById("6"));
    }

    @Test
    public void delete() {
        fspQuestionsService.delete("6");
    }

    @Test
    public void update() {
        FspQuestions fspQuestions1=new FspQuestions("6","说明overload和override的区别, Overloaded的方法是否可以改变返回值的类型？",
                "k","4","10",null,null,null);
        fspQuestionsService.update(fspQuestions1);
    }

    @Test
    public void save() {
        FspQuestions fspQuestions1=new FspQuestions(null,"创建一个HashMap对象，添加一些学生的姓名和成绩：张三：90分，李四，83分。接着从HashMap中获取并他们的姓名和成绩，然后把李四的成绩改为100分，再次输出他们的信息。",
                "import java.util.HashMap;<br>" +
                        "public class Exe2 {<br>" +
                        "  public static void main(String[] args) {<br>" +
                        "    HashMap map=new HashMap();<br>" +
                        "    map.put(“张三“,90);<br>" +
                        "    map.put(“李四“,83);<br>" +
                        "    System.out.println(“修改前的成绩：“);<br>" +
                        "    System.out.println(map);<br>" +
                        "    map.put(“李四“,100);<br>" +
                        "    System.out.println(“修改后的成绩：“);<br>" +
                        "    System.out.println(map);<br>" +
                        "  }<br>" +
                        "}<br>","5","14",null,null,null);
        fspQuestionsService.save(fspQuestions1);
    }
}
