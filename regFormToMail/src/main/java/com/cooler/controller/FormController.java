package com.cooler.controller;

import com.cooler.model.User;
import com.cooler.service.FormToMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


/**
 * Created by clr on 07.06.2017.
 */

@Controller
@RequestMapping({"/form" , "/", "/formV2"})
public class FormController{

    @Autowired
    private FormToMailService formToMailService;

    public void setFormToMailService (FormToMailService formToMailService) {
        this.formToMailService = formToMailService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showForm(Model model) {
        /* you'll get a jsp exception if you won't
        populate the method with model (User class
        in this case)*/
        model.addAttribute(new User());
        return "formV2";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm(@Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return "formV2";
        }
        //here must be mail sending method
        formToMailService.sendMail(user);
        return "success";
    }
}
