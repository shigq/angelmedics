package com.angelmedics.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

import com.angelmedics.exception.CaptchaException;

public class CustomerPasswordAuthenticationFilter extends
		UsernamePasswordAuthenticationFilter {
	private static final String SPRING_SECURITY_CAPTCHA_KEY = "captchaCode";
	private static final String KAPTCHA_SESSION_KEY =com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {

		String requestCaptcha = request
				.getParameter(SPRING_SECURITY_CAPTCHA_KEY);
		String genCaptcha = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
		//验证码只是使用一次
		request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

		logger.info("开始校验验证码，生成的验证码为：" + genCaptcha + " ，输入的验证码为："
				+ requestCaptcha);

		/*if (StringUtils.isEmpty(requestCaptcha)  ||!genCaptcha.equals(requestCaptcha)) {
			throw new CaptchaException(
					"请正确输入验证码");
		}*/
		return super.attemptAuthentication(request, response);

	}
}
