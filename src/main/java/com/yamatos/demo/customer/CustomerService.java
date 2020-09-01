package com.yamatos.demo.customer;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class CustomerService {
    
    @Autowired
    private CustomerRepository repo;
     
    public List<Customers> listAll() {
        return repo.findAll();
    }
     
    public void save(Customers customer) {
        repo.save(customer);
    }
     
    public Customers get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}