package com.huanduguihua.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
@Component
public class ReportHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ex", ex);
		
		// 根据不同错误转向不同页面
		if (ex instanceof ParameterException) {
			return new ModelAndView("exception/exception-parameter", model);
		} else if (ex instanceof BusinessException) {
			return new ModelAndView("exception/exception-business", model);
		} else if (ex instanceof DatabaseException) {
			return new ModelAndView("exception/exception-database", model);
		} else {
			return new ModelAndView("exception/exception", model);
		}
	}

}
