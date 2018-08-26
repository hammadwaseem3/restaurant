package com.company.bookingservice.commons.error;

public enum BookingOrderErrorType implements ErrorEnumType<BookingOrderErrorType> {
    SOMETHING_BAD_HAPPENS(1, "Something bad happens");

    private int code;
    private String errorMessage;

    private BookingOrderErrorType(int code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public int getCode() {
        return this.code;
    }

    public String getAppCode() {
        return String.format("%d", this.code);
    }

    public String getAppMessage() {
        return this.errorMessage;
    }
}

