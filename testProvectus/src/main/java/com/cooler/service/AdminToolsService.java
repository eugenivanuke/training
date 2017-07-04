package com.cooler.service;

import com.cooler.model.book.AdminBookRepo;
import com.cooler.model.book.Book;
import com.cooler.model.book.author.Author;
import com.cooler.model.book.genre.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by clr on 04.07.2017.
 */

@Component
public class AdminToolsService {

    private AdminBookRepo adminBookRepo;

    @Autowired
    public AdminToolsService(AdminBookRepo adminBookRepo) {
        this.adminBookRepo = adminBookRepo;
    }

    public void saveBook(Book book) {
        adminBookRepo.save(book);
    }

    public void setTitle(Book book, String title){
        book = adminBookRepo.findByTitle(book.getTitle());
        book.setTitle(title);
        adminBookRepo.save(book);
    }

    public void setDescription(Book book, String description) {
        book = adminBookRepo.findByTitle(book.getTitle());
        book.setDescription(description);
        adminBookRepo.save(book);
    }

    public void addAuthor(Book book, Author author) {
        book = adminBookRepo.findByTitle(book.getTitle());
        book.getAuthorSet().add(author);
        adminBookRepo.save(book);
    }

    public void removeAuthor(Book book, Author author) {
        book = adminBookRepo.findByTitle(book.getTitle());
        book.getAuthorSet().remove(author);
        adminBookRepo.save(book);
    }

    public void addGenre(Book book, Genre genre) {
        book = adminBookRepo.findByTitle(book.getTitle());
        book.getGenreSet().add(genre);
        adminBookRepo.save(book);
    }

    public void removeGenre(Book book, Genre genre) {
        book = adminBookRepo.findByTitle(book.getTitle());
        book.getGenreSet().remove(genre);
        adminBookRepo.save(book);
    }

    public void setPrice(Book book, BigDecimal price) {
        book = adminBookRepo.findByTitle(book.getTitle());
        book.setPrice(price);
        adminBookRepo.save(book);
    }
}
