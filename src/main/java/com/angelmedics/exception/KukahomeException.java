package com.angelmedics.exception;

public class KukahomeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	// 错误代码
	private int code;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public KukahomeException(String msg, Throwable t) {
		super(msg, t);
	}

	public KukahomeException(String msg) {
		super(msg);
	}
	
	public KukahomeException(int code,String msg) {
		super(msg);
		this.code=code;
	}
	public KukahomeException(int code) {
		this.code=code;
	}

}
