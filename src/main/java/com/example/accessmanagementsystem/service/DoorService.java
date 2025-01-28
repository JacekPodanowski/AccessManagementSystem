package com.example.accessmanagementsystem.service;

import com.example.accessmanagementsystem.exception.DoorNotFound;
import com.example.accessmanagementsystem.entity.Door;
import com.example.accessmanagementsystem.repository.DoorRepository;
import com.example.accessmanagementsystem.service.contract.DoorServiceContract;
import com.example.accessmanagementsystem.service.contract.EventServiceContract;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DoorService implements DoorServiceContract {

    private final DoorRepository doorRepository;
    private final EventServiceContract eventService;

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

        eventService.emitEvent(String.format("Created door with number %s", number));
    }

    @Override
    @Transactional
    public void deleteDoor(String number) throws DoorNotFound {
        Door door = doorRepository.findByNumber(number)
                        .orElseThrow(() -> new DoorNotFound(number));

        doorRepository.delete(door);;

        eventService.emitEvent(String.format("Deleted door with number %s", number));
    }
}
