package com.company.bookingservice.facade;

import com.company.bookingservice.dao.*;
import com.company.bookingservice.dto.BookingOrderDto;
import com.company.bookingservice.dto.OrderItemDto;
import com.company.bookingservice.factory.CustomerFactory;
import com.company.bookingservice.factory.OrderItemFactory;
import com.company.bookingservice.service.BookingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookingOrderFacade {

    private BookingOrderService bookingOrderService;

    @Autowired
    public BookingOrderFacade(BookingOrderService bookingOrderService) {
        this.bookingOrderService = bookingOrderService;
    }

    public void addOrder(BookingOrderDto bookingOrderDto) {

        Customer customer = CustomerFactory.getCustomerFromDto(bookingOrderDto.getCustomer());

        List<OrderItem> orderItemList = new ArrayList<>();
        for(OrderItemDto orderItemDto : bookingOrderDto.getOrderItemList()){

            OrderItem orderItem = OrderItemFactory.getOrderItemFromDto(orderItemDto);
            Menu menu = Menu.builder().menuId(orderItemDto.getMenuId()).build();
            orderItem.setMenu(menu);

            orderItemList.add(orderItem);
        }

        bookingOrderService.addOrder(bookingOrderDto.getTableNo(), customer, orderItemList,
                bookingOrderDto.getStaffId());
    }
}
