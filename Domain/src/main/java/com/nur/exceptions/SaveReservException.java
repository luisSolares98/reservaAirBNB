package com.nur.exceptions;

public class SaveReservException extends Exception {
    public SaveReservException(String message) {
        super( "the reservation could not be carried out: " +  message);
    }
}
