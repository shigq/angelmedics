package com.angelmedics.exception;

import org.springframework.security.core.AuthenticationException;

public class CaptchaException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CaptchaException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

}