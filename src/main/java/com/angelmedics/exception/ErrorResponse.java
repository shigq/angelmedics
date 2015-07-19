package com.angelmedics.exception;

public class ErrorResponse {
	// 错误代码
	private int code;
	// 错误信息
	private String message;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorResponse(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public ErrorResponse(int code) {
		this.code = code;
	}

	public ErrorResponse() {

	}
}
