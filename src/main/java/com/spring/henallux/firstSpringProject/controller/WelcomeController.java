package com.spring.henallux.firstSpringProject.controller;


import com.spring.henallux.firstSpringProject.model.Game;
import com.spring.henallux.firstSpringProject.model.Translation;
import com.spring.henallux.firstSpringProject.service.DiscountService;
import com.spring.henallux.firstSpringProject.service.GameService;
import com.spring.henallux.firstSpringProject.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Locale;


@Controller
@RequestMapping(value="/home")
public class WelcomeController {

    private GameService gameService;

    private DiscountService discountService;

    private TranslationService translationService;

    @Autowired
    public WelcomeController(GameService gameService, DiscountService discountService, TranslationService translationService) {
        this.gameService = gameService;
        this.discountService = discountService;
        this.translationService = translationService;
    }

    @RequestMapping (method = RequestMethod.GET)
    public String home (Model model, Locale locale) {
        ArrayList<Translation> categoriesTranslations = translationService.getCategoriesTranslation(locale.getLanguage());
        ArrayList<Game> games = gameService.getAllGames();
        games.forEach(game -> game.setPriceWithDiscount(discountService.getPriceOnDiscount(game)));
        model.addAttribute("games", games);
        model.addAttribute("categories", categoriesTranslations);
        return "integrated:home";
    }

}
