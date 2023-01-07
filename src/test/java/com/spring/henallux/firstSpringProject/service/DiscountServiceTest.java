package com.spring.henallux.firstSpringProject.service;

import com.spring.henallux.firstSpringProject.model.Category;
import com.spring.henallux.firstSpringProject.model.Discount;
import com.spring.henallux.firstSpringProject.model.Game;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.GregorianCalendar;

class DiscountServiceTest {

    private DiscountService discountService;

    @BeforeEach
    void setUp() {
        this.discountService = new DiscountService();
    }

    @Test
    void getPriceOnDiscount() {
        Game game = new Game();
        Discount discount = new Discount();

        discount.setDiscountID(1);
        discount.setPercentageDiscount(20F);

        GregorianCalendar startDate = new GregorianCalendar(2022-1900, 12-1, 1, 0, 0, 1);

        discount.setStartDate(startDate.getTime());

        // GregorianCalendar 2023-02-25 23:59:59
        GregorianCalendar endDate = new GregorianCalendar(2023-1900, 2-1, 25, 23, 59, 59);

        discount.setEndDate(endDate.getTime());

        game.setName("Secret Identity");
        game.setDescription("Infiltre toi comme un vrai espion");
        game.setPrice(30F);

        game.setCategory(new Category());
        game.getCategory().setCategoryID(1);
        game.setDiscount(discount);
        game.setImage("games/categorie-dessin/jeu4.jpg");
        game.setMinimumAge(4);
        game.setMinimumNumberPlayers(4);
        game.setMaximumNumberPlayers(6);

        Float expectedResult = 24F;

        Assert.assertEquals(expectedResult, this.discountService.getPriceOnDiscount(game));
    }
}

