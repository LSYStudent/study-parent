package com.lsy.demo.security.config;

import cn.hutool.core.lang.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 全局常量配置
 * @author lsy
 * @date 2020/5/3
 */
public interface Constants {

    /**
     * token标头
     */
    String TOKEN_HEADER = "Authorization";

    /**
     * token过期时间
     */
    long TOKEN_EXPIRE_TIME = 60 * 60;

    /**
     * JWT key
     */
    String JWT_KEY = "be217dc9-f047-4351-bdb0-890f88fabae3";

    /**
     * JWT ID
     */
    String JWT_ID = UUID.randomUUID().toString();

    /**
     * token前缀
     */
    String TOKEN_PREFIX = "study:";

    /**
     * 用户角色标记
     */
    String USER_ROLE = "ROLE";

    /**
     * 用户ID标记
     */
    String USER_ID = "u_id";


    @Getter
    @AllArgsConstructor
    enum LoginStatus {

        TOKEN_ERROR(4010, "token错误！"),
        EMAIL_USER_ERROR(4015, "邮箱发送失败！");

        int code;

        String msg;

        public static Integer getCode(int code) {
            for (LoginStatus status : values()) {
                if (status.getCode() == code) {
                    return code;
                }
            }
            return null;
        }

        public static String getMsg(String msg) {
            for (LoginStatus status : values()) {
                if (status.getMsg().equals(msg)) {
                    return msg;
                }
            }
            return null;
        }
    }
}
