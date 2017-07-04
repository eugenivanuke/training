package com.cooler.controller;

import com.cooler.service.adminTools.AdminToolsServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by clr on 03.07.2017.
 */

@Controller
public class AdminToolsController {

    @Autowired
    private AdminToolsServiceI adminToolsService;

    @RequestMapping(method = RequestMethod.GET, value = "/admin")
    public String showAdminTools() {
        return "adminTools";
    }

}
