package com.bytedance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
public class EmailTest {
    @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    void test(){
        //一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("主题");
        mailMessage.setText("正文");
        mailMessage.setTo("940334249@qq.com");
        mailMessage.setFrom("940334249@qq.com");

        mailSender.send(mailMessage);
    }
    @Test
    void mimeEmailTest() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject("主题_mime");
        helper.setText("<p style='color:red'>你好牛逼MIME<p>", true);

        //附件
        helper.addAttachment("神乐板真冬.jpg", new File("E:\\image\\red.jpg"));
        helper.setTo("940334249@qq.com");
        helper.setFrom("940334249@qq.com");
        mailSender.send(mimeMessage);
    }
}
