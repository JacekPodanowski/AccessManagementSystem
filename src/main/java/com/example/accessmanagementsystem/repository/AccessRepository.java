package com.example.accessmanagementsystem.repository;

import com.example.accessmanagementsystem.entity.Access;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccessRepository extends JpaRepository<Access, Integer> {

    boolean existsByDoorNumberAndRfid(String doorNumber, String rfid);

    Optional<Access> findByDoorNumberAndRfid(String doorNumber, String rfid);

    List<Access> findByDoorNumber(String doorNumber);
}
