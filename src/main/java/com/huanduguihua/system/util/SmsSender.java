//======================================================================
//
//        Copyright (C) 2013-2014 成都酷信科技有限公司
//        All rights reserved
//
//        文件名 ：com.huanduguihua.system.util.SmsSender.java
//
//        创建时间：2014-5-29-上午9:44:28
//		      作者：康佳
//        http://www.cdkuxin.com
//
//======================================================================
package com.huanduguihua.system.util;

import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HttpContext;
import org.json.JSONObject;

//import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * 名称：
 * 功能：
 * 
 * @author 康佳
 * @version 1.0.0
 * 
 */
public class SmsSender {

	private String apiKey;
	
	public SmsSender(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public static void main(String[] args) throws Exception {

		SmsSender api = new SmsSender("4722c0cd438a58d766093af0e2ac2bd4");
        Integer deposit = api.status();
        System.out.println("短信剩余条数：" + deposit);
        api.send("13084432907", "尊敬的用户您好，你本次的验证码是：54eh");
    }

    @SuppressWarnings("deprecation")
	public int send(String mobile, String message) throws Exception {

        DefaultHttpClient client = new DefaultHttpClient();

        client.addRequestInterceptor(new HttpRequestInterceptor() {
			@SuppressWarnings("restriction")
			@Override
            public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
                request.addHeader("Accept-Encoding", "gzip");
//                request.addHeader("Authorization", "Basic " + new BASE64Encoder().encode(("api:"+apiKey).getBytes("utf-8")));
            }
        });

        client.getParams().setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 30000);
        client.getParams().setIntParameter(CoreConnectionPNames.SO_TIMEOUT, 30000);

        HttpPost request = new HttpPost("https://sms-api.luosimao.com/v1/send.json");

        ByteArrayOutputStream bos = null;
        InputStream bis = null;
        byte[] buf = new byte[10240];

        String content = null;
        try {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("mobile", mobile));
            params.add(new BasicNameValuePair("message", message + "【环度智慧】"));
            request.setEntity(new UrlEncodedFormEntity(params, "utf-8"));


            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                bis = response.getEntity().getContent();
                Header[] gzip = response.getHeaders("Content-Encoding");

                bos = new ByteArrayOutputStream();
                int count;
                while ((count = bis.read(buf)) != -1) {
                    bos.write(buf, 0, count);
                }
                bis.close();

                if (gzip.length > 0 && gzip[0].getValue().equalsIgnoreCase("gzip")) {
                    GZIPInputStream gzin = new GZIPInputStream(new ByteArrayInputStream(bos.toByteArray()));
                    StringBuffer sb = new StringBuffer();
                    int size;
                    while ((size = gzin.read(buf)) != -1) {
                        sb.append(new String(buf, 0, size, "utf-8"));
                    }
                    gzin.close();
                    bos.close();

                    content = sb.toString();
                } else {
                    content = bos.toString();
                }

                System.out.println("响应：" + content);
                JSONObject data = new JSONObject(content);
                if (data.optInt("error") == 0) {
                	return 0;
                } else {
                	System.out.println("发送失败：" + data.optString("msg"));
                	return -1;
                }
            } else {
                System.out.println("error code is " + response.getStatusLine().getStatusCode());
                return -1;
            }
        } finally {
            if (bis != null) {
                try {
                    bis.close();// 最后要关闭BufferedReader
                } catch (Exception e) {
                }
            }
        }
    }

    @SuppressWarnings("deprecation")
	public int status() throws Exception {

        DefaultHttpClient client = new DefaultHttpClient();

        client.addRequestInterceptor(new HttpRequestInterceptor() {
            @Override
            public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
                request.addHeader("Accept-Encoding", "gzip");
//                request.addHeader("Authorization", "Basic " + new BASE64Encoder().encode(("api:"+apiKey).getBytes("utf-8")));
            }
        });

        client.getParams().setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 30000);
        client.getParams().setIntParameter(CoreConnectionPNames.SO_TIMEOUT, 30000);

        HttpGet request = new HttpGet("https://sms-api.luosimao.com/v1/status.json");

        ByteArrayOutputStream bos = null;
        InputStream bis = null;
        byte[] buf = new byte[10240];

        String content = null;
        try {
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                bis = response.getEntity().getContent();
                Header[] gzip = response.getHeaders("Content-Encoding");

                bos = new ByteArrayOutputStream();
                int count;
                while ((count = bis.read(buf)) != -1) {
                    bos.write(buf, 0, count);
                }
                bis.close();

                if (gzip.length > 0 && gzip[0].getValue().equalsIgnoreCase("gzip")) {
                    GZIPInputStream gzin = new GZIPInputStream(new ByteArrayInputStream(bos.toByteArray()));
                    StringBuffer sb = new StringBuffer();
                    int size;
                    while ((size = gzin.read(buf)) != -1) {
                        sb.append(new String(buf, 0, size, "utf-8"));
                    }
                    gzin.close();
                    bos.close();

                    content = sb.toString();
                } else {
                    content = bos.toString();
                }

                JSONObject data = new JSONObject(content);
                if (data.optInt("error") == 0) {
                	return data.optInt("deposit");
                } else {
                	return -1;
                }
            } else {
                System.out.println("error code is " + response.getStatusLine().getStatusCode());
                return -1;
            }
            //return content;
        } finally {
            if (bis != null) {
                try {
                    bis.close();// 最后要关闭BufferedReader
                } catch (Exception e) {
                }
            }
        }
    }
}
