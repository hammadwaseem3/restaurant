package com.company.bookingservice.repository;

import com.company.bookingservice.dao.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {
}
