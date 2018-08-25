package com.company.bookingservice.facade;

import com.company.bookingservice.commons.error.StaffErrorType;
import com.company.bookingservice.commons.exception.FacadeException;
import com.company.bookingservice.dao.Staff;
import com.company.bookingservice.dto.StaffDto;
import com.company.bookingservice.factory.StaffFactory;
import com.company.bookingservice.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StaffFacade {

    StaffService staffService;

    @Autowired
    public StaffFacade(StaffService staffService) {
        this.staffService = staffService;
    }

    public void addStaff(StaffDto staffDto) {
        checkFirstAndLastName(staffDto);
        Staff staff = StaffFactory.getStaffFromDto(staffDto);
        staffService.addStaff(staff);
    }

    public List<StaffDto> getAllStaff() {
        List<Staff> staffList = staffService.getAllStaff();
        List<StaffDto> staffDtoList = new ArrayList<>();
        for(Staff staff : staffList){
            staffDtoList.add(StaffFactory.getStaffDtoFromStaff(staff));
        }
        return staffDtoList;
    }

    public StaffDto getStaffById(Integer id) {
        return StaffFactory.
                getStaffDtoFromStaff(staffService.getStaffById(id));
    }

    public void updateStaff(StaffDto staffDto) {
        checkFirstAndLastName(staffDto);
        checkForId(staffDto.getStaffId());
        Staff staff = StaffFactory.getStaffFromDto(staffDto);
        staffService.updateStaff(staff);
    }

    public void deleteStaffById(Integer id) {
        checkForId(id);
        staffService.deleteStaffById(id);
    }

    private void checkForId(Integer id){
        if(id == null || id <= 0){
            throw new FacadeException(StaffErrorType.EMPTY_OR_NEGATIVE_ID);
        }
    }

    private void checkFirstAndLastName(StaffDto staffDto){
        if(staffDto.getFirstName().length() == 0){
            throw new FacadeException(StaffErrorType.EMPTY_FIRST_NAME);
        }
        if(staffDto.getLastName().length() == 0){
            throw new FacadeException(StaffErrorType.EMPTY_LAST_NAME);
        }
    }
}
