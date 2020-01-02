package com.subra.springactivemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	@JmsListener(destination="mypractice.queue")
	public void consume(String message){
		System.out.println("111consume the message:" + message );
	}
	
}
