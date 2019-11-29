package com.cos.crud.config;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cos.crud.model.User;

@Component
public class AdminInterceptor extends HandlerInterceptorAdapter{

    //컨트롤러보다 먼저 수행되는 메소드
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null){
            response.sendRedirect("/user/loginForm");
            return false;
        }else {
        	User user = (User)session.getAttribute("user");
        	String role = user.getRole();
        	if(!role.equals("admin")) {
        		response.sendRedirect("/user/loginForm");
        		return false;
        	}
        }
        return true;
    }
}