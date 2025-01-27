package com.example.accessmanagementsystem.controller;

import com.example.accessmanagementsystem.entity.Door;
import com.example.accessmanagementsystem.service.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/door")
public class DoorController {
    private final DoorService doorService;

    @Autowired
    public DoorController(DoorService doorService) {
        this.doorService = doorService;
    }

    @GetMapping
    public ResponseEntity<List<Door>> getAllDoors() {
        List<Door> doors = doorService.getAllDoors();

        return ResponseEntity
                .ok()
                .body(doors);
    }

    @PostMapping
    public ResponseEntity<Void> addDoor(@RequestParam String number) {
        try {
            doorService.createDoor(number);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteDoor(@RequestParam String number) {
        try {
            doorService.deleteDoor(number);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } catch (Exception e) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }
}
