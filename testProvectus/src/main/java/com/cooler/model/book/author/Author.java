package com.cooler.model.book.author;

import com.cooler.model.book.Book;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by clr on 03.07.2017.
 */

@Entity
@Table(name = "author")
public class Author implements Serializable{

    private Long id;
    private String firstName;
    private String lastName;
    private Set<Book> bookSet = new HashSet<Book>();

    public Author(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToMany
    @JoinTable(name = "book_author",
                joinColumns = @JoinColumn(name="author_id"),
                inverseJoinColumns = @JoinColumn(name="book_id"))
    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }
}
