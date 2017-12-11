package com.mq.test.services;

import com.mq.test.model.Costumers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.mq.test.storage.MessageStorage;

@Service
public class KafkaConsumer {
	private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

	@Autowired
	MessageStorage storage;
	
	@KafkaListener(topics="${jsa.kafka.topic}")
    public void processMessage(Costumers costumers) {
		log.info("received content = '{}'", costumers);
		storage.put(costumers);
    }
}
