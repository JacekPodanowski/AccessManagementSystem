package com.example.accessmanagementsystem.controller;

import com.example.accessmanagementsystem.entity.Access;
import com.example.accessmanagementsystem.service.AccessService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/access")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AccessController {

    private static final Logger logger = LoggerFactory.getLogger(AccessController.class);

    private final AccessService accessService;

    @GetMapping("/{doorNumber}")
    public ResponseEntity<List<Access>> getAccessesByDoor(
            @PathVariable String doorNumber
    ) {
        try {
            List<Access> accesses = accessService.getAccessesByDoor(doorNumber);
            logger.info("Returning accesses: {}", accesses);
            return ResponseEntity
                    .ok()
                    .body(accesses);
        } catch (Exception e) {
            logger.error("Error fetching accesses for door: {}", doorNumber, e);
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
            logger.info("Returning access: {}", access);
            return ResponseEntity
                    .ok()
                    .body(access);
        } catch (Exception e) {
            logger.error("Error fetching or creating access for door: {}, RFID: {}", doorNumber, rfid, e);
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
            logger.info("Access granted for door: {}, RFID: {}", doorNumber, rfid);
            return ResponseEntity
                    .ok()
                    .build();
        } catch (Exception e) {
            logger.error("Error granting access for door: {}, RFID: {}", doorNumber, rfid, e);
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
            logger.info("Access removed for door: {}, RFID: {}", doorNumber, rfid);
            return ResponseEntity
                    .ok()
                    .build();
        } catch (Exception e) {
            logger.error("Error removing access for door: {}, RFID: {}", doorNumber, rfid, e);
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }
}
