package com.example.accessmanagementsystem.service;

import com.example.accessmanagementsystem.model.Door;
import com.example.accessmanagementsystem.repository.DoorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoorService {
    private final DoorRepository doorRepository;

    public DoorService(DoorRepository doorRepository) {
        this.doorRepository = doorRepository;
    }

    public List<Door> getAllDoors() {
        return doorRepository.findAll();
    }

    public Door saveDoor(Door door) {
        return doorRepository.save(door);
    }
}
