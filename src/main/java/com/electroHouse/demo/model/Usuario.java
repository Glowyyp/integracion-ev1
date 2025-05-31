package com.electroHouse.demo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100, unique = false)
    private String nombres;

    @Column(nullable = false, length = 100, unique = false)
    private String apellidos;

    @Column(nullable = false, length = 100, unique = false)
    private String email;

}
