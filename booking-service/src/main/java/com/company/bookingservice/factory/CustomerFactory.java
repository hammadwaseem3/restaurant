package com.company.bookingservice.factory;

import com.company.bookingservice.dao.Customer;
import com.company.bookingservice.dto.CustomerDto;

public class CustomerFactory {

    public static Customer getCustomerFromDto(CustomerDto customerDto){
        return new Customer(customerDto.getFirstName(), customerDto.getLastName(),
                customerDto.getPhoneNumber(), customerDto.getEmailAddress(), customerDto.getOtherDetails());
    }
}
