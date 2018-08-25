package com.company.bookingservice.controller;

import com.company.bookingservice.dto.BookingOrderDto;
import com.company.bookingservice.facade.BookingOrderFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order/")
public class BookingOrderController {

    private BookingOrderFacade bookingOrderFacade;

    @Autowired
    public BookingOrderController(BookingOrderFacade bookingOrderFacade) {
        this.bookingOrderFacade = bookingOrderFacade;
    }

    @RequestMapping(value = "addOrder", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addOrder(
            @RequestBody BookingOrderDto bookingOrderDto ){
        bookingOrderFacade.addOrder(bookingOrderDto);
    }
}
