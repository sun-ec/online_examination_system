package com.oes.service;

import com.oes.model.Courses;
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
public class CoursesServiceTest {

    @Resource
    CoursesService coursesService;

    @Test
    public void testName() {
        System.out.println(1+2<2);
    }

    @Test
    public void findById() {
        System.out.println(coursesService.findById("25"));
    }

    @Test
    public void findAll() {
        List<Courses> list = coursesService.findAll();
        for (Courses courses : list) {
            System.out.println(courses);
        }
    }

    @Test
    public void findAllLikeName() {
        List<Courses> j = coursesService.findAllLikeName("J");
        for (Courses courses : j) {
            System.out.println(courses);
        }
    }

    @Test
    public void delete() {
        System.out.println(coursesService.delete("25"));
    }

    @Test
    public void update() {
        Courses courses=new Courses("25","test1");
        coursesService.update(courses);
    }

    @Test
    public void save() {
        Courses courses=new Courses(null,"test");
        System.out.println(coursesService.save(courses));
    }
}
