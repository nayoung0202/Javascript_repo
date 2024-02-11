package com.kitri.springbasicboot.project.login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class SignInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String session = (String) request.getSession().getAttribute("sessionId");

        if (session != null){
            return true;
        }

        response.sendRedirect("/login/test.html");
        return false;
    }
}
