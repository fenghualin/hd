/**
 * IPM 知识产权管理软件
 * test
 * HttpHelper.java
 * 
 * 2013-10-12-上午11:12:59
 *  2013成都酷信科技公司-版权所有
 * 
 */
package com.huanduguihua.system.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * HttpHelper
 * 
 * kin
 * kin
 * 2013-10-12 上午11:12:59
 * 
 * @author KangJia
 * @version 1.0.0
 * 
 */
public class HttpHelper {
//	public static final String GET_URL = "http://localhost/weixin/Test2";
//
//	public static final String POST_URL = "http://www.xiaohuangji.com/ajax.php";

	public static String readContentFromGet(String url) {
		try {
			
		
		// 拼凑get请求的URL字串，使用URLEncoder.encode对特殊和不可见字符进行编码
		String getURL = url;
		String content = "";
		URL getUrl = new URL(getURL);
		// 根据拼凑的URL，打开连接，URL.openConnection函数会根据URL的类型，
		// 返回不同的URLConnection子类的对象，这里URL是一个http，因此实际返回的是HttpURLConnection
		HttpURLConnection connection = (HttpURLConnection) getUrl
				.openConnection();
		// 进行连接，但是实际上get request要在下一句的connection.getInputStream()函数中才会真正发到
		// 服务器
		connection.connect();
		// 取得输入流，并使用Reader读取
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream(), "utf-8"));// 设置编码,否则中文乱码
//		//
//		//
//		//
		String lines;
		while ((lines = reader.readLine()) != null) {
			// lines = new String(lines.getBytes(), "utf-8");
			//
			content += lines;
		}
		reader.close();
		// 断开连接
		connection.disconnect();
//		//
//		//
//		//
		return content;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String readContentFromPost(String url, Map<String, String> params) {
		String param = "";
		for (String key : params.keySet()) {
			
			try {
				param += (key +"="+URLEncoder.encode(params.get(key), "utf-8") + "&");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("read.url: " + url);
		System.out.println("read.param: " + param);
//		return readFromPost(url, param);
		return doPost(url, param);
	}
	
	public static String readContentFromPost(String url, String param) {
		try {
			
		
		// Post请求的url，与get不同的是不需要带参数
		URL postUrl = new URL(url);
		String responseContent = "";
		// 打开连接
		HttpURLConnection connection = (HttpURLConnection) postUrl
				.openConnection();
		// Output to the connection. Default is
		// false, set to true because post
		// method must write something to the
		// connection
		// 设置是否向connection输出，因为这个是post请求，参数要放在
		// http正文内，因此需要设为true
		connection.setDoOutput(true);
		// Read from the connection. Default is true.
		connection.setDoInput(true);
		// Set the post method. Default is GET
		connection.setRequestMethod("POST");
		// Post cannot use caches
		// Post 请求不能使用缓存
		connection.setUseCaches(false);
		// This method takes effects to
		// every instances of this class.
		// URLConnection.setFollowRedirects是static 函数，作用于所有的URLConnection对象。
		// connection.setFollowRedirects(true);

		// This methods only
		// takes effacts to this
		// instance.
		// URLConnection.setInstanceFollowRedirects是成员函数，仅作用于当前函数
		connection.setInstanceFollowRedirects(true);
		// Set the content type to urlencoded,
		// because we will write
		// some URL-encoded content to the
		// connection. Settings above must be set before connect!
		// 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
		// 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
		// 进行编码
//		connection.setRequestProperty("Content-Type",
//				"application/x-www-form-urlencoded");
		connection.setRequestProperty("Content-Type",
	              "application/json;charset=UTF-8");
		// 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
		// 要注意的是connection.getOutputStream会隐含的进行connect。
		connection.connect();
		DataOutputStream out = new DataOutputStream(
				connection.getOutputStream());
		// The URL-encoded contend
		// 正文，正文内容其实跟get的URL中'?'后的参数字符串一致
		String content = param;
		// DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写道流里面
		out.writeBytes(content);
		out.write(content.getBytes("utf-8")); 
		out.flush();
		out.close();// flush and close
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream(), "utf-8"));// 设置编码,否则中文乱码
		String line = "";
//		//
//		//
//		//
		while ((line = reader.readLine()) != null) {
			// line = new String(line.getBytes(), "utf-8");
			//
			responseContent += line;
		}
//		//
//		//
//		//
		reader.close();
		connection.disconnect();
		return responseContent;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String readFromPost(String POST_URL, String menuJson) {
		try {
//			String POST_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+accessToken;
			
			// Post请求的url，与get不同的是不需要带参数
	        URL postUrl = new URL(POST_URL);
	        // 打开连接
	        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
	        // http正文内，因此需要设为true
	        connection.setDoOutput(true);
	        connection.setDoInput(true);
	        connection.setRequestMethod("POST");
	        connection.setUseCaches(false);
	        connection.setInstanceFollowRedirects(true);
//	        connection.setRequestProperty("Content-Type",
//	                "application/x-www-form-urlencoded");
	        connection.setRequestProperty("Content-Type",
	              "application/json;charset=UTF-8");
	        // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
	        // 要注意的是connection.getOutputStream会隐含的进行connect。
	        connection.connect();
	        DataOutputStream out = new DataOutputStream(connection
	                .getOutputStream());
	        // The URL-encoded contend
	        // 正文，正文内容其实跟get的URL中'?'后的参数字符串一致
//	        String content = "key=j0r53nmbbd78x7m1pqml06u2&type=1&toemail=jiucool@gmail.com" + "&activatecode=" + URLEncoder.encode("久酷博客", "utf-8");
	       
	        // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写道流里面
	       	//
	        out.write(menuJson.getBytes("utf-8")); 
	        out.flush();
	        out.close(); // flush and close
	        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));//设置编码,否则中文乱码
	        String line="";
	        //
	        //
	        //
	        String lines = "";
	        while ((line = reader.readLine()) != null){
	            //line = new String(line.getBytes(), "utf-8");
	            //
	            lines += line;
	        }
	        //
	        //
	        //
	        reader.close();
	        connection.disconnect();
	        return lines;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	
	public static String encode(String s) {
		try {
			return URLEncoder.encode(s, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			return s;
		}
	}
	
	public static Integer getDomainAid(HttpServletRequest request) {
		try {
			String serverName = request.getServerName();
			request.setAttribute("_domain", serverName);
			request.setAttribute("_basePath", request.getScheme()+"://"+request.getServerName()+request.getContextPath());
			Pattern p = Pattern.compile("[0-9]+[\\.]{1}");
			Matcher m = p.matcher(serverName);
		
			if (m.find()) {
				String key = serverName.substring(m.start(), m.end()-1);
				return Integer.valueOf(key);
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} return 0;
	}
	
	public static String doPost(String url, String param){     
	       try {
	    	   /**   
	            * 首先要和URL下的URLConnection对话。 URLConnection可以很容易的从URL得到。比如： // Using   
	            *  java.net.URL and //java.net.URLConnection   
	            *   
	            *  使用页面发送请求的正常流程：在页面http://www.faircanton.com/message/loginlytebox.asp中输入用户名和密码，然后按登录， 
	            *  跳转到页面http://www.faircanton.com/message/check.asp进行验证 
	            *  验证的的结果返回到另一个页面 
	            *   
	            *  使用java程序发送请求的流程：使用URLConnection向http://www.faircanton.com/message/check.asp发送请求 
	            *  并传递两个参数：用户名和密码 
	            *  然后用程序获取验证结果 
	            */    
	           URL realUrl = new URL(url);     
	           URLConnection connection = realUrl.openConnection();     
	           /**   
	            * 然后把连接设为输出模式。URLConnection通常作为输入来使用，比如下载一个Web页。   
	            * 通过把URLConnection设为输出，你可以把数据向你个Web页传送。下面是如何做：   
	            */    
	           connection.setDoOutput(true);     
	           /**   
	            * 最后，为了得到OutputStream，简单起见，把它约束在Writer并且放入POST信息中，例如： ...   
	            */    
	           OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "8859_1");     
	           out.write(param); //向页面传递数据。post的关键所在！     
	           // remember to clean up     
	           out.flush();     
	           out.close();     
	           /**   
	            * 这样就可以发送一个看起来象这样的POST：    
	            * POST /jobsearch/jobsearch.cgi HTTP 1.0 ACCEPT:   
	            * text/plain Content-type: application/x-www-form-urlencoded   
	            * Content-length: 99 username=bob password=someword   
	            */    
	           // 一旦发送成功，用以下方法就可以得到服务器的回应：     
	           String sCurrentLine;     
	           String sTotalString;     
	           sCurrentLine = "";     
	           sTotalString = "";     
	           InputStream l_urlStream;     
	           l_urlStream = connection.getInputStream();     
	           // 传说中的三层包装阿！     
	           BufferedReader l_reader = new BufferedReader(new InputStreamReader(     
	                   l_urlStream));     
	           while ((sCurrentLine = l_reader.readLine()) != null) {     
	               sTotalString += sCurrentLine + "/r/n";     
	       
	           }     
	           System.out.println(sTotalString); 
	           return sTotalString;
		} catch (Exception e) {
			
			e.printStackTrace();
			return "error";
	    }  

		}
	
	public static boolean responseFile(File file, HttpServletResponse response) {
		try {
			if (!file.exists() || response == null) return false;
			
			response.setContentType("application/vnd.ms-excel");
			response.setContentLength(Integer.valueOf(file.length()+""));
			FileUtils.copyFile(file, response.getOutputStream());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static boolean responseWord(File file, HttpServletResponse response) {
		try {
			if (!file.exists() || response == null) return false;
			
			response.setContentType("application/docx");
			response.setContentLength(Integer.valueOf(file.length()+""));
			response.setHeader("Content-disposition",  
                    "attachment; filename=" + file.getName() );
			FileUtils.copyFile(file, response.getOutputStream());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static String getClassPath() {
		URL path = HttpHelper.class.getClassLoader().getResource("../../WEB-INF");
		
		String str = path.getFile();
		
		System.out.println("URL.getFile: " + str);
		
		int index = str.indexOf("/");
		if (index == 0) {
			return str.substring(index+1, str.length());
		} else {
			return str;
		}
	}
}
