package com.company.bookingservice.factory;

import com.company.bookingservice.dao.OrderItem;
import com.company.bookingservice.dto.OrderItemDto;

public class OrderItemFactory {

    public static OrderItem getOrderItemFromDto(OrderItemDto orderItemDto){
        return new OrderItem(orderItemDto.getOrderItemId(), orderItemDto.getQuantity());
    }
}
