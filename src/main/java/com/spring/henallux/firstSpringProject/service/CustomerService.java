package com.spring.henallux.firstSpringProject.service;


import com.spring.henallux.firstSpringProject.dataAccess.dao.CustomerDataAccess;
import com.spring.henallux.firstSpringProject.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerDataAccess customerDAO;

    @Autowired
    public CustomerService(CustomerDataAccess customerDAO) {
        this.customerDAO = customerDAO;
    }

    public Boolean saveCustomer(Customer customer){
        Customer customerExists = customerDAO.findByUsernameOrEmail(customer.getUsername(), customer.getEmail());
        if(customerExists != null){
            return false;
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        customer.setAuthorities("ROLE_USER");
        customer.setCredentialsNonExpired(true);
        customer.setEnabled(true);
        customer.setAccountNonLocked(true);
        customer.setAccountNonExpired(true);
        customerDAO.save(customer);
        return true;
    }

}
