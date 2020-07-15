package com.kuzmin.evgenii.sberbanktaskspringsecurity.rest.response;

import lombok.AllArgsConstructor;


public enum ErrorResponseEnum {

    INVALID_CREDENTIALS(1, "Неверные данные для авторизации");

    int code;
    String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    ErrorResponseEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

}
