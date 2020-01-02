package com.subra.springactivemq;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping("/rest/publish")
	public class HelloResource {

		@Autowired
		JmsTemplate jmsTemplate;
		
		@Autowired
		Queue queue;
		
		@Autowired @Qualifier("preexist")
		Queue queue2;
		
		@GetMapping("/{message}")
		public String publish(@PathVariable("message") final String message){
			
			jmsTemplate.convertAndSend(queue, message);
			System.out.println("---------------------");
			jmsTemplate.convertAndSend(queue2, "arbitrary-" + message);
			return "sent to quue successfully";
		}
	}
	

