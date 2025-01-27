package com.example.accessmanagementsystem.repository;

import com.example.accessmanagementsystem.entity.Door;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoorRepository extends JpaRepository<Door, String> {

    boolean existsByNumber(String number);

    Door findByNumber(String number);

}
