package com.company.bookingservice.commons.error;

public enum BookingErrorType implements ErrorEnumType<BookingErrorType> {
    DUPLICATE_BOOKING(1, "Booking already exists for same type");

    private int code;
    private String errorMessage;

    private BookingErrorType(int code, String errorMessage) {
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

