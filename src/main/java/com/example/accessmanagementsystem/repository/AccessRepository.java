package com.example.accessmanagementsystem.repository;

import com.example.accessmanagementsystem.entity.Access;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessRepository extends JpaRepository<Access, Integer> {

    boolean existsByDoorNumberAndRfid(String doorNumber, String rfid);

    Access findByDoorNumberAndRfid(String doorNumber, String rfid);
}
