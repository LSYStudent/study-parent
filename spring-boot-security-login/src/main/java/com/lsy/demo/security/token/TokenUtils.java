package com.lsy.demo.security.token;

import com.lsy.demo.commons.exception.StudyBaseException;
import com.lsy.demo.security.config.Constants;
import com.lsy.demo.security.domain.UserDTO;
import io.jsonwebtoken.*;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * token工具类
 * @author lsy
 * @date 2020/5/4
 */
public class TokenUtils {

    /**
     * 加密JWT_KEY，采用BASE64算法
     * @return
     */
    private static SecretKey generalKey() {
        String strKey = Constants.JWT_KEY;
        byte [] bytes = Base64.decodeBase64(strKey.getBytes());
        //根据给定的字节数组使用AES加密算法构造一个密钥
        SecretKey key = new SecretKeySpec(bytes, 0, bytes.length, "AES");
        return key;
    }

    /**
     * 生成token
     * @param dto
     * @return
     */
    public static String generatorToken(UserDTO dto) {
        //签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey key = generalKey();
        //token头信息
        Map<String, Object> heanderMap = new HashMap<>();
        heanderMap.put("alg", "HS256");
        heanderMap.put("type", "JWT");

        String token = Jwts.builder()
                .setHeader(heanderMap)
                .setId(Constants.JWT_ID)
                .claim(Constants.USER_ID, dto.getId())
                .claim(Constants.USER_ROLE, dto.getRole())
                .setIssuer("lsy")
                .setIssuedAt(new Date())
                .signWith(signatureAlgorithm, key).compact();
        return token;
    }

    /**
     * 解密Token
     * @param token
     * @return
     */
    public static Claims decryptToken(String token) {
        SecretKey key = generalKey();
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new StudyBaseException(Constants.LoginStatus.TOKEN_ERROR.getMsg(), Constants.LoginStatus.TOKEN_ERROR.getCode());
        }
        return claims;
    }

    /**
     * 获取用户ID
     * @param claims
     * @return
     */
    public static Long getUserId(Claims claims) {
        Long userId = Long.parseLong(claims.get(Constants.USER_ID).toString());
        return userId;
    }

    /**
     * 获取用户角色
     * @param claims
     * @return
     */
    public static String getUserRole(Claims claims) {
        String role = (String) claims.get(Constants.USER_ROLE);
        return role;
    }

    public static void main(String[] args) {
        UserDTO dto = new UserDTO();
        dto.setId(1L);
        dto.setRole("普通用户");
        String token = generatorToken(dto);
        System.out.println("生成Token：" + token);
        Claims claims = decryptToken(token);
        System.out.println("用户ID：" + getUserId(claims));
        System.out.println("用户角色：" + getUserRole(claims));
    }
}
