package com.oes.service;

import com.oes.model.TechCategory;
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
public class TechCategoryServiceTest {

    @Resource
    TechCategoryService techCategoryService;

    @Test
    public void findByCourId() {
        for (TechCategory techCategory : techCategoryService.findByCourId("1")) {
            System.out.println(techCategory);
        }
    }

    @Test
    public void findById() {
        TechCategory category = techCategoryService.findById("1");
        System.out.println(category);
    }

    @Test
    public void save() {
        TechCategory tech=new TechCategory(null,"test","1",null);
        System.out.println(techCategoryService.save(tech));
    }

    @Test
    public void update() {
        TechCategory tech=new TechCategory("20","test","1",null);
        System.out.println(techCategoryService.update(tech));
    }

    @Test
    public void findAllLikeName() {
        TechCategory tech=new TechCategory(null,"java","1",null);
        List<TechCategory> a = techCategoryService.findAllLikeName(tech);
        for (TechCategory techCategory : a) {
            System.out.println(techCategory);
        }
    }

    @Test
    public void delete() {
        System.out.println(techCategoryService.delete("20"));
    }

    @Test
    public void findAll() {
        List<TechCategory> list = techCategoryService.findAll();
        for (TechCategory techCategory : list) {
            System.out.println(techCategory);
        }
    }
}
