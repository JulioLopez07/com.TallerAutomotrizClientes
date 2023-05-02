package com.TallerAutomotrizClientes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "automoviles")
public class Automovil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @NotEmpty
    @Column(nullable = false)
    private String marca;
    @NotEmpty
    @Column(nullable = false)
    private String modelo;
    @NotEmpty
    @Column(nullable = false)
    private String placa;
    @NotEmpty
    @Column(nullable = false)
    private Integer año;
    @NotEmpty
    @Column(nullable = false)
    private Double ultima_kilometraje;

}
