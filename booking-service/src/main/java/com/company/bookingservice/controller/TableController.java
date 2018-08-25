package com.company.bookingservice.controller;

import com.company.bookingservice.dto.TableDto;
import com.company.bookingservice.facade.TableFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/table/")
public class TableController {

    private TableFacade tableFacade;

    @Autowired
    public TableController(TableFacade tableFacade) {
        this.tableFacade = tableFacade;
    }

    @RequestMapping(value = "addTable", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addTable(
            @RequestBody TableDto tableDto) {
        tableFacade.addTable(tableDto);
    }

    @RequestMapping(value = "getAllTables", method = RequestMethod.GET)
    public @ResponseBody
    List<TableDto> getAllTable() {
        return tableFacade.getAllTable();
    }

    @RequestMapping(value = "getTableById/{id}", method = RequestMethod.GET)
    public @ResponseBody TableDto getTableById(
            @PathVariable("id") Integer id) {
        return tableFacade.getTableById(id);
    }

    @RequestMapping(value = "updateTable", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateTable(
            @RequestBody TableDto tableDto) {
        tableFacade.updateTable(tableDto);
    }

    @RequestMapping(value = "deleteTableById/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteTableById(
            @PathVariable("id") Integer id) {
        tableFacade.deleteTableById(id);
    }
}
