package com.TallerAutomotrizClientes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "puestos")
public class Puestos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(nullable = false)
    private String nombre;

    //Una puesto puede tener varios empleados

    public Puestos(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Puestos(Integer id) {
        this.id = id;
    }

    public Puestos(String nombre) {
        this.nombre = nombre;
    }

    public Puestos() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
