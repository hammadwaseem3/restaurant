package com.company.bookingservice.commons.error;

public enum StaffErrorType implements ErrorEnumType<BookingErrorType> {
    UNABLE_TO_INSERT(1, "Unable to insert into staff"),
    UNABLE_TO_DELETE(2, "Unable to delete from staff"),
    NO_ID_SPECIFIED(3, "No Id is specified, kindly specify Id in request"),
    SOMETHING_BAD_HAPPEN(4, "Something bad happen"),
    EMPTY_FIRST_NAME(5, "firstname cannot be empty"),
    EMPTY_LAST_NAME(6, "lastname cannot be empty"),
    EMPTY_OR_NEGATIVE_ID(7, "ID cannot be null or negative"),
    UNABLE_TO_UPDATE(8, "Unable to update staff"),
    NO_STAFF_FOUND(9, "No staff found");

    private int code;
    private String errorMessage;

    private StaffErrorType(int code, String errorMessage) {
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
