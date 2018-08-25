package com.company.bookingservice.commons.exception;

import com.company.bookingservice.commons.error.ErrorEnumType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BaseApplicationException extends RuntimeException{

    private HttpStatus httpStatus;
    private String appCode;
    private String appMessage;

    protected BaseApplicationException(ErrorEnumType<? extends Enum<?>> errorEnumType) {
        super(errorEnumType.getExceptionMessage());
        this.setAppCode(errorEnumType.getAppCode());
        this.setAppMessage(errorEnumType.getAppMessage());
        this.setHttpStatus(errorEnumType.getHttpStatus());
    }

    protected BaseApplicationException(Exception e, ErrorEnumType<? extends Enum<?>> errorEnumType) {
        super(e);
        this.setAppCode(errorEnumType.getAppCode());
        this.setAppMessage(errorEnumType.getAppMessage());
        this.setHttpStatus(errorEnumType.getHttpStatus());
    }

    public BaseApplicationException(BaseApplicationException ex) {
        super(ex);
        this.setAppCode(ex.getAppCode());
        this.setAppMessage(ex.getAppMessage());
        this.setHttpStatus(ex.getHttpStatus());
    }
}
