package com.mq.test;

import com.mq.test.model.Costumers;
import com.mq.test.services.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApacheKafkaApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringApacheKafkaApplication.class, args);
	}

    
}
