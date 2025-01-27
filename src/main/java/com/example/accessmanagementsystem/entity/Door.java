package com.example.accessmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "doors")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Door {

    @Id
    @Column(nullable = false, unique = true)
    private String number;

    @OneToMany(mappedBy = "door", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Access> logs;

}
