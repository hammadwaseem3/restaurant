package com.company.bookingservice.controller;

import com.company.bookingservice.dto.StaffDto;
import com.company.bookingservice.facade.StaffFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff/")
public class StaffController {

    private StaffFacade staffFacade;

    @Autowired
    public StaffController(StaffFacade staffFacade) {
        this.staffFacade = staffFacade;
    }

    @RequestMapping(value = "addStaff", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addStaff(
            @RequestBody StaffDto staffDto) {
        staffFacade.addStaff(staffDto);
    }

    @RequestMapping(value = "getAllStaff", method = RequestMethod.GET)
    public @ResponseBody List<StaffDto> getAllStaff() {
        return staffFacade.getAllStaff();
    }

    @RequestMapping(value = "getStaffById/{id}", method = RequestMethod.GET)
    public @ResponseBody StaffDto getStaffById(
            @PathVariable("id") Integer id) {
        return staffFacade.getStaffById(id);
    }

    @RequestMapping(value = "updateStaff", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateStaff(
            @RequestBody StaffDto staffDto) {
        staffFacade.updateStaff(staffDto);
    }

    @RequestMapping(value = "deleteStaffById/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteStaffById(
            @PathVariable("id") Integer id) {
        staffFacade.deleteStaffById(id);
    }
}
