package com.company.bookingservice.service;

import com.company.bookingservice.commons.error.StaffErrorType;
import com.company.bookingservice.commons.exception.ServiceException;
import com.company.bookingservice.dao.Staff;
import com.company.bookingservice.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public void addStaff(Staff staff) {
        try {
            staffRepository.save(staff);
        }catch (Exception e){
            throw new ServiceException(StaffErrorType.UNABLE_TO_INSERT);
        }
    }

    public List<Staff> getAllStaff() {
        try {
            return staffRepository.findAll();
        }catch (Exception e){
            throw new ServiceException(StaffErrorType.SOMETHING_BAD_HAPPEN);
        }
    }

    public Staff getStaffById(Integer id) {
        Optional<Staff> staff = null;
        try {
            staff = staffRepository.findById(id);
        }catch (Exception e){
            throw new ServiceException(StaffErrorType.SOMETHING_BAD_HAPPEN);
        }

        if(staff != null && staff.isPresent()){
            return staff.get();
        }else{
            throw new ServiceException(StaffErrorType.NO_STAFF_FOUND);
        }
    }

    public void updateStaff(Staff staff) {
        try {
            staffRepository.save(staff);
        }catch (Exception e){
            throw new ServiceException(StaffErrorType.UNABLE_TO_UPDATE);
        }
    }

    public void deleteStaffById(Integer id) {
        try {
            staffRepository.deleteById(id);
        }catch (Exception e){
            throw new ServiceException(StaffErrorType.UNABLE_TO_DELETE);
        }
    }
}
