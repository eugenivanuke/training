package com.cooler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by clr on 03.07.2017.
 */

@Controller(value = "/")
public class HomeController {

    @RequestMapping
    public String home() {
        return "home";
    }
}
