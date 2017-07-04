package com.cooler.model.book;

import com.cooler.model.book.author.Author;
import com.cooler.model.book.genre.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by clr on 03.07.2017.
 */
public interface BookRepo extends JpaRepository<Book, Long> {

    List<Book> findAll();
    List<Book> findByGenreSet(Set<Genre> genreSet);
    List<Book> findByAuthorSet(Set<Author> authorSet);
    Book findByTitle(String title);
}
