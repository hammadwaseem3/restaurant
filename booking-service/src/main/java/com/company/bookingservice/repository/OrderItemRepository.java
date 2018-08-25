package com.company.bookingservice.repository;

import com.company.bookingservice.dao.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem,Integer> {
}
