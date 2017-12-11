/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mq.test.services;

import com.mq.test.model.Costumers;
import com.mq.test.repo.CostomersRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConstumerService {
    
    @Autowired
    CostomersRepo costomersRepo;
    
    public void doInsert(Costumers costumers){
        costomersRepo.insert(costumers);
    }
    
    public List<Costumers> doList(){
        return costomersRepo.doList();
    }
}
