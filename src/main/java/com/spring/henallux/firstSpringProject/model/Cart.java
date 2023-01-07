package com.spring.henallux.firstSpringProject.model;

import java.util.HashMap;

public class Cart {

    private HashMap<Integer, OrderLine> games = new HashMap<>();

    public Cart(){
    }

    public void addGame(Integer key, OrderLine orderLine){
        this.games.put(key, orderLine);
    }

    public HashMap<Integer,OrderLine> getGames(){
        return games;
    }

    public float getTotalPrice(){
        float totalPrice = 0;
        for(OrderLine orderLine : this.games.values()){
            totalPrice += orderLine.getSubTotalPrice();
        }
        return totalPrice;
    }

}
