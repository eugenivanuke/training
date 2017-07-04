package com.cooler.model.customer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by clr on 03.07.2017.
 */
public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
