package com.company.bookingservice.repository;

import com.company.bookingservice.dao.OrderOfRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderOfRestaurantRepository extends JpaRepository<OrderOfRestaurant,Integer> {
}
