package com.TallerAutomotrizClientes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @NotEmpty
    @Column(nullable = false)
    private String nombre;
    @NotEmpty(message = "El campo telefono no puede estar vacío")
    @Column(nullable = false)
    private String telefono;
    @NotEmpty
    @Column(nullable = false)
    private String correo_electronico;
    @NotEmpty
    @Column(nullable = false)
    private String direccion;
    @NotEmpty
    @Column(nullable = false)
    private String cp;
    @NotEmpty
    @Column(nullable = false)
    private String ciudad;
    @NotEmpty
    @Column(nullable = false)
    private String estado;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Automovil> automoviles = new ArrayList<>();

    public Cliente(Integer id, String nombre, String telefono, String correo_electronico, String direccion, String cp, String ciudad, String estado, List<Automovil> automoviles) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
        this.direccion = direccion;
        this.cp = cp;
        this.ciudad = ciudad;
        this.estado = estado;
        this.automoviles = automoviles;
    }

    public Cliente(Integer id, String nombre, String telefono, String correo_electronico, String direccion, String cp, String ciudad, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
        this.direccion = direccion;
        this.cp = cp;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    public Cliente(String nombre, String telefono, String correo_electronico, String direccion, String cp, String ciudad, String estado) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
        this.direccion = direccion;
        this.cp = cp;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    public List<Automovil> getAutomoviles() {
        return automoviles;
    }

    public void setAutomoviles(List<Automovil> automoviles) {
        this.automoviles = automoviles;
    }

    public Cliente() {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
