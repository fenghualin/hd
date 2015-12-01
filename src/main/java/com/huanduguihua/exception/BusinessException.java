package com.huanduguihua.exception;

/**
 * 系统业务异常
 * @author chenyuanxian
 * @date 2015-09-26 10:20:58
 */
public class BusinessException extends Exception {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 5016167047838727257L;
	
	private String code;

    public BusinessException() {
        super();
    }
    
    public BusinessException(String message) {
        super(message);
    }
    
	public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    } 
	
    public BusinessException(Throwable cause) {
        super(cause);
    }
    
	public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

	public BusinessException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}
    
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}