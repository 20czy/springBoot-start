package com.example.demo.utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import com.example.demo.entity.Traveller;
/*
        // 添加HEADER
        Jwts.builder()
        .setHeaderParam("alg", "HS256") // 设置签名算法，例如HMAC SHA-256
        .setHeaderParam("typ", "JWT")   // 设置令牌类型

        // 添加PAYLOAD
        Jwts.builder()
        .setSubject("user123")  // 设置主题
        .setIssuedAt(new Date()) // 设置签发时间
        .setExpiration(new Date(System.currentTimeMillis() + expirationTime)) // 设置过期时间
        .setClaim("customClaim", "customValue")

        // 设置cookie
        function setCookie(name, value, days) {
        var expires = "";
        if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
        expires = "; expires=" + date.toUTCString();
        }
        document.cookie = name + "=" + value + expires + "; path=/";
        }

        // 示例：将名为 "userToken" 的cookie设置为JWT字符串，有效期为1天
        var jwtToken = "your_jwt_token_here";
        setCookie("userToken", jwtToken, 1);

* */

/*
    public static void main(String[] args) {
        Traveller traveller = new Traveller();
        traveller.setName("Genshin");
        traveller.setPassword("123456");
        String token = generateToken(traveller.getName());
        System.out.println(token);
        String travellerName = Token.analyseKey(token).getSubject();
        System.out.println(travellerName);
    }
*/
public class Token {

    private static String secretKey;
    public static String generateToken(String userName) {
        if (secretKey == null){
            secretKey = base64Key();
        }
        // 1 day in milliseconds
        long expirationTime = 86400000;
        String token = Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        return token;
    }

    private static String base64Key() {
        int keyLengthInBytes = 32; // 256 bits
        byte[] keyBytes = generateRandomKey(keyLengthInBytes);

        return Base64.getEncoder().encodeToString(keyBytes);
    }

    private static byte[] generateRandomKey(int length) {
        // 根据所需要的长度生成密钥
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[length];
        secureRandom.nextBytes(key);
        return key;
    }

    public static Claims analyseKey(String token) {
        return  Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody(); //获取PAYLOAD部分
    }
}
