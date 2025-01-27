package com.example.accessmanagementsystem.service.contract;

import com.example.accessmanagementsystem.entity.Access;

import java.util.List;

public interface AccessServiceContract {

    void giveAccess(String doorNumber, String rfid);

    void removeAccess(String doorNumber, String rfid);

    List<Access> getAccessesByDoor(String doorNumber);

    Access findOrCreateAccess(String doorNumber, String rfid);
}
