package com.project.memo.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Configure implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        HandlerInterceptor interceptor = new LoginInterceptor();
        List<String> patterns = new ArrayList<>();
        patterns.add("/css/**");
        patterns.add("/image/**");
        patterns.add("/javascript/**");
        patterns.add("/register");
        patterns.add("welcome.html");
        patterns.add("/login.html");
        patterns.add("/resetPassword");
        patterns.add("/user/login");
        patterns.add("/user/reset");
        patterns.add("/user/signUp");
        patterns.add("/login");

        registry.addInterceptor(interceptor)
                .addPathPatterns("/**").excludePathPatterns(patterns);
    }
}
