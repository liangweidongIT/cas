package com.demo.cas.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(4)
public class LogAop {
	
	@Pointcut("@annotation(com.demo.cas.annotation.MyAnnotation)")
	public void logAspect() {
		
	}
	
	@Around("logAspect()")
	public Object aroundLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object result = null;
		try {
			System.out.println("注解——前置通知！");
			result = proceedingJoinPoint.proceed();
			System.out.println("注解——返回通知:" + result);
		} catch (Throwable e) {
			System.out.println("注解——异常通知！");
			throw e;
		}
		System.out.println("注解——后置通知！");
		return result;
	}
}
