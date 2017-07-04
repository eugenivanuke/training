package com.cooler.controller;

import com.cooler.model.index.Index;
import com.cooler.model.index.IndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by clr on 17.05.2017.
 */

@RestController
public class IndexController {

    @Autowired
    private IndexRepository repository;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method=RequestMethod.GET, value={"/index", "/"})
    public Index index(@RequestParam(value="name", defaultValue="bitch") String name) {
        Index index = new Index (counter.incrementAndGet(), String.format(template, name));
        repository.save(index);
        return index;
    }
}
