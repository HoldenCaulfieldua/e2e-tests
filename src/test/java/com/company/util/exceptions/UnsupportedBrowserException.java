package com.company.util.exceptions;

/**
 * Created by oleg on 6/27/17.
 */
public class UnsupportedBrowserException extends RuntimeException {

    public UnsupportedBrowserException(String s) {
        super(s);
    }

    public UnsupportedBrowserException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
