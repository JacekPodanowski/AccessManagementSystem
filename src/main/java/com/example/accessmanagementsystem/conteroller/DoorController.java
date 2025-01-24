package com.example.accessmanagementsystem.conteroller;

import com.example.accessmanagementsystem.model.Door;
import com.example.accessmanagementsystem.service.DoorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class DoorController {
    private final DoorService doorService;

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
        door.setRfid(rfid);
        doorService.saveDoor(door);
        return "redirect:/";
    }
}
