package com.dongbao.common.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Description: 密码加密解密工具类
 * @ClassName: BCryptPasswordEncoderUtils
 * @Author: xfeng
 * @Date: 2021/6/13 15:02
 * @Version: 1.0
 */

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    private BCryptPasswordEncoderUtils(){

    }

    /**
     * 进行加密
     * @param password
     * @return
     */
    public static String getEncode(String password){
        return encoder.encode(password);
    }


    /**
     * 和数据源密码进行比较
     * @param sourceString
     * @param afterPassword
     * @return
     */
    public static boolean getMatch(String sourceString,String afterPassword){
        return encoder.matches(sourceString,afterPassword);
    }
}
