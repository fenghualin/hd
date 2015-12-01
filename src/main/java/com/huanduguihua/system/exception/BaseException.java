/**
 * com.cdkuxin.weixin.system.exception
 * BaseException.java
 * 
 * 2013-12-18-下午1:51:13
 *  2013成都酷信科技公司-版权所有
 * 
 */
package com.huanduguihua.system.exception;

/**
 * 
 * 项目最基础的异常
 * 
 * @author KangJia
 * @version 1.0.0
 * 
 */
public class BaseException extends Exception {
	private static final long serialVersionUID = 7528229240203861036L;
	
	public BaseException() {
		super();
	}
	
	public BaseException(String arg0) {
		super(arg0);
	}
	public BaseException(Throwable arg0) {
		super(arg0);
	}
	public BaseException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
	}
}
