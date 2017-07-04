package com.cooler.model.book;

/**
 * Created by clr on 04.07.2017.
 */
public interface AdminBookRepo extends BookRepo {
    Book save(Book book);
}
