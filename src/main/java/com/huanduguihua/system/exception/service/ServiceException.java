/**
 * com.cdkuxin.weixin.system.exception.service
 * ServiceException.java
 * 
 * 2013-12-18-下午1:52:32
 *  2013成都酷信科技公司-版权所有
 * 
 */
package com.huanduguihua.system.exception.service;

import com.huanduguihua.system.exception.BaseException;


/**
 * 
 * Service层处理异常
 * 一般的service要抛出异常的话，只需要抛出此异常即可，
 * 若需要抛出更详细的异常，继承此异常即可
 * 
 * @author KangJia
 * @version 1.0.0
 * 
 */
public class ServiceException extends BaseException {
	
	//错误代码，包含在com.cdkuxin.weixin.util.ErrorCode.class中
	private Integer errorCode = 0;	
	
	public ServiceException() {
		super();
	}
	public ServiceException(Integer errorCode) {
		super();
		this.errorCode = errorCode;
	}
	public ServiceException(String msg, Integer errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}
	
	@Override
	public void printStackTrace() {
		super.printStackTrace();
	}

	public Integer getErrorCode() {
		return errorCode;
	}
	public String getMessage() {
		//return ErrorCode.get(errorCode);
		return null;
	}
}
