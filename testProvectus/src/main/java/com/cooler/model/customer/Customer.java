package com.cooler.model.customer;

import com.cooler.model.book.Book;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by clr on 03.07.2017.
 */

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    public Long id;
    public String firstName;
    public String lastName;
    public String address;
    public Set<Book> bookSet = new HashSet<Book>();
    public Integer booksQuantity;

    protected Customer(){}

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

    @Column
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "customer")
    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    public Integer getBooksQuantity() {
        return booksQuantity;
    }

    public void setBooksQuantity(Integer booksQuantity) {
        this.booksQuantity = booksQuantity;
    }
}
