package com.kitri.springbasicboot.project.login;

import com.kitri.springbasicboot.lesson.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig3 implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SignInterceptor())
                .addPathPatterns("/**/after-login.html");
        //앞의 경로는 상관없이 after-login.html로 감
    }
}
