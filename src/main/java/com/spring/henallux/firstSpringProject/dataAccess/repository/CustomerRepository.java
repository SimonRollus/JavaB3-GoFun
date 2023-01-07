package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository <CustomerEntity, Integer> {

    CustomerEntity findByUsername(String username);

    CustomerEntity findByUsernameOrEmail(String username, String email);
}
