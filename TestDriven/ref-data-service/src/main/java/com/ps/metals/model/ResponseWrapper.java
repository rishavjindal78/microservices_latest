package com.ps.metals.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ResponseWrapper {
    private Boolean success;
    private Boolean failure;
    private Object data;
    private String errorMessage;

    private ResponseWrapper(Boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    private ResponseWrapper(Boolean failure, String errorMessage) {
        this.failure = failure;
        this.errorMessage = errorMessage;
    }


    public static ResponseWrapper success(Object data) {
        return new ResponseWrapper(true, data);
    }

    public static ResponseWrapper failure(String message) {
        return new ResponseWrapper(true, message);
    }

    public Boolean getSuccess() {
        return success;
    }

    public Boolean getFailure() {
        return failure;
    }

    public Object getData() {
        return data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
