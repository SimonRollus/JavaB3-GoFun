package com.spring.henallux.firstSpringProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value = "/aboutUs")
public class AboutUsController {

    private MessageSource messageSource;


    @Autowired
    public AboutUsController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String aboutUs(Model model, Locale locale){
        model.addAttribute("title", messageSource.getMessage("aboutUs", new Object[0], locale));
        return "integrated:aboutUs";
    }
}
