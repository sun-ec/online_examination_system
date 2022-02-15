package com.oes.service;

import com.oes.model.OltsScore;
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
public class OltsScoreServiceTest {

    @Resource
    OltsScoreService oltsScoreService;

    @Test
    public void save() {
        OltsScore oltsScore=new OltsScore(null,"50","40",null,null,"2","SCGS18100703",null,null);
        oltsScoreService.save(oltsScore);
    }

    @Test
    public void findByExamNoAndUserId() {
        OltsScore oltsScore=new OltsScore();
        oltsScore.setExamNo("SCGS18100703");
        oltsScore.setUserId("2");
        System.out.println(oltsScoreService.findByExamNoAndUserId(oltsScore));
    }

    @Test
    public void findByExamNo() {
        List<OltsScore> list = oltsScoreService.findByExamNo("SCGS18100703");
        for (OltsScore oltsScore : list) {
            System.out.println(oltsScore);
        }
    }

    @Test
    public void findByUserId() {
        System.out.println(oltsScoreService.findByUserId("2"));
    }

    @Test
    public void findById() {
        System.out.println(oltsScoreService.findById("1"));
    }
}
