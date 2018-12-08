package com.demo.cas.event;

import lombok.Getter;
import lombok.Setter;

import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
@Getter
@Setter
public class MessageEvent extends ApplicationEvent{
	
	private String msg;
	
	private String email;
	
	public MessageEvent(Object source,String msg,String email) {
		super(source);
		this.msg = msg;
		this.email = email;
	}

}
