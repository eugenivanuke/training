package com.cooler.service.adminTools;

import com.cooler.model.book.Book;
import com.cooler.model.book.BookRepo;
import com.cooler.model.book.author.Author;
import com.cooler.model.book.author.AuthorRepo;
import com.cooler.model.book.genre.Genre;
import com.cooler.model.book.genre.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by clr on 03.07.2017.
 */

@Component
public class AdminToolsServiceImpl implements AdminToolsServiceI {

    @Autowired
    BookRepo bookRepo;

    public void addBook (String title, String description, Author author , Genre genre , BigDecimal price) {
        bookRepo.save(new Book(title, description, author, genre, price));
    }

    public List<Book> getBookList() {
        return bookRepo.findAll();
    }

    public Book findByAuthor(Author author) {
        Set<Author> authorSet = new HashSet<Author>();
        authorSet.add(author);
        return bookRepo.findByAuthor(authorSet);
    }

    public Book findByTitle(String title) {
        return bookRepo.findByTitle(title);
    }

    public void addAuthorByTitle(Author author, String title) {
        Book book = this.findByTitle(title);
        book.getAuthorSet().add(author);
        bookRepo.save(book);
    }

    public void removeAuthorByTitle(Author author, String title) {
        Book book = this.findByTitle(title);
        book.getAuthorSet().remove(author);
        bookRepo.save(book);
    }

    public void addTitleByAuthor(String title, Author author) {
        Book book = this.findByAuthor(author);
        book.setTitle(title);
        bookRepo.save(book);
    }

    public void addDescriptionByTitle(String description, String title) {
        Book book = this.findByTitle(title);
        book.setDescription(description);
        bookRepo.save(book);
    }

    public void addGenreByTitle(Genre genre, String title) {
        Book book = this.findByTitle(title);
        book.getGenreSet().add(genre);
        bookRepo.save(book);
    }

    public void removeGenreByTitle(Genre genre, String title) {
        Book book = this.findByTitle(title);
        book.getGenreSet().remove(genre);
        bookRepo.save(book);
    }

    public void addPriceByTitle(BigDecimal price, String title) {
        Book book = this.findByTitle(title);
        book.setPrice(price);
        bookRepo.save(book);
    }
}
