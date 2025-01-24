package com.example.accessmanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Door {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private <String,boolen> rfids; // to będzie tabela <String,boolean> bazowo false
    // [0] <444-944-8348-333, false>
    // [1] <434-325-234-532, true>
    // i jakiegos settera do zmiany tego booelan i to będzie ustwaiało dostęp


    // Getter i Setter dla id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter i Setter dla number
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

//    // Getter i Setter dla rfid
//    public String getRfid() {
//        return rfid;
//    }
//
//    public void setRfid(String rfid) {
//        this.rfid = rfid;
//    }
}
