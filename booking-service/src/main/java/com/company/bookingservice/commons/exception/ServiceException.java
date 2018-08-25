package com.company.bookingservice.commons.exception;

import com.company.bookingservice.commons.error.ErrorEnumType;

public class ServiceException extends BaseApplicationException {

    public ServiceException(ErrorEnumType<? extends Enum<?>> errorEnumType){
        super(errorEnumType);
    }

    public ServiceException(Exception e,ErrorEnumType<? extends Enum<?>> errorEnumType){
        super(e, errorEnumType);
    }

    public ServiceException(BaseApplicationException ex) {
        super(ex);
    }

    public String toString() {
        return "ServiceException()";
    }
}
