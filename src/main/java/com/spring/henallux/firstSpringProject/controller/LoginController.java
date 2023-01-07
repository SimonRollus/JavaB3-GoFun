package com.spring.henallux.firstSpringProject.controller;


import com.spring.henallux.firstSpringProject.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/login")
public class LoginController {


    @RequestMapping(method = RequestMethod.GET)
    public String login (Model model, @RequestParam(required = false)String error){
        if(error != null)
            model.addAttribute("errorLogin","Erreur sign in");

        model.addAttribute("customerLogin",new Customer());
        return "integrated:login";
    }
}
