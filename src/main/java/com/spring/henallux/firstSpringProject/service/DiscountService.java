package com.spring.henallux.firstSpringProject.service;

import com.spring.henallux.firstSpringProject.model.Discount;
import com.spring.henallux.firstSpringProject.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DiscountService {

    @Autowired
    public DiscountService(){
    }

    public Float getPriceOnDiscount(Game game){
        if(isDiscountAvailable(game.getDiscount())){
            return game.getPrice() - (game.getPrice() * game.getDiscount().getPercentageDiscount()/100);
        } else {
            return game.getPrice();
        }
    }

    // Vérifier les dates ?
    private boolean isDiscountAvailable(Discount discount){
        if(discount.getDiscountID() != null && discount.getPercentageDiscount() > 0 && discount.getPercentageDiscount() <= 100){ //ex: 20 -> 20% de réduction
            return true;
        }
        return false;
    }


}