package com.company.bookingservice.commons.exception;

import com.company.bookingservice.commons.error.ErrorEnumType;

public class ServiceException extends RuntimeException {

    public ServiceException(ErrorEnumType<? extends Enum<?>> errorEnumType){
        super(errorEnumType.getMessage());
    }

    public String toString() {
        return "ServiceException()";
    }
}
