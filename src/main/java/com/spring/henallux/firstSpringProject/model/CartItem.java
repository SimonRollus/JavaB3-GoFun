package com.spring.henallux.firstSpringProject.model;


import javax.validation.constraints.*;

public class CartItem {


    @NotNull
    @Min(value = 1)
    private Integer quantity;

    @NotNull
    @Min(value = 1)
    private Integer gameID;

    public CartItem() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getGameID() {
        return gameID;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }
}
