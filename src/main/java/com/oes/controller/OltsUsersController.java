package com.oes.controller;

import com.oes.model.Courses;
import com.oes.model.OltsUsers;
import com.oes.model.TechCategory;
import com.oes.service.CoursesService;
import com.oes.service.OltsUsersService;
import com.oes.service.TechCategoryService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author: He Changjie  on  2018-10-04
 * @description: 用户控制层
 */
@Controller
@RequestMapping("/user")
public class OltsUsersController implements ServletContextAware {

    @Resource
    OltsUsersService oltsUsersService;
    @Resource
    CoursesService coursesService;
    @Resource
    TechCategoryService techCategoryService;

    static Logger logger= Logger.getLogger(OltsUsersController.class);

    /**Servlet容器对象，通过 ServletContextAware 接口注入*/
    ServletContext servletContext;

    /**
     * 用户登录
     * @param oltsUsers 用户
     * @param session session
     * @return JSP视图
     */
    @RequestMapping("/login")
    public String login(OltsUsers oltsUsers, HttpSession session){
        OltsUsers users = oltsUsersService.login(oltsUsers);
        if(users == null){
            //登录失败，返回到登陆界面并提示用户
            return "forward:login.jsp?logInfo=false";
        }else{
            if("1".equals(users.getUserType()) || "9".equals(users.getUserType())){
                List<Courses> coursesList = coursesService.findAll();
                List<TechCategory> techList = techCategoryService.findAll();
                servletContext.setAttribute("courList",coursesList);
                servletContext.setAttribute("techList",techList);
            }
            session.setAttribute("logUser",users);
            //登录成功，跳转页面
            if("1".equals(users.getUserType()) || "9".equals(users.getUserType())){
                return "redirect:/teacherForm.jsp";
            }else{
                return "redirect:/studentForm.jsp";
            }

        }
    }

    /**
     * 退出登录
     * @param session session
     * @return JSP视图
     */
    @RequestMapping("/logOut")
    public String loginOut(HttpSession session){
        session.invalidate();
        //退出登录，跳转到登录界面
        return "forward:/login.jsp";
    }

    /**
     * 批量导入用户
     * @param excelFile <input type="file" name="excelFile">所选择的excel文件
     * @return JSON
     */
    @RequestMapping("/bulkInsert")
    public String bulkInsert(OltsUsers oltsUsers, @RequestParam("upload") CommonsMultipartFile excelFile){
        try {
            oltsUsersService.bulkInsert(excelFile.getInputStream(),0,oltsUsers.getSchAddr());
        } catch (IOException e) {
            e.printStackTrace();
            logger.warn("IO流异常");
            return "forward:/batchImportUser.jsp?status=false";
        }
        //批量导入成功，跳转到指定JSP视图
        return "forward:/batchImportUser.jsp?status=true";
    }

    /**
     * 显示通过授课学校查询用户
     * @param sch 授课学校
     * @param modelMap modelMap对象
     * @return JSP视图
     */
    @RequestMapping("/showUsers")
    public String showUsers(String sch, ModelMap modelMap){
        List<OltsUsers> usersList = oltsUsersService.findBySch(sch);
        modelMap.addAttribute("usersList",usersList);
        //查询所有用户，返回指定JSP视图
        return "forward:/batchModifyUser.jsp";
    }

    /**
     * AJAX批量删除用户
     * @param str 用户编号字符串（以,间隔）
     * @return JSON
     */
    @ResponseBody
    @RequestMapping("/bulkDelete")
    public String bulkDelete(@RequestParam("userIdStr") String str){
        try {
            String[] split = str.split("[,，]");
            for (String s : split) {
                oltsUsersService.deleteById(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("AJAX批量删除用户失败");
            return "{\"status\":false}";
        }
        return "{\"status\":true}";
    }

    /**
     * 获取打开更新模态框，所需的显示数据
     * @param id 用户编号
     * @return 用户model
     */
    @ResponseBody
    @RequestMapping("/showAjaxUpdate")
    public OltsUsers showAjaxUpdate(String id){
        return oltsUsersService.findById(id);
    }

    /**
     * AJAX在更新模态框中确认更新所进行的更新操作
     * @param oltsUsers 用户model
     * @return JSON
     */
    @RequestMapping("/ajaxUpdate")
    @ResponseBody
    public String ajaxUpdate(OltsUsers oltsUsers){
        try {
            oltsUsersService.update(oltsUsers);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("AJAX在更新模态框中确认更新所进行的更新操作失败！");
            //更新用户失败，返回JSON
            return "{\"status\":false}";
        }
        //更新用户成功，返回JSON
        return "{\"status\":true}";
    }


    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext=servletContext;
    }
}
