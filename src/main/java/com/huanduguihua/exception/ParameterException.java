package com.huanduguihua.exception;

/**
 * 参数异常
 * @author chenyuanxian
 * @date 2015-09-26 10:30:58
 */
public class ParameterException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7779226190889344565L;

	public ParameterException() {
        super();
    }
	
    public ParameterException(String message) {
        super(message);
    }
    
    public ParameterException(Throwable cause) {
        super(cause);
    }
    
    public ParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}
