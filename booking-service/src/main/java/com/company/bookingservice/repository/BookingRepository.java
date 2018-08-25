package com.company.bookingservice.repository;

import com.company.bookingservice.dao.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking,Integer> {
}
