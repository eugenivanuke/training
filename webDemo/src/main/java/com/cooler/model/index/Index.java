package com.cooler.model.index;

import javax.persistence.*;

/**
 * Created by clr on 17.05.2017.
 */

@Entity
@Table(name = "BroManDude")
public class Index {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String content;

    public Index(long id, String content) {
        this.id = id;
        this.content = content;
    }

    protected Index(){}

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
