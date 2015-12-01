package com.huanduguihua.exception;

/**
 * 参数异常
 * @author chenyuanxian
 * @date 2015-09-26 10:40:58
 */
public class DatabaseException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7779226190889344565L;

	public DatabaseException() {
        super();
    }
	
    public DatabaseException(String message) {
        super(message);
    }
    
    public DatabaseException(Throwable cause) {
        super(cause);
    }
    
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
