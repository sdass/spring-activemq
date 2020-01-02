package com.subra.springactivemq;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class Config {

	@Value("${url.of.my.amq.server}")
	String brokerUrl;
	@Bean
	@Primary
	public Queue queue(){
		return new ActiveMQQueue("mypractice.queue");
	}
	
	@Bean
	@Qualifier("preexist")
	public Queue queueTest(){
		return new ActiveMQQueue("TestQue");
	}
	
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory(){
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		System.out.println("brokerUrl= >" + brokerUrl);
		factory.setBrokerURL(brokerUrl);
		return factory;
	}

	public JmsTemplate jmsTemplate(){
		return new JmsTemplate(activeMQConnectionFactory());
	}
}
