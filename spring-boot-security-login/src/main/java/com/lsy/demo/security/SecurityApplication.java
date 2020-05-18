package com.lsy.demo.security;

import com.lsy.demo.commons.component.R;
import com.lsy.demo.commons.exception.StudyBaseException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 启动类
 * @author lsy
 */
@RestControllerAdvice
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableDiscoveryClient
@MapperScan(basePackages = "com.lsy.demo.repo.mapper")
public class SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @ExceptionHandler(StudyBaseException.class)
    @ResponseStatus(HttpStatus.OK)
    public R<String> bindExceptionHandler(StudyBaseException ex) {
        return R.failed(ex.getCode(), ex.getMsg());
    }
}
