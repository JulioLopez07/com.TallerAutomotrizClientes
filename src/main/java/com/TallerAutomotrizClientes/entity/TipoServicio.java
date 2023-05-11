package com.TallerAutomotrizClientes.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipos_servicio")
public class TipoServicio {

    @Id
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "tipoServicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Servicio> servicios = new ArrayList();

    public TipoServicio(Long id, String nombre, List<Servicio> servicios) {
        this.id = id;
        this.nombre = nombre;
        this.servicios = servicios;
    }

    public TipoServicio(String nombre, List<Servicio> servicios) {
        this.nombre = nombre;
        this.servicios = servicios;
    }

    public TipoServicio() {
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

