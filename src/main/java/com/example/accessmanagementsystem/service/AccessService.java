package com.example.accessmanagementsystem.service;

import com.example.accessmanagementsystem.entity.Access;
import com.example.accessmanagementsystem.entity.Door;
import com.example.accessmanagementsystem.exception.AccessNotFound;
import com.example.accessmanagementsystem.exception.DoorNotFound;
import com.example.accessmanagementsystem.repository.AccessRepository;
import com.example.accessmanagementsystem.repository.DoorRepository;
import com.example.accessmanagementsystem.service.contract.AccessServiceContract;
import com.example.accessmanagementsystem.service.contract.EventServiceContract;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AccessService implements AccessServiceContract {

    private final AccessRepository accessRepository;
    private final DoorRepository doorRepository;
    private final EventServiceContract eventService;

    @Override
    public void giveAccess(String doorNumber, String rfid) {
        Access access = findOrCreateAccess(doorNumber, rfid);

        access.setAccess(true);
        accessRepository.save(access);

        eventService.emitEvent(String.format("Access given to door %s for RFID %s", doorNumber, rfid));
    }

    @Override
    public void removeAccess(String doorNumber, String rfid) {
        Access access = findOrCreateAccess(doorNumber, rfid);

        access.setAccess(false);
        accessRepository.save(access);

        eventService.emitEvent(String.format("Access removed to door %s for RFID %s", doorNumber, rfid));
    }

    private Access createAccess(String doorNumber, String rfid) throws DoorNotFound {
        Door door = doorRepository.findByNumber(doorNumber)
                .orElseThrow(() -> new DoorNotFound(doorNumber));

        Access access = new Access();
        access.setDoor(door);
        access.setRfid(rfid);
        access.setAccess(false);

        Access savedAccess = accessRepository.save(access);

        eventService.emitEvent(String.format("Access created to door %s for RFID %s", doorNumber, rfid));

        return savedAccess;
    }

    @Override
    public List<Access> getAccessesByDoor(String doorNumber) {
        return accessRepository.findByDoorNumber(doorNumber);
    }

    private Access getAccess(String doorNumber, String rfid) throws AccessNotFound {
        return accessRepository.findByDoorNumberAndRfid(doorNumber, rfid)
                .orElseThrow(() -> new AccessNotFound(doorNumber, rfid));
    }

    @Override
    public Access findOrCreateAccess(String doorNumber, String rfid) throws DoorNotFound {
        Access access;
        if(!accessRepository.existsByDoorNumberAndRfid(doorNumber, rfid)) {
            access = createAccess(doorNumber, rfid);
        } else {
            access = getAccess(doorNumber, rfid);
        }

        return access;
    }
}
