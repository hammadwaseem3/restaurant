package com.company.bookingservice.commons.error;

import org.springframework.http.HttpStatus;

public interface ErrorEnumType<E extends Enum<E>> {

    String getAppCode();
    String getAppMessage();

    default HttpStatus getHttpStatus() {return HttpStatus.BAD_REQUEST;}
    default String getExceptionMessage() {
        return String.format("[%s] %s", this.getAppCode(), this.getAppMessage());
    }
}
