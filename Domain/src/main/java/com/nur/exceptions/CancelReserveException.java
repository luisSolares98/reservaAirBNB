package com.nur.exceptions;

public class CancelReserveException extends Exception {
    public CancelReserveException(String message) {
        super( "the reservation could not be cancel out: " +  message);
    }
}