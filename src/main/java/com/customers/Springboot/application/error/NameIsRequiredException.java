package com.customers.Springboot.application.error;

public class NameIsRequiredException extends Exception{
    public NameIsRequiredException() {
        super();
    }

    public NameIsRequiredException(String message) {
        super(message);
    }

    public NameIsRequiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public NameIsRequiredException(Throwable cause) {
        super(cause);
    }

    protected NameIsRequiredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
