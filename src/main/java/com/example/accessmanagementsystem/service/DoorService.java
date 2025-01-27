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
    public void createDoor(Door door) {
        doorRepository.save(door);
    }

    @Override
    @Transactional
    public void deleteDoor(Door door) {
        if(!doorRepository.existsByNumber(door.getNumber())) {
            throw new DoorNotFound(door.getNumber());
        }

        doorRepository.delete(door);
    }
}
