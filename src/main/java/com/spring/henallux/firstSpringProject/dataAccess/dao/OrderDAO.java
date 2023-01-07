package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.OrderRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderDAO implements OrderDataAccess {

    private OrderRepository orderRepository;

    private ProviderConverter providerConverter;

    public OrderDAO(OrderRepository orderRepository, ProviderConverter providerConverter) {
        this.orderRepository = orderRepository;
        this.providerConverter = providerConverter;
    }

    @Transactional
    public Order save(Order order){
        OrderEntity orderEntity = providerConverter.orderModelToOrderEntity(order);
        orderEntity = orderRepository.save(orderEntity);
        return providerConverter.orderEntityToOrderModel(orderEntity);
    }

    @Transactional
    public void setOrderPaid(Integer orderID){
        orderRepository.setOrderPaid(orderID);
    }



}
