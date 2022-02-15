package com.oes.controller;

import com.oes.model.Courses;
import com.oes.model.TechCategory;
import com.oes.service.CoursesService;
import com.oes.service.TechCategoryService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: He Changjie  on  2018-10-05
 * @description: 知识点控制层
 */
@Controller
@RequestMapping("/tech")
public class TechCategoryController implements ServletContextAware {

    static Logger logger= Logger.getLogger(TechCategoryController.class);

    @Resource
    TechCategoryService techCategoryService;

    /**Servlet容器对象，通过 ServletContextAware 接口注入*/
    ServletContext servletContext;

    @Resource
    CoursesService coursesService;

    /**
     * 根据知识点名模糊查询
     * @param TechCategory 知识点model
     * @return JSON视图
     */
    @RequestMapping("/query")
    public String query(TechCategory TechCategory, ModelMap modelMap){
        modelMap.addAttribute("TechCategoryList",techCategoryService.findAllLikeName(TechCategory));
        return "forward:/knowledgePoint.jsp";
    }

    /**
     * AJAX添加一个新的知识点
     * @param techCategory 知识点
     * @return JSON
     */
    @ResponseBody
    @RequestMapping("/addTech")
    public String addTech(TechCategory techCategory){
        try {
            techCategoryService.save(techCategory);
            List<TechCategory> list = techCategoryService.findAll();
            servletContext.setAttribute("techList",list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("AJAX添加一个新的知识点失败");
            return "{\"status\":false}";
        }
        return "{\"status\":true}";
    }

    /**
     * AJAX获取打开更新模态框所需的知识点数据
     * @param id 知识点编号
     * @return 知识点model
     */
    @ResponseBody
    @RequestMapping("/showAjaxUpdate")
    public TechCategory showAjaxUpdate(String id){
        return techCategoryService.findById(id);
    }

    /**
     * AJAX点击更新模态框中确认更新按钮，所进行的更新操作
     * @param techCategory 知识点model
     * @return JSON
     */
    @ResponseBody
    @RequestMapping("/ajaxUpdate")
    public String ajaxUpdate(TechCategory techCategory){
        try {
            techCategoryService.update(techCategory);
            List<TechCategory> list = techCategoryService.findAll();
            servletContext.setAttribute("techList",list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("点击更新模态框中确认更新按钮，所进行的更新操作失败");
            return "{\"status\":false}";
        }
        return "{\"status\":true}";
    }

    /**
     * AJAX删除知识点
     * @param id 知识点编号
     * @return JSON
     */
    @ResponseBody
    @RequestMapping("/ajaxDelete")
    public String ajaxDelete(String id){
        try {
            techCategoryService.delete(id);
            List<TechCategory> list = techCategoryService.findAll();
            servletContext.setAttribute("techList",list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("AJAX删除知识点失败");
            return "{\"status\":false}";
        }
        return "{\"status\":true}";
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext=servletContext;
    }
}
