package com.company.bookingservice.commons.error;

public enum TableErrorType implements ErrorEnumType<TableErrorType> {
    UNABLE_TO_INSERT(1, "Unable to insert into table"),
    UNABLE_TO_DELETE(2, "Unable to delete from table"),
    NO_ID_SPECIFIED(3, "No Id is specified, kindly specify Id in request"),
    SOMETHING_BAD_HAPPEN(4, "Something bad happen"),
    EMPTY_DETAIL_NAME(5, "details cannot be empty"),
    EMPTY_OR_NEGATIVE_ID(6, "ID cannot be null or negative"),
    UNABLE_TO_UPDATE(7, "Unable to update staff"),
    NO_TABLE_FOUND(8, "No Table found"),
    INVALID_TABLE_NUMBER(9, "Table ID is invalid");

    private int code;
    private String errorMessage;

    TableErrorType(int code, String errorMessage) {
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
