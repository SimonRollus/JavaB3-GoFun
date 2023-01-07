package com.spring.henallux.firstSpringProject.dataAccess.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="`order`")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="order_id")
    private Integer orderID;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "is_order_paid")
    private Boolean isOrderPaid;

    @JoinColumn(name = "customer_fk", referencedColumnName = "customer_id")
    @ManyToOne
    private CustomerEntity customer;

    public OrderEntity() {
    }

    public Integer getOrderID() {
        return orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Boolean isOrderPaid() {
        return isOrderPaid;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderPaid(Boolean orderPaid) {
        isOrderPaid = orderPaid;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
}
