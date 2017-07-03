package com.company.util.exceptions;


public class UnsupportedBrowserException extends RuntimeException {

    public UnsupportedBrowserException(String s) {
        super(s);
    }

    public UnsupportedBrowserException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
