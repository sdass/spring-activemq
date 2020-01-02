package com.subra.springactivemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerTQ {

	@JmsListener(destination="TestQue")
	public void consume(String message){
		System.out.println("222TQ: consume the message:" + message );
	}
	
}
