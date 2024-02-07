package com.kitri.springbasicboot.lesson.filter;

import com.kitri.springbasicboot.lesson.interceptor.LogInterceptor;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//filter는 세세한 설정이 필요
//Comfiguration, Bean 등록
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean //Bean
    public FilterRegistrationBean logFilter(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>(); //필터 생성
        filterFilterRegistrationBean.setFilter(new Logfilter()); //필터 객체 담기 + 실행
        filterFilterRegistrationBean.setOrder(2); //우선순위 2
        return filterFilterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean log2Filter(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new Log2Filter());
        filterFilterRegistrationBean.setOrder(1); //우선순위 1

        return filterFilterRegistrationBean;
    }

}
