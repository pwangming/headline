package com.pwm.headline.util;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * ClassName: JwtHelper
 * Package: com.pwm.headline.util
 * Description:
 *
 * @Author: pengwangming
 * @Create: 2024/7/30 - 23:38
 * @Version: v1.0
 */
public class JwtHelper {
    private static long tokenExpiration = 24 * 60 * 60 * 1000;
    private static String tokenSignKey = "123456";

    // 生成token字符串
    public static String createToken(Long userId) {
        String token = Jwts.builder()
                .setSubject("YYGH-USER")
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .claim("userId", userId)
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }
    // 从token字符串获取userid
}
