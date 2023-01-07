package com.spring.henallux.firstSpringProject.controller;


import com.spring.henallux.firstSpringProject.model.CartItem;
import com.spring.henallux.firstSpringProject.model.Game;
import com.spring.henallux.firstSpringProject.model.Translation;
import com.spring.henallux.firstSpringProject.service.DiscountService;
import com.spring.henallux.firstSpringProject.service.GameService;
import com.spring.henallux.firstSpringProject.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Locale;

@Controller
@RequestMapping(value = "/game/")
public class GameDescriptionController {

    private GameService gameService;
    private DiscountService discountService;

    private TranslationService translationService;

    @Autowired
    public GameDescriptionController(GameService gameService, DiscountService discountService, TranslationService translationService) {
        this.gameService = gameService;
        this.discountService = discountService;
        this.translationService = translationService;
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public String gameDescription(Model model, @PathVariable Integer id, Locale locale){
        ArrayList<Translation> categoriesTranslations = translationService.getCategoriesTranslation(locale.getLanguage());
        Game game = gameService.getGameByID(id);
        game.setPriceWithDiscount(discountService.getPriceOnDiscount(game));
        model.addAttribute("cartItem",new CartItem());
        model.addAttribute("game",game);
        model.addAttribute("categories", categoriesTranslations);
        return "integrated:gameDescription";
    }
}
