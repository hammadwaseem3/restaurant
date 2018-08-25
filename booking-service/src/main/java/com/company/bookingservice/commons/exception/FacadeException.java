package com.company.bookingservice.commons.exception;

import com.company.bookingservice.commons.error.ErrorEnumType;

public class FacadeException extends BaseApplicationException {

    public FacadeException(ErrorEnumType<? extends Enum<?>> errorEnumType){
        super(errorEnumType);
    }

    public FacadeException(Exception e,ErrorEnumType<? extends Enum<?>> errorEnumType){
        super(e, errorEnumType);
    }

    public FacadeException(BaseApplicationException ex) {
        super(ex);
    }

    public String toString() {
        return "FacadeException()";
    }
}
