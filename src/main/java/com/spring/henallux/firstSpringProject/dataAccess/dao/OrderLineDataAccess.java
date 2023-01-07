package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderLineEntity;
import com.spring.henallux.firstSpringProject.model.OrderLine;

import java.util.ArrayList;
import java.util.List;

public interface OrderLineDataAccess {

    OrderLine save(OrderLine orderLine);
    List<OrderLineEntity> saveAll(ArrayList<OrderLine> orderLines);

}
