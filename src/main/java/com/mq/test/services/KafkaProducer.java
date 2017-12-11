package com.mq.test.services;

import com.mq.test.model.Costumers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
	private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
	
	@Autowired
	private KafkaTemplate<String, Costumers> kafkaTemplate;
	
	@Value("${jsa.kafka.topic}")
	String kafkaTopic = "jsa-test";
	
	public void send(Costumers costumers) {
	    log.info("sending data='{}'", costumers);
	    kafkaTemplate.send(kafkaTopic, costumers);
	}
}
