package com.company.bookingservice.controller;

import com.company.bookingservice.dto.TableDto;
import com.company.bookingservice.facade.TableFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/table/")
public class TableController {
    TableFacade tableFacade;

    @Autowired
    public TableController(TableFacade tableFacade) {
        this.tableFacade = tableFacade;
    }

    @RequestMapping(name = "add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addTable(
            @RequestBody TableDto tableDto) {
        tableFacade.addTable(tableDto);
    }

    @RequestMapping(name = "getAll", method = RequestMethod.GET)
    public @ResponseBody
    List<TableDto> getAllTable() {
        return tableFacade.getAllTable();
    }

    @RequestMapping(name = "getById/{id}", method = RequestMethod.GET)
    public @ResponseBody TableDto getTableById(
            @PathVariable("id") Integer id) {
        return tableFacade.getTableById(id);
    }

    @RequestMapping(name = "update", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateTable(
            @RequestBody TableDto tableDto) {
        tableFacade.updateTable(tableDto);
    }

    @RequestMapping(name = "deleteById/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteTableById(
            @PathVariable("id") Integer id) {
        tableFacade.deleteTableById(id);
    }
}
