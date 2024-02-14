package com.kitri.springbasicboot.lesson.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    @Override //반환 값 : boolean
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("로그 메시지 : preHandle() 호출됨");
        return true; // 다음 페이지를 넘어가기 위해선 리턴 true
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("로그 메시지 : postHandle() 호출됨");
    }
    //등록 -> WebConfig에서 호출
}
