package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    @Modifying
    @Query("UPDATE OrderEntity o set o.isOrderPaid = true where o.orderID =: order_id")
    void setOrderPaid(@Param("order_id")Integer orderID);

}
