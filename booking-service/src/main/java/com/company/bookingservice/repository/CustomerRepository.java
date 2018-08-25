package com.company.bookingservice.repository;

import com.company.bookingservice.dao.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
