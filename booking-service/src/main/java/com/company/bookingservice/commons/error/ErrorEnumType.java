package com.company.bookingservice.commons.error;

public interface ErrorEnumType<E extends Enum<E>> {

    String getCode();
    String getMessage();

}
