package com.example.accessmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(
        name = "accesses",
        uniqueConstraints = @UniqueConstraint(columnNames = {"door", "rfid"})
)
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String rfid;

    @Column(nullable = false)
    private boolean access;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "door", nullable = false, referencedColumnName = "number")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Door door;
}
