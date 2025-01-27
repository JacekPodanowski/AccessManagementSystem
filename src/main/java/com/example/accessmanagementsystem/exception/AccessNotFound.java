package com.example.accessmanagementsystem.exception;

public class AccessNotFound extends RuntimeException {
    public AccessNotFound(String number, String rfid) {
        super(String.format("Access to door with number %s for rfid %s not found", number, rfid));
    }
}
