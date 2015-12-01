//======================================================================
//
//        Copyright (C) 2013-2014 成都酷信科技有限公司
//        All rights reserved
//
//        文件名 ：com.huanduguihua.system.util.SystemUtils.java
//
//        创建时间：2014-5-28-上午11:06:47
//		      作者：康佳
//        http://www.cdkuxin.com
//
//======================================================================
package com.huanduguihua.system.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.huanduguihua.system.util.SimpleMailSender.MailSenderInfo;

/**
 * 名称：系统全局工具类 功能： 整个系统需要调用的功能，例如：短信接口调用、发送邮件调用等
 * 
 * @author 康佳
 * @version 1.0.0
 * 
 */
public class SystemUtils {

	private static final String MAIL_SERVER_HOST = "smtp.qq.com";
	private static final Integer MAIL_SERVER_PORT = 25;
	private static final String MAIL_SERVER_USERNAME = "kangkj@vip.qq.com";
	private static final String MAIL_SERVER_PASSWORD = "kangjia511323";
	
	private static final String SMS_API_KEY = "4722c0cd438a58d766093af0e2ac2bd4";

	/**
	 * 发送文本格式的邮件
	 * @param toAddress	接受者的邮箱地址
	 * @param subject	邮件的标题
	 * @param content	邮件的文本内容
	 */
	public static void sendTextMail(String toAddress, String subject, String content) {
		sendMail(1, "kangkj@vip.qq.com", toAddress, subject, content);
	}
	/***
	 * 发送HTML格式的邮件
	 * @param toAddress	接受者的邮箱地址
	 * @param subject	邮件的标题
	 * @param content	邮件的内容，可以是HTML代码
	 */
	public static void sendHtmlMail(String toAddress, String subject, String content) {
		sendMail(2, "kangkj@vip.qq.com", toAddress, subject, content);
	}
	
	private static void sendMail(int type, String fromAddress, String toAddress, String subject, String content) {
		SimpleMailSender sms = new SimpleMailSender();
		// 这个类主要是设置邮件
		MailSenderInfo mailInfo = sms.new MailSenderInfo();
		mailInfo.setMailServerHost(MAIL_SERVER_HOST);
		mailInfo.setMailServerPort(String.valueOf(MAIL_SERVER_PORT));
		mailInfo.setValidate(true);
		mailInfo.setUserName(MAIL_SERVER_USERNAME);
		mailInfo.setPassword(MAIL_SERVER_PASSWORD);// 您的邮箱密码
		mailInfo.setFromAddress(fromAddress);
		mailInfo.setToAddress(toAddress);
		mailInfo.setSubject(subject);
		mailInfo.setContent(content);
		// 这个类主要来发送邮件
		if (type == 1) {
			sms.sendTextMail(mailInfo);// 发送文体格式
		} else if (type == 2) {
			sms.sendHtmlMail(mailInfo);// 发送html格式
		}
	}
	
	/**
	 * 发送短信给用户
	 * @param mobile	用户的手机号	
	 * @param message	短信内容
	 * @return		发送成功返回true，失败返回false
	 */
	public static boolean sendSms(String mobile, String message) {
		try {
			SmsSender api = new SmsSender(SMS_API_KEY);
	        Integer deposit = api.status();
	        if (deposit <= 0) {
	        	System.out.println("发送失败，短信剩余条数：" + deposit);
	        	return false;
	        } else { 
	        	int error = api.send(mobile, message);
	        	if (error == 0) {
	        		System.out.println("短信发送成功：" + mobile);
	        		return true;
	        	} else {
	        		return false;
	        	}
	        }
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static String generatePassword() {
		int len = 8;
		String str = "abcdefghijklmnopqrstuvwxyz0123456789";
		String gen = new String();
		for (int i=0; i<len; i++) {
			Double ran = Math.random() * str.length();
			gen += str.charAt(ran.intValue());
		}
		return gen;
	}
	public static void main(String[] args) {
		//邮件发送示例
		SystemUtils.sendTextMail("983492338@qq.com", "测试标题", "测试内容");
		//SystemUtils.sendHtmlMail("kangjia@cdkuxin.com", "测试标题", "测试内容<a href=\"http://www.weixinim.com\" style=\"color:green;\">测试HTML代码</a>");
	
		//短信发送示例
		//SystemUtils.sendSms("13084432907", "验证码：223178，用于账号ka****ia修改密码验证，泄露有风险");
		
		//测试密码生成
//		for (int i=0; i<1000; i++) {
//			System.out.printf(SystemUtils.generatePassword()+"\t");
//			if (i % 10 == 9) {
//				System.out.println();
//			}
//		}
	}
}
