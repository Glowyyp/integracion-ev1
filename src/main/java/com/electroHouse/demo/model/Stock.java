package com.electroHouse.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stock")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStock;

    @Column(nullable = false, length = 2, unique = false)
    private boolean hayStock;

    @Column(nullable = false, length = 100, unique = true)
    private String nombreProducto;



}
