package com.btc.spring.aopdemo.repository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author Ali Katkar
 */
@Repository
public class CustomerRepository {
    
    public String getCustomer() throws Exception{
        
//        if(true){
//            throw new Exception("my exception");
//        }
        return "my customer";
    }
    
}
