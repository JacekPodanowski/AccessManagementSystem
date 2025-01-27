package com.example.accessmanagementsystem.controller;

import com.example.accessmanagementsystem.entity.Access;
import com.example.accessmanagementsystem.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/access")
public class AccessController {

    private final AccessService accessService;

    @Autowired
    public AccessController(AccessService accessService) {
        this.accessService = accessService;
    }

    @GetMapping("/{doorNumber}")
    public ResponseEntity<List<Access>> getAccessesByDoor(
            @PathVariable String doorNumber
    ) {
        try {
            List<Access> accesses = accessService.getAccessesByDoor(doorNumber);
            return ResponseEntity
                    .ok()
                    .body(accesses);
        } catch (Exception e) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

    @GetMapping("/{doorNumber}/{rfid}")
    public ResponseEntity<Access> getOrCreateAccess(
            @PathVariable String doorNumber,
            @PathVariable String rfid
    ) {
        try {
            Access access = accessService.findOrCreateAccess(doorNumber, rfid);

            return ResponseEntity
                    .ok()
                    .body(access);
        } catch (Exception e) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

    @PostMapping("/give/{doorNumber}/{rfid}")
    public ResponseEntity<Void> giveAccess(
            @PathVariable String doorNumber,
            @PathVariable String rfid
    ) {
        try {
            accessService.giveAccess(doorNumber, rfid);
            return ResponseEntity
                    .ok()
                    .build();
        } catch (Exception e) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

    @PostMapping("/remove/{doorNumber}/{rfid}")
    public ResponseEntity<Void> removeAccess(
            @PathVariable String doorNumber,
            @PathVariable String rfid
    ) {
        try {
            accessService.removeAccess(doorNumber, rfid);
            return ResponseEntity
                    .ok()
                    .build();
        } catch (Exception e) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }
}
