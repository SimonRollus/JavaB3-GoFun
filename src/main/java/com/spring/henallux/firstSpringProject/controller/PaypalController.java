package com.spring.henallux.firstSpringProject.controller;


import com.spring.henallux.firstSpringProject.Constants;
import com.spring.henallux.firstSpringProject.model.Cart;
import com.spring.henallux.firstSpringProject.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value="/paypal")
@SessionAttributes({Constants.CURRENT_CART})
public class PaypalController {

    @Autowired
    public PaypalController() {
    }

    @ModelAttribute(Constants.CURRENT_CART)
    public Cart cart(){
        return new Cart();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String paypalForm(Model model, @ModelAttribute(value=Constants.CURRENT_CART) Cart cart){
        model.addAttribute("cart", cart);
        model.addAttribute("cartItem", new CartItem());
        return "integrated:paypal";
    }



}
