package com.cooler.controller;

import com.cooler.model.book.Book;
import com.cooler.service.AdminToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by clr on 03.07.2017.
 */

@Controller
public class AdminToolsController {

    private AdminToolsService adminToolsService;

    @Autowired
    public AdminToolsController(AdminToolsService adminToolsService) {
        this.adminToolsService = adminToolsService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admintools")
    public String showAdminTools(Model model) {
        model.addAttribute(new Book());
        return "admintools";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admintools")
    public String saveBook(Book book) {
        adminToolsService.saveBook(book);
        return "booklist";
    }

}
