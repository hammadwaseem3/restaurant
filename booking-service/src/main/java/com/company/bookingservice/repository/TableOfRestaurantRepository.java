package com.company.bookingservice.repository;

import com.company.bookingservice.dao.TableOfRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableOfRestaurantRepository extends JpaRepository<TableOfRestaurant,Integer> {
}
