package com.dongbao.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @Description: jwt测试类
 * @ClassName: JwtUtils
 * @Author: xfeng
 * @Date: 2021/6/14 19:59
 * @Version: 1.0
 */

public class JwtUtils {
    public static final String SUBJECT = "dongbao-xfeng";

    public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;  //过期时间，毫秒，一周

    //秘钥
    public static final String APPSECRET = "dongbao-xfeng666";

    /**
     * 生成jwt
     *
     * @param
     * @return
     */
    public static String geneJsonWebToken(String username) {

        if (username == null) {
            return null;
        }
        String token = Jwts.builder().setSubject(SUBJECT)
//                .claim("id", user.getId())
                .claim("name", username)
//                .claim("img", user.getHeadImg())
                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APPSECRET).compact();

        return token;
    }


    /**
     * 校验token
     *
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) throws Exception{

        final Claims claims = Jwts.parser().setSigningKey(APPSECRET).
                parseClaimsJws(token).getBody();
        return claims;

    }

}
