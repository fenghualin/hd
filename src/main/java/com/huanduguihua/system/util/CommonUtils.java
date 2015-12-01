/**
 * com.huanduguihua.system.util
 * SystemUtils.java
 * 
 * 2014-5-14-下午3:56:02
 *  2014成都酷信科技公司-版权所有
 * 
 */
package com.huanduguihua.system.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 
 * SystemUtils
 * 
 * kin
 * kin
 * 2014-5-14 下午3:56:02
 * 
 * @author KangJia
 * @version 1.0.0
 * 
 */
public class CommonUtils {

	public static String encodeUtf8(String url) {
		try {
			return URLEncoder.encode(url, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
	
}
