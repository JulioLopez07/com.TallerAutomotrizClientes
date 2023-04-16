package com.TallerAutomotrizClientes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class TallerAutomotriz {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column( nullable = false)
    private String nombre;
    @NotEmpty
    private String direccion;
    @NotEmpty
    private String cp;
    @NotEmpty
    private String ciudad;
    @NotEmpty
    private String estado;
    @NotEmpty
    private String telefono;
    @NotEmpty
    private String correo;

    public TallerAutomotriz() {
        super();
    }

    public TallerAutomotriz(Integer id, String nombre, String direccion, String cp, String ciudad, String estado, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cp = cp;
        this.ciudad = ciudad;
        this.estado = estado;
        this.telefono = telefono;
        this.correo = correo;
    }

    public TallerAutomotriz(Integer id) {
        this.id = id;
    }

    public TallerAutomotriz(String nombre) {
        this.nombre = nombre;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
