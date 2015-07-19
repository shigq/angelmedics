package com.angelmedics.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogAspect {

	private Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Pointcut("execution(* com.angelmedics.controller.*.*(..))")
	private void pointCutMethod() {

	}

	// // 声明前置通知
	// @Before("pointCutMethod()")
	// public void doBefore(JoinPoint joinPoint) {
	// logger.info("开始执行方法:" + (joinPoint.getTarget().getClass().getName() + "."
	// + joinPoint.getSignature().getName()));
	// }
	// // 声明最终通知
	// @After("pointCutMethod()")
	// public void doAfter(JoinPoint joinPoint) {
	// logger.info("结束执行方法:" + (joinPoint.getTarget().getClass().getName() + "."
	// + joinPoint.getSignature().getName()));
	// }
	// // 声明后置通知
	// @AfterReturning(pointcut = "pointCutMethod()", returning = "result")
	// public void doAfterReturning(String result) {
	// System.out.println("后置通知");
	// System.out.println("---" + result + "---");
	// }
	//
	// 声明例外通知
	@AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
		logger.info("执行方法异常:"
				+ (joinPoint.getTarget().getClass().getName() + "." + joinPoint
						.getSignature().getName()));
		logger.error(e.getMessage());
	}

	// 声明环绕通知
	@Around("pointCutMethod()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("开始执行方法:"
				+ (joinPoint.getTarget().getClass().getName() + "." + joinPoint
						.getSignature().getName()));
		Object o = joinPoint.proceed();
		logger.info("结束执行方法:"
				+ (joinPoint.getTarget().getClass().getName() + "." + joinPoint
						.getSignature().getName()));
		return o;
	}
}