package com.example.accessmanagementsystem.service.contract;

import com.example.accessmanagementsystem.entity.Access;
import com.example.accessmanagementsystem.entity.Door;

public interface AccessServiceContract {

    void giveAccess(String doorNumber, String rfid);

    void removeAccess(String doorNumber, String rfid);

    Access createAccess(String doorNumber, String rfid);

    Access getAccess(String doorNumber, String rfid);
}
