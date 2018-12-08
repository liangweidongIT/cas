package com.demo.cas.listenter;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.demo.cas.event.MessageEvent;

@Component
@Slf4j
public class MessageEventListener{
	
	@EventListener(value=MessageEvent.class)
	public void onApplicationEvent(MessageEvent event) {
		for (int i = 0; i < 10000; i++) {
			log.info("发布领域事件:{}-{}-{}-{}",event.getMsg(),event.getEmail(),Thread.currentThread().getName(),this.hashCode());
		}
	}

}
