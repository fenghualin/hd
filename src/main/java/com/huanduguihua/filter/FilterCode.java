package com.huanduguihua.filter;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jsoup.select.Evaluator.IsEmpty;


/**
 * 过滤中文乱码
 * @author liusen
 */
public class FilterCode implements Filter {

	protected String encoding;
	protected FilterConfig filterConfig;
	private List<String> urlMap;
	private String stc;
	
	@Override
	public void destroy() {
		this.encoding = null;
		this.filterConfig = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		request.setAttribute("stc", stc);
		System.out.println("设置stc为：" + stc);
		filterChain.doFilter(request, response);
		
		String uri = httpRequest.getRequestURI();
		if (uri.indexOf(".") == -1) {
			System.out.println("禁止缓存，uri: " + httpRequest.getRequestURI());
			httpResponse.addHeader("Pragma","no-cache");
			httpResponse.setHeader("Cache-Control","no-cache");
			httpResponse.setHeader("Expires","0");
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		urlMap = new ArrayList<String>() {
			
			private static final long serialVersionUID = 1L;
			
			@Override
			public boolean add(String e) {
				if(e != null)
					e = e.replaceAll("[*]", "[^^]*");
				return super.add(e);
			}
		};
		urlMap.add("");
		
		stc = filterConfig.getInitParameter("stc");
	}

}
