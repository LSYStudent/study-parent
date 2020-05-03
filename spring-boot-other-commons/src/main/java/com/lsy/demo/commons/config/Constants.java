package com.lsy.demo.commons.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务常量类
 * @author lsy
 * @date 2020/4/29
 */
public interface Constants {

    int SECCUSS = 200;


    /**
     * 全局异常枚举类
     * @author lsy
     * @date 2020/5/4
     */
    @Getter
    @AllArgsConstructor
    enum StatusType {

        REDIS_ERROR(4020, "程序执行错误，请联系管理员！");

        int code;

        String msg;

        public static Integer getCode(int code) {
            for (StatusType type : values()) {
                if (type.getCode() == code) {
                    return code;
                }
            }
            return null;
        }


        public static String getMsg(String msg) {
            for (StatusType type : values()) {
                if (type.getMsg().equals(msg)) {
                    return msg;
                }
            }
            return null;
        }
    }
}
