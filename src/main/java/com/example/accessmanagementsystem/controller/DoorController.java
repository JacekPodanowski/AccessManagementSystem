package com.example.accessmanagementsystem.controller;

import com.example.accessmanagementsystem.entity.Door;
import com.example.accessmanagementsystem.service.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class DoorController {
    private final DoorService doorService;

    @Autowired
    public DoorController(DoorService doorService) {
        this.doorService = doorService;
    }

    @GetMapping
    public String getAllDoors(Model model) {
        model.addAttribute("doors", doorService.getAllDoors());
        return "doors";
    }

    @PostMapping("/give-access")
    public String giveAccess(@RequestParam Long id) {
        // Logika nadawania dostępu (możesz ją rozwinąć)
        System.out.println("Access given to door with ID: " + id);
        return "redirect:/";
    }

    @PostMapping("/add-door")
    public String addDoor(@RequestParam String number, @RequestParam String rfid) {
        Door door = new Door();
        door.setNumber(number);
        doorService.saveDoor(door);
        return "redirect:/";
    }
}
