package com.spring.henallux.firstSpringProject.service;

import com.spring.henallux.firstSpringProject.dataAccess.dao.CustomerDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.CustomerDataAccess;
import com.spring.henallux.firstSpringProject.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomerDetailsServiceImplementation implements UserDetailsService {

    private CustomerDataAccess customerDAO;

    @Autowired
    public CustomerDetailsServiceImplementation(CustomerDataAccess customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerDAO.findByUsername(username);
        if(customer != null){
            return customer;
        }
        throw new UsernameNotFoundException("Customer not found");
    }
}
