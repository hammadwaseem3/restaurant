package com.company.bookingservice.commons.error;

public enum BookingOrderErrorType implements ErrorEnumType<BookingOrderErrorType> {
    SOMETHING_BAD_HAPPENS(1, "Something bad happens");

    private int code;
    private String errorMessage;

    BookingOrderErrorType(int code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public String getCode() {
        return String.format("%d", this.code);
    }

    public String getMessage() {
        return this.errorMessage;
    }
}

