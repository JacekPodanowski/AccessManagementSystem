package com.example.accessmanagementsystem.exception;

public class DoorNotFound extends RuntimeException {
    public DoorNotFound(String number) {
        super(String.format("Door with number %s not found", number));
    }
}
