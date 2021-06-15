package com.dongbao.protal.web.config;

import com.dongbao.common.base.annotation.NeedToken;
import com.dongbao.common.util.JwtUtils;
import com.dongbao.protal.web.exception.TokenException;
import io.jsonwebtoken.Claims;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Description: 自定义token拦截器
 * @ClassName: TokenInterceptConfig
 * @Author: xfeng
 * @Date: 2021/6/15 20:56
 * @Version: 1.0
 */

public class TokenInterceptConfig implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("进入拦截器");
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            throw new LoginException("token 为空");
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        if (method.isAnnotationPresent(NeedToken.class)) {
            //表示有注解
            NeedToken annotation = method.getAnnotation(NeedToken.class);
            if (annotation.value()) {
                //表示需要token
                try {
                    JwtUtils.checkJWT(token);
                } catch (Exception e){
                    throw new TokenException("token错误");
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
