package com.cooler.model.book.genre;

import com.cooler.model.book.Book;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by clr on 03.07.2017.
 */

@Entity
@Table(name = "genre")
public class Genre implements Serializable{

    private Long id;
    private String genreName;
    private Set<Book> bookSet = new HashSet<Book>();

    public Genre(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @ManyToMany
    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }
}
