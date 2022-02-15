package com.oes.interceptor;

import com.oes.model.OltsUsers;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 * 全局拦截器
 */
public class UserInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        OltsUsers logUser = (OltsUsers) session.getAttribute("logUser");
        //判断登录的用户是否为老师/管理员，若为老师/管理员则不拦截
        if("1".equals(logUser.getUserType()) || "9".equals(logUser.getUserType())){
            return true;
        }
        //登录用户为学生，进行拦截，重定向回学生考试界面
        response.sendRedirect(request.getContextPath()+"/index.jsp");
        return false;
    }
}
