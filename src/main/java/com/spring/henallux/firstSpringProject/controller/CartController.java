package com.spring.henallux.firstSpringProject.controller;


import com.spring.henallux.firstSpringProject.Constants;
import com.spring.henallux.firstSpringProject.model.*;
import com.spring.henallux.firstSpringProject.service.DiscountService;
import com.spring.henallux.firstSpringProject.service.GameService;
import com.spring.henallux.firstSpringProject.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping(value="/cart")
@SessionAttributes({Constants.CURRENT_CART})
public class CartController {

    private PurchaseService purchaseService;
    private GameService gameService;

    private DiscountService discountService;

    public CartController(PurchaseService purchaseService, GameService gameService, DiscountService discountService) {
        this.purchaseService = purchaseService;
        this.gameService = gameService;
        this.discountService = discountService;
    }

    @Autowired

    @ModelAttribute(Constants.CURRENT_CART)
    public Cart cartLine(){
        return new Cart();
    }

    @RequestMapping(method= RequestMethod.GET)
    public String cart(Model model, @ModelAttribute(value=Constants.CURRENT_CART) Cart cart){
        model.addAttribute("cartItem",new CartItem());
        model.addAttribute("cart", cart);
        return "integrated:cart";
    }

    @RequestMapping(value="/send", method=RequestMethod.POST)
    public String getFormData(@ModelAttribute(value="cartItem") CartItem cartItem, @ModelAttribute(value=Constants.CURRENT_CART) Cart cart, HttpServletRequest request){
        if(cartItem.getQuantity() > 0){
            Game game = gameService.getGameByID(cartItem.getGameID());
            Float priceAfterDiscount = discountService.getPriceOnDiscount(game);
            game.setPrice(priceAfterDiscount);
            OrderLine orderLine = new OrderLine(null, priceAfterDiscount, cartItem.getQuantity(), null, game);
            if(cart.getGames().containsKey(game.getGameID())){
                Integer oldQuantity = cart.getGames().get(game.getGameID()).getQuantity();
                cart.getGames().get(game.getGameID()).setQuantity(cartItem.getQuantity()+oldQuantity); //ajoute la nouvelle quantité à l'ancienne
            }else{
                cart.addGame(game.getGameID(), orderLine);
            }
            return "redirect:/cart";
        }else{
            return Optional.ofNullable(request.getHeader("Referer")).map(requestUrl -> "redirect:" + requestUrl).orElse("/boardgame/home"); //redirige vers la page si possible sinon vers l'accueil
        }
    }

    @RequestMapping(value="/quantityUpdate", method=RequestMethod.POST)
    public String updateGameQuantity(@ModelAttribute(value="cartItem") CartItem cartItem, @ModelAttribute(value=Constants.CURRENT_CART) Cart cart, HttpServletRequest request){
        if(cartItem.getQuantity() > 0){
            cart.getGames().get(cartItem.getGameID()).setQuantity(cartItem.getQuantity());
            return "redirect:/cart";
        }else{
            return Optional.ofNullable(request.getHeader("Referer")).map(requestUrl -> "redirect:" + requestUrl).orElse("/"); //redirige vers la page si possible sinon vers l'accueil
        }
    }

    @RequestMapping(value="/removeItem", method=RequestMethod.POST)
    public String removeItem(@ModelAttribute(value="cartItem") CartItem cartItem, @ModelAttribute(value=Constants.CURRENT_CART) Cart cart){
        cart.getGames().remove(cartItem.getGameID());
        return "redirect:/cart";
    }

    //Sauvergarder la commande dans la DB avant même si elle n'est pas payée
    @RequestMapping(value="/saveCart", method=RequestMethod.POST)
    public String saveCart(@ModelAttribute(value=Constants.CURRENT_CART) Cart cart, HttpSession session){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Customer customer = (Customer) auth.getPrincipal();

        Order order = purchaseService.savePurchase(cart.getGames(), customer);
        Order orderFromSession = (Order) session.getAttribute("currentOrder");
        if(orderFromSession == null){
            session.setAttribute("currentOrder", order);
        }else{
            if(!orderFromSession.getOrderID().equals(order.getOrderID())){
                session.removeAttribute("currentOrder");
                session.setAttribute("currentOrder", order);
            }
        }
        return "redirect:/paypal";
    }

    @RequestMapping(value="/paymentSuccess", method = RequestMethod.GET)
    public String paymentSuccess(@ModelAttribute(value=Constants.CURRENT_CART) Cart cart, HttpSession session){
        cart.getGames().clear();
        Order order = (Order) session.getAttribute("currentOrder");
        if(order != null){
            purchaseService.modifyOrderToPaid(order.getOrderID()); //pas sécurisé avec ce système car l'utilisateur peut revenir sur ce lien sans payer et sa commande sera marquée comme payée
        }
        return "redirect:/home";
    }

    @RequestMapping(value="/paymentFailed", method=RequestMethod.GET)
    public String paymentFailed(HttpSession session){
        return "redirect:/cart";
    }

















}
