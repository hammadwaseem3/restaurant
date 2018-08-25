package com.company.bookingservice.factory;

import com.company.bookingservice.dao.Staff;
import com.company.bookingservice.dto.StaffDto;

public class StaffFactory {

    public static Staff getStaffFromDto(StaffDto staffDto){
        return new Staff(staffDto.getFirstName(), staffDto.getLastName());
    }

    public static StaffDto getStaffDtoFromStaff(Staff staff){
        return new StaffDto(staff.getStaffId(), staff.getFirstName(), staff.getLastName());
    }
}
