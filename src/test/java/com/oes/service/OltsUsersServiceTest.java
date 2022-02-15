package com.oes.service;

import com.oes.model.OltsUsers;
import com.oes.model.POIUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OltsUsersServiceTest {

    @Resource
    OltsUsersService oltsUsersService;

    @Test
    public void findBySchTest() {
        List<OltsUsers> list = oltsUsersService.findBySch("四川工商学院3期");
        for (OltsUsers oltsUsers : list) {
            System.out.println(oltsUsers);
        }
    }

    @Test
    public void bulkInsertTest() {
        try {
            InputStream is=new FileInputStream("F:\\蓝桥学院\\JAVA后端\\阶段项目\\olts\\docs\\20160511_西华大学_考试成绩_模板.xls");
            oltsUsersService.bulkInsert(is,0,"四川工商学院3期");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByIdTest() {
        System.out.println(oltsUsersService.findById("3"));
    }

    @Test
    public void loginTest() {
        OltsUsers user=new OltsUsers();
        user.setUserName("james");
        user.setPassWord("james");
        System.out.println(oltsUsersService.login(user));
    }

    @Test
    public void saveTest() {
        OltsUsers user=new OltsUsers();
        user.setStuNo("99999991241");
        user.setIdCardNo("999199999999");
        user.setUserName("james");
        user.setPassWord("james");
        user.setBirthday(new Date());
        System.out.println(oltsUsersService.save(user));
    }

    @Test
    public void delete() {
        oltsUsersService.deleteById("109");
    }

    @Test
    public void updateTest() {
        OltsUsers users = oltsUsersService.findById("3");
        users.setBirthday(new Date());
        users.setPassWord("123");
        users.setEmail("2135125@icloud.com");
        users.setQq("1234126343");
        oltsUsersService.update(users);
    }

    @Test
    public void deleteByIdTest() {
        System.out.println(oltsUsersService.deleteById("4"));
    }
}
