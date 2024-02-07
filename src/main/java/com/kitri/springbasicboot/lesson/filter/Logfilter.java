package com.kitri.springbasicboot.lesson.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class Logfilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("로그1 메시지 : init() 호출됨");
        //처음 시작되는 필터
        //필터객체가 생성 및 초기화 될 때 최초 한 번 실행된다.
    }

    @Override
    public void destroy() {
        log.info("로그1 메시지 : destroy() 호출됨");
        //끝날때 실행되는 필터
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("로그1 메시지 : doFilter() 호출됨");
        chain.doFilter(request, response);
        //서버에서 브라우저로 갈 때 마다 실행되는 필터
    }
}
