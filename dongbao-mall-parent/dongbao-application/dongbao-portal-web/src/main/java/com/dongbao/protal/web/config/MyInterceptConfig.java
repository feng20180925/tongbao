package com.dongbao.protal.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: 自定义token拦截器
 * @ClassName: TokenInterceptConfig
 * @Author: xfeng
 * @Date: 2021/6/15 20:54
 * @Version: 1.0
 */

@Configuration
public class MyInterceptConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptConfig()).addPathPatterns("/**")
                .excludePathPatterns("/ums-member/login")
                .excludePathPatterns("/ums-member/register");
    }

    @Bean
    public TokenInterceptConfig tokenInterceptConfig(){
        return new TokenInterceptConfig();
    }
}
