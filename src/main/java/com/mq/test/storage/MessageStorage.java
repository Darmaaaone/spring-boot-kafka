package com.mq.test.storage;

import java.util.ArrayList;
import java.util.List;

import com.mq.test.model.Costumers;
import org.springframework.stereotype.Component;

@Component
public class MessageStorage {
	
	private List<Costumers> storage = new ArrayList<Costumers>();
	
	public void put(Costumers costumers){
		storage.add(costumers);
	}

	public void clear(){
		storage.clear();
	}
}
