package com.cooler.model.book;

import com.cooler.model.book.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by clr on 03.07.2017.
 */
public interface BookRepo extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
    Book findByAuthor(Set<Author> authorSet);
    List<Book> findAll();
}
