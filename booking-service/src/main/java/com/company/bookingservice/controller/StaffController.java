package com.company.bookingservice.controller;

import com.company.bookingservice.dto.StaffDto;
import com.company.bookingservice.facade.StaffFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/staff/")
public class StaffController {

    StaffFacade staffFacade;

    @Autowired
    public StaffController(StaffFacade staffFacade) {
        this.staffFacade = staffFacade;
    }

    @RequestMapping(name = "add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addStaff(
            @RequestBody StaffDto staffDto) {
        staffFacade.addStaff(staffDto);
    }

    @RequestMapping(name = "getAll", method = RequestMethod.GET)
    public @ResponseBody List<StaffDto> getAllStaff() {
        return staffFacade.getAllStaff();
    }

    @RequestMapping(name = "getById/{id}", method = RequestMethod.GET)
    public @ResponseBody StaffDto getStaffById(
            @PathVariable("id") Integer id) {
        return staffFacade.getStaffById(id);
    }

    @RequestMapping(name = "update", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateStaff(
            @RequestBody StaffDto staffDto) {
        staffFacade.updateStaff(staffDto);
    }

    @RequestMapping(name = "deleteById/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteStaffById(
            @PathVariable("id") Integer id) {
        staffFacade.deleteStaffById(id);
    }
}
