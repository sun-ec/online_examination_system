package com.oes.controller;

import com.oes.model.Courses;
import com.oes.service.CoursesService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.List;

/**
 * @author: He Changjie  on  2018-10-05
 * @description: 课程控制层
 */
@Controller
@RequestMapping("/course")
public class CoursesController implements ServletContextAware {

    static Logger logger= Logger.getLogger(CoursesController.class);

    @Resource
    CoursesService coursesService;

    /**Servlet容器对象，通过 ServletContextAware 接口注入*/
    ServletContext servletContext;

    /**
     * AJAX添加一个新的课程
     * @param courses 课程
     * @return JSON
     */
    @ResponseBody
    @RequestMapping("/addCourse")
    public String addCourse(Courses courses){
        try {
            coursesService.save(courses);
            List<Courses> list = coursesService.findAll();
            servletContext.setAttribute("courList",list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("添加一个新的课程失败");
            return "{\"status\":false}";
        }
        return "{\"status\":true}";
    }

    /**
     * AJAX获取打开更新模态框所需的课程数据
     * @param id 课程编号
     * @return 课程model
     */
    @ResponseBody
    @RequestMapping("/showAjaxUpdate")
    public Courses showAjaxUpdate(String id){
        return coursesService.findById(id);
    }

    /**
     * AJAX点击更新模态框中确认更新按钮，所进行的更新操作
     * @param courses 课程model
     * @return JSON
     */
    @ResponseBody
    @RequestMapping("/ajaxUpdate")
    public String ajaxUpdate(Courses courses){
        try {
            coursesService.update(courses);
            List<Courses> list = coursesService.findAll();
            servletContext.setAttribute("courList",list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("AJAX点击更新模态框中确认更新按钮，所进行的更新操作失败");
            return "{\"status\":false}";
        }
        return "{\"status\":true}";
    }

    /**
     * AJAX删除课程
     * @param id 课程编号
     * @return JSON
     */
    @ResponseBody
    @RequestMapping("/ajaxDelete")
    public String ajaxDelete(String id){
        try {
            coursesService.delete(id);
            List<Courses> list = coursesService.findAll();
            servletContext.setAttribute("courList",list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("AJAX删除课程失败！");
            return "{\"status\":false}";
        }
        return "{\"status\":true}";
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext=servletContext;
    }
}
