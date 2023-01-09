package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.Constants;
import com.spring.henallux.firstSpringProject.model.Customer;
import com.spring.henallux.firstSpringProject.service.CustomerService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.Locale;


@Controller
@RequestMapping(value="/signup")
@SessionAttributes({Constants.CURRENT_USER})

public class SignupController {

    private CustomerService customerService;

    private MessageSource messageSource;

    @Autowired
    public SignupController(CustomerService customerService, MessageSource messageSource) {
        this.customerService = customerService;
        this.messageSource = messageSource;
    }

    @ModelAttribute(Constants.CURRENT_USER)
    public Customer customer(){
        return new Customer();
    }

    @RequestMapping (method = RequestMethod.GET)
    public String userSignUp (Model model) {
        model.addAttribute("signupForm", new Customer());
        return "integrated:signup";
    }

    @RequestMapping (method = RequestMethod.POST)
    public String postUser (Model model, @ModelAttribute(value = Constants.CURRENT_USER) @Valid Customer customer, final BindingResult errors, Locale locale){

        if (!(customer.getPassword().equals(customer.getConfirmPassword()))){
            // change message for pattern error
            errors.rejectValue("confirmPassword", "passwordsDontMatch");
        }

        if(errors.hasErrors()){
            // change message using .properties for firstNameEmpty
            messageSource.getMessage("firstNameEmpty", null, locale);


            return "integrated:signup";
        }

        boolean isRegistered = customerService.saveCustomer(customer);

        if(isRegistered) {
            model.addAttribute(Constants.CURRENT_USER, new Customer());
            return "redirect:/home";
        } else{
            model.addAttribute("customerExists", messageSource.getMessage("customerAlreadyExist", new Object[0], locale));
            return "integrated:signup";
        }


    }


}
