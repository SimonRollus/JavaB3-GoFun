package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.model.Order;

public interface OrderDataAccess {

    Order save (Order order);
    void setOrderPaid(Integer orderID);

}
