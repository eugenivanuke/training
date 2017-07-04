package com.cooler.controller;

import com.cooler.model.book.Book;
import com.cooler.model.book.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by clr on 03.07.2017.
 */

@Controller
public class BookListController {

    private BookRepo bookRepo;

    @Autowired
    public BookListController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/booklist")
    public List<Book> getBookList() {
        return bookRepo.findAll();
    }
}
