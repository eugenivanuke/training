package com.cooler.model.book;

import com.cooler.model.book.author.Author;
import com.cooler.model.book.genre.Genre;
import com.cooler.model.customer.Customer;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by clr on 03.07.2017.
 */

@Entity
@Table(name = "book")
public class Book implements Serializable {

    private Long id;
    private String title;
    private String description;
    private Set<Author> authorSet = new HashSet<Author>();
    private Set<Genre> genreSet = new HashSet<Genre>();
    private BigDecimal price;
    private Customer customer;

    public Book(){}

    public Book(String title, String description, Author author, Genre genre, BigDecimal price) {
        Set<Author> authors = new HashSet<Author>();
        authors.add(author);
        this.authorSet = authors;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany
    @JoinTable(name = "book_author",
                joinColumns = @JoinColumn(name = "book_id"),
                inverseJoinColumns = @JoinColumn(name = "author_id"))
    public Set<Author> getAuthorSet() {
        return authorSet;
    }

    public void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }

    @ManyToMany
    @JoinTable(name = "book_genre",
                joinColumns =  @JoinColumn(name = "book_id"),
                inverseJoinColumns = @JoinColumn(name = "genre_id"))
    public Set<Genre> getGenreSet() {
        return genreSet;
    }

    public void setGenreSet(Set<Genre> genreSet) {
        this.genreSet = genreSet;
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return title + " " +
                description + " " +
                getAuthorSet().toString() + " " +
                getGenreSet().toString() + "" +
                price.toString();
    }
}
