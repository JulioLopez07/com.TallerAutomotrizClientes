package com.TallerAutomotrizClientes.entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "metodos_pago")
public class MetodoPago {

    @Id
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "metodoPago", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Servicio> servicios = new ArrayList<>();

    public MetodoPago(Long id, String nombre, List<Servicio> servicios) {
        this.id = id;
        this.nombre = nombre;
        this.servicios = servicios;
    }

    public MetodoPago(String nombre, List<Servicio> servicios) {
        this.nombre = nombre;
        this.servicios = servicios;
    }

    public MetodoPago() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
}
