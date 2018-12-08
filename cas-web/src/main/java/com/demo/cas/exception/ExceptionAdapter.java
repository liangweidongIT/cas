package com.demo.cas.exception;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ExceptionAdapter {
	
	@ResponseBody
	@ExceptionHandler(value=NumberFormatException.class)
	public Map<String,String> handleNumException(Exception e) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("异常错误码-数字", "500");
		log.info("||||||" + e.getMessage());
		return map;
	}
	
	@ResponseBody
	@ExceptionHandler(value=NullPointerException.class)
	public Map<String,String> handleNullException(Exception e) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("异常错误码-空指针", "500");
		log.info("||||||" + e.getMessage());
		return map;
	}
	
	@ResponseBody
	@ExceptionHandler(value=Exception.class)
	public Map<String,String> handleException(Exception e) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("异常错误码-总异常", "500");
		log.info("||||||" + e.getMessage());
		return map;
	}
}
