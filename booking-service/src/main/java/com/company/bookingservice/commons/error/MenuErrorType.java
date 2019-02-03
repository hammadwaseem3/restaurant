package com.company.bookingservice.commons.error;

public enum MenuErrorType implements ErrorEnumType<MenuErrorType> {
    UNABLE_TO_INSERT(1, "Unable to insert into menu"),
    UNABLE_TO_DELETE(2, "Unable to delete from menu"),
    NO_ID_SPECIFIED(3, "No Id is specified, kindly specify Id in request"),
    SOMETHING_BAD_HAPPEN(4, "Something bad happen"),
    PRICE_CANNOT_BE_NEGATIVE(5, "price cannot be negative"),
    INVALID_MENU_NUMBER(6, "Menu ID is invalid");

    private int code;
    private String errorMessage;

    MenuErrorType(int code, String errorMessage) {
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

