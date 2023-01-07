package com.spring.henallux.firstSpringProject.model;

import javax.validation.constraints.*;

public class OrderLine {

    @NotNull
    @Min(value = 1)
    private Integer orderLineID;

    @NotNull
    @Min(value = 1)
    private Float realPrice;

    @NotNull
    @Min(value = 1)
    private Integer quantity;

    private Order order;

    private Game game;

    public OrderLine(Integer orderLineID, Float realPrice, Integer quantity, Order order, Game game){
        setOrder(order);
        setOrderLineID(orderLineID);
        setRealPrice(realPrice);
        setGame(game);
        setQuantity(quantity);
    }

    public OrderLine() {
    }

    public Integer getOrderLineID() {
        return orderLineID;
    }

    public Float getRealPrice() {
        return realPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Order getOrder() {
        return order;
    }

    public Game getGame() {
        return game;
    }

    public float getSubTotalPrice(){
        return this.realPrice * this.quantity;
    }

    public void setOrderLineID(Integer orderLineID) {
        this.orderLineID = orderLineID;
    }

    public void setRealPrice(Float realPrice) {
        this.realPrice = realPrice;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
