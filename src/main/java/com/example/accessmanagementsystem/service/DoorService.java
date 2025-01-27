package com.example.accessmanagementsystem.service;

import com.example.accessmanagementsystem.exception.DoorNotFound;
import com.example.accessmanagementsystem.entity.Door;
import com.example.accessmanagementsystem.repository.DoorRepository;
import com.example.accessmanagementsystem.service.contract.DoorServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DoorService implements DoorServiceContract {

    private final DoorRepository doorRepository;

    @Autowired
    public DoorService(DoorRepository doorRepository) {
        this.doorRepository = doorRepository;
    }

    @Override
    public List<Door> getAllDoors() {
        return doorRepository.findAll();
    }

    @Override
    @Transactional
    public void createDoor(String number) {
        Door door = new Door();
        door.setNumber(number);

        doorRepository.save(door);
    }

    @Override
    @Transactional
    public void deleteDoor(String number) {
        Door door = doorRepository.findByNumber(number)
                        .orElseThrow(() -> new DoorNotFound(number));

        doorRepository.delete(door);
    }
}
