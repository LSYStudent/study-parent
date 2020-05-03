package com.lsy.demo.security.mail;

import com.lsy.demo.commons.exception.StudyBaseException;
import com.lsy.demo.security.config.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Random;

/**
 * 邮箱工具类
 * @author lsy
 * @date 2020/5/4
 */
@Slf4j
public class MailUtils {

    private static String host;

    private static String userName;

    private static String password;

    private static JavaMailSenderImpl mailSender;

    @Value("${spring.mail.host}")
    public void setHost(String host) {
        this.host = host;
    }

    @Value("${spring.mail.user-name}")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Value("${spring.mail.password}")
    public void setPassword(String password) {
        this.password = password;
    }

    static {
        mailSender.setHost(host);
        mailSender.setUsername(userName);
        mailSender.setPassword(password);
    }

    /**
     * 发送邮件
     * @param email  接受人邮箱
     * @param code   随机验证码
     */
    public static void sendMail(String email, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        String content = "您好，\n欢迎注册本网站，您的验证码为 "+ code + " \n请妥善保管号，请勿向他人泄露。";
        message.setSubject("lsy");
        message.setText(content);
        message.setFrom(userName);
        message.setTo(email);

        try {
            mailSender.send(message);
        } catch (MailException e) {
            log.info("邮箱为：" + email + ",的用户，邮箱发送失败！");
            throw new StudyBaseException(Constants.LoginStatus.EMAIL_USER_ERROR.getMsg(), Constants.LoginStatus.EMAIL_USER_ERROR.getCode());
        }
    }

    /**
     * 生成六位随机验证码
     * @return
     */
    public static String generatorCode() {
        StringBuffer buffer = new StringBuffer();
        String str = "qwertyuiopasdfghjklmnbvcxz1234567890POIUYTREWQASDFGHJKLMNBVCXZ";
        Random random = new Random();
        for (int i = 0; i< str.length(); i++) {
            int number = random.nextInt(str.length());
            buffer.append(str.charAt(number));
        }
        return buffer.toString();
    }
}
