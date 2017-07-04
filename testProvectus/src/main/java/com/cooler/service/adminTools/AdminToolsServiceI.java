package com.cooler.service.adminTools;

import com.cooler.model.book.Book;
import com.cooler.model.book.author.Author;
import com.cooler.model.book.genre.Genre;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by clr on 03.07.2017.
 */
public interface AdminToolsServiceI {

    void addBook(String title, String description, Author author, Genre genre, BigDecimal price);
    List<Book> getBookList();
    Book findByAuthor(Author author);
    Book findByTitle(String title);
    void addAuthorByTitle(Author author, String title);
    void removeAuthorByTitle(Author author, String title);
    void addTitleByAuthor(String title, Author author);
    void addDescriptionByTitle(String description, String title);
    void addGenreByTitle(Genre genre, String title);
    void removeGenreByTitle(Genre genre, String title);
    void addPriceByTitle(BigDecimal price, String title);
}
