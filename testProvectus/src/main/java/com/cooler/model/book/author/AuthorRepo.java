package com.cooler.model.book.author;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by clr on 03.07.2017.
 */
public interface AuthorRepo extends JpaRepository<Author, Long> {
}
