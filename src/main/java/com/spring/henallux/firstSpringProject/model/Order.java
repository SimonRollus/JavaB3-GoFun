package com.spring.henallux.firstSpringProject.model;

import java.util.Date;
import javax.validation.constraints.*;

public class Order {

    @NotNull
    @Min(value = 1)
    private Integer orderID;

    @FutureOrPresent
    @NotNull
    private Date orderDate;

    @NotNull
    private Boolean isOrderPaid;

    private Customer customer;

    public Order() {
    }

    public Order(Integer orderID, Date orderDate, Boolean is_order_paid, Customer customer) {
        setOrderID(orderID);
        setOrderDate(orderDate);
        setOrderPaid(is_order_paid);
        setCustomer(customer);
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

    public Customer getCustomer() {
        return customer;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderPaid(Boolean isOrderPaid) {
        this.isOrderPaid = isOrderPaid;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
