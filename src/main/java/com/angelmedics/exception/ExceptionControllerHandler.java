package com.angelmedics.exception;

import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//统一的异常返回json
@ControllerAdvice
public class ExceptionControllerHandler {
	private Logger logger = LoggerFactory.getLogger(ExceptionControllerHandler.class);

	@Resource(name = "messageSource")
	private MessageSource message;

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse errorResponse(Exception exception) {
		logger.error(exception.getMessage());
		ErrorResponse errResponse = new ErrorResponse();
		errResponse.setMessage(exception.getMessage());
		errResponse.setCode(100000);
		if (exception instanceof KukahomeException) {
			KukahomeException kukaEx = (KukahomeException) exception;
			if (!StringUtils.isEmpty(kukaEx.getCode())) {

				errResponse.setCode(kukaEx.getCode());
				try {
					errResponse.setMessage(message.getMessage("error."+kukaEx.getCode(),
							null, Locale.getDefault()));
				} catch (Exception e) {
					logger.info("从配置文件中获取错误代码失败！");
				}

			}

		}
		return errResponse;
	}

}
