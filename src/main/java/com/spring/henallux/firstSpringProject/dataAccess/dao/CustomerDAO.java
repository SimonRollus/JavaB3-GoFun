package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.CustomerEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.CustomerRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerDAO  implements CustomerDataAccess{

    private CustomerRepository customerRepository;

    private ProviderConverter providerConverter;

    @Autowired
    public CustomerDAO(CustomerRepository customerRepository, ProviderConverter providerConverter) {
        this.customerRepository = customerRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public Customer findByUsername(String username) {
        CustomerEntity customerEntity = customerRepository.findByUsername(username);
        if(customerEntity == null)
            return null;
        return providerConverter.customerEntityToCustomerModel(customerEntity);
    }

    public Customer findByUsernameOrEmail(String username, String email){
        CustomerEntity customerEntity = customerRepository.findByUsernameOrEmail(username, email);
        if(customerEntity == null)
            return null;
        return providerConverter.customerEntityToCustomerModel(customerEntity);
    }

    public Customer save(Customer customer) {
        CustomerEntity customerEntity = providerConverter.customerModelToCustomerEntity(customer);
        customerEntity = customerRepository.save(customerEntity);
        return providerConverter.customerEntityToCustomerModel(customerEntity);
    }


}
