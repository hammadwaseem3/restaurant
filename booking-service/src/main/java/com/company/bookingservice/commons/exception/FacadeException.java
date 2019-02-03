package com.company.bookingservice.commons.exception;

import com.company.bookingservice.commons.error.ErrorEnumType;

public class FacadeException extends RuntimeException {

    public FacadeException(ErrorEnumType<? extends Enum<?>> errorEnumType){
        super(errorEnumType.getMessage());
    }

    public String toString() {
        return "FacadeException()";
    }
}
