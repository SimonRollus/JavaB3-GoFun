package com.spring.henallux.firstSpringProject.dataAccess.entity;


import javax.persistence.*;

@Entity
@Table(name="order_line")
public class OrderLineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_line_id")
    private Integer orderLineID;

    @Column(name="real_price")
    private Float realPrice;

    @Column(name="quantity")
    private Integer quantity;

    @JoinColumn(name="order_fk", referencedColumnName = "order_id")
    @ManyToOne
    private OrderEntity order;

    @JoinColumn(name="game_fk", referencedColumnName = "game_id")
    @ManyToOne
    private GameEntity game;

    public OrderLineEntity() {
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

    public OrderEntity getOrder() {
        return order;
    }

    public GameEntity getGame() {
        return game;
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

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }
}
