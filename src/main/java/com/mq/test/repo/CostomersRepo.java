/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mq.test.repo;

import com.dev.nev.bases.BaseRepositories;
import com.mq.test.model.Costumers;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CostomersRepo extends BaseRepositories {
    
    public void insert(Costumers costumers){
        entityManager.merge(costumers);
    }
    
    public List<Costumers> doList(){
        return entityManager.createQuery("from Costumer", Costumers.class).getResultList();
    }
}
