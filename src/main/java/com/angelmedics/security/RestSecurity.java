package com.angelmedics.security;

import org.springframework.http.HttpStatus;

public class RestSecurity {
	//状态
	private HttpStatus statusCode;
	//信息
	private String message;
	//是否验证通过
	private boolean success;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public HttpStatus getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}


	
}
