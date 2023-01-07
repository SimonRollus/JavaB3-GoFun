package com.spring.henallux.firstSpringProject.service;


import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderDataAccess;
import com.spring.henallux.firstSpringProject.dataAccess.dao.OrderLineDataAccess;
import com.spring.henallux.firstSpringProject.model.Customer;
import com.spring.henallux.firstSpringProject.model.Order;
import com.spring.henallux.firstSpringProject.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Service
public class PurchaseService {

    private OrderDataAccess orderDAO;

    private OrderLineDataAccess orderLineDAO;

    @Autowired
    public PurchaseService(OrderDataAccess orderDAO, OrderLineDataAccess orderLineDAO) {
        this.orderDAO = orderDAO;
        this.orderLineDAO = orderLineDAO;
    }

    public Order savePurchase(HashMap<Integer, OrderLine> games, Customer customer){
        Order order = new Order(null,new Date(),false,customer);
        Order orderFromDB = orderDAO.save(order);

        ArrayList<OrderLine> orderLines = new ArrayList<>();
        for(OrderLine orderLine : games.values()){
            orderLine.setOrder(orderFromDB);
            orderLines.add(orderLine);
        }
        orderLineDAO.saveAll(orderLines);

        return orderFromDB;

    }

    public void modifyOrderToPaid(Integer orderID){
        orderDAO.setOrderPaid(orderID);
    }





}
