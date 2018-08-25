package com.company.bookingservice.repository;

import com.company.bookingservice.dao.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff,Integer> {
}
