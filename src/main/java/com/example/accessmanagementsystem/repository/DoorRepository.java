package com.example.accessmanagementsystem.repository;

import com.example.accessmanagementsystem.entity.Door;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoorRepository extends JpaRepository<Door, String> {

    Optional<Door> findByNumber(String number);

}
