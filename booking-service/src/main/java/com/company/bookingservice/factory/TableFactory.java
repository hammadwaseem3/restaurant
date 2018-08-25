package com.company.bookingservice.factory;

import com.company.bookingservice.dao.TableOfRestaurant;
import com.company.bookingservice.dto.TableDto;

public class TableFactory {

    public static TableOfRestaurant getTableFromDto(TableDto tableDto){
        return new TableOfRestaurant(tableDto.getDetails());
    }

    public static TableDto getTableDtoFromTableOfRestaurant(TableOfRestaurant tableOfRestaurant){
        return new TableDto(tableOfRestaurant.getTableNo(), tableOfRestaurant.getDetails());
    }
}
