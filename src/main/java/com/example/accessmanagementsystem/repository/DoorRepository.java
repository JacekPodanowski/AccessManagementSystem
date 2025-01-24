package com.example.accessmanagementsystem.repository;

import com.example.accessmanagementsystem.model.Door;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoorRepository extends JpaRepository<Door, Long> {
}
