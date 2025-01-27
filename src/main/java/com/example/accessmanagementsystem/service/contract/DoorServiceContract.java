package com.example.accessmanagementsystem.service.contract;

import com.example.accessmanagementsystem.entity.Door;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DoorServiceContract {

    List<Door> getAllDoors();

    @Transactional
    void createDoor(Door door);

    @Transactional
    void deleteDoor(Door door);
}
