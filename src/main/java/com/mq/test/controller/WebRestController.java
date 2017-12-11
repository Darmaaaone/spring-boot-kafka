package com.mq.test.controller;

import com.dev.nev.bases.BaseController;
import com.mq.test.model.Costumers;
import com.mq.test.services.ConstumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mq.test.services.KafkaProducer;
import com.mq.test.storage.MessageStorage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/jsa/kafka")
public class WebRestController extends BaseController{

    @Autowired
    KafkaProducer producer;

    @Autowired
    MessageStorage storage;

    @Autowired
    ConstumerService constumerService;

    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> doAdd(@RequestBody Map<String, Object> request){
        Map<String,Object> responseResult = new HashMap<>();
        try {
            Costumers costumers = objectMapper.convertValue(request.get("add"), Costumers.class);
            producer.send(costumers);
            responseResult.put("result", Boolean.TRUE);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.put("result", Boolean.FALSE);
        }
        return new ResponseEntity<>(responseResult, HttpStatus.OK);
    }    
    
    public void doAdd(Costumers costumers){
         storage.put(costumers);
    }
}
