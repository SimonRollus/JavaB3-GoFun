package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderLineEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.OrderLineRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.OrderLine;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderLineDAO implements OrderLineDataAccess {

    private OrderLineRepository orderLineRepository;

    private ProviderConverter providerConverter;

    public OrderLineDAO(OrderLineRepository orderLineRepository, ProviderConverter providerConverter) {
        this.orderLineRepository = orderLineRepository;
        this.providerConverter = providerConverter;
    }

    public OrderLine save (OrderLine orderLine){
        OrderLineEntity orderLineEntity = providerConverter.orderLineModelToOrderLineEntity(orderLine);
        orderLineEntity = orderLineRepository.save(orderLineEntity);
        return providerConverter.orderLineEntityToOrderLineModel(orderLineEntity);
    }

    @Transactional
    public List<OrderLineEntity> saveAll(ArrayList<OrderLine> orderLines){
        ArrayList<OrderLineEntity> orderLineEntities = new ArrayList<>();
        for(OrderLine orderLine : orderLines){
            OrderLineEntity orderLineEntity = providerConverter.orderLineModelToOrderLineEntity(orderLine);
            orderLineEntities.add(orderLineEntity);
        }
        return orderLineRepository.saveAll(orderLineEntities);
    }



}
