package com.demo.cas.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MethodAop {
	
	@Pointcut("execution(* com.demo.cas.controler.IndexControler.index(..))")
	public void logMethodAspect() {
		
	}
	
	@Around("logMethodAspect()")
	public Object aroundMethodLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object result = null;
		try {
			System.out.println("method前置通知！");
			result = proceedingJoinPoint.proceed();
			System.out.println("method返回通知:" + result);
		} catch (Throwable e) {
			System.out.println("method异常通知！");
			throw e;
		}
		System.out.println("method后置通知！");
		return result;
	}
}
