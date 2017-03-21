package com.ssm.other.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 测试发送邮件
 * 邮箱为@163.com
 */
public class SendEmail {

    public static void sendMailCode(String email,String code) throws MessagingException {

        Properties properties=new Properties();
        //开启debug调试
        properties.setProperty("mail.debug","true");
        //发送服务器需要身份验证
        properties.setProperty("mail.smtp.auth","true");
        //设置邮件服务器主机名
        properties.setProperty("mail.host","smtp.163.com");
        //发送邮件协议名称
        properties.setProperty("mail.transport.protocol","smtp");

        //设置环境信息
        Session session=Session.getInstance(properties);

        //创建邮件对象
        Message message=new MimeMessage(session);
        //设置邮件主题
        message.setSubject("邮箱验证");

        StringBuffer text=new StringBuffer("你的邮箱验证码是");
        text.append(code).append(",请输入并提交");

        //设置邮件内容
        message.setText(text.toString());
        //设置发件人
        message.setFrom(new InternetAddress("15773238696@163.com"));
        Transport transport=session.getTransport();
        //连接邮件服务器
        transport.connect("15773238696","ll123456");
        //发送邮件
        transport.sendMessage(message,new Address[]{new InternetAddress(email)});
        //关闭连接
        transport.close();

    }


    public static void main(String args[]) throws MessagingException {
        Properties properties=new Properties();
        //开启debug调试
        properties.setProperty("mail.debug","true");
        //发送服务器需要身份验证
        properties.setProperty("mail.smtp.auth","true");
        //设置邮件服务器主机名
        properties.setProperty("mail.host","smtp.163.com");
        //发送邮件协议名称
        properties.setProperty("mail.transport.protocol","smtp");

        //设置环境信息
        Session session=Session.getInstance(properties);

        //创建邮件对象
        Message message=new MimeMessage(session);
        //设置邮件主题
        message.setSubject("javamail测试发送邮件");
        //设置邮件内容
        message.setText("这是一封javamail发送的邮件");
        //设置发件人
        message.setFrom(new InternetAddress("15773238696@163.com"));
        Transport transport=session.getTransport();
        //连接邮件服务器
        transport.connect("15773238696","ll123456");
        //发送邮件
        transport.sendMessage(message,new Address[]{new InternetAddress("13560710528@163.com")});
        //关闭连接
        transport.close();


    }
}
