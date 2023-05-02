package com.TallerAutomotrizClientes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class TallerAutomotriz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @NotEmpty
    @Column(nullable = false)
    private String nombre;
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
    @NotEmpty
    @Column(nullable = false)
    private String telefono;
    @NotEmpty
    @Column(nullable = false)
    private String correo_electronico;

    @ManyToOne
    @JoinColumn(name = "encargado_id")
    private Empleados empleados;

    public TallerAutomotriz() {
        super();
    }

    public TallerAutomotriz(Integer id, String nombre, String direccion, String cp, String ciudad, String estado, String telefono, String correo_electronico, Empleados empleados) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cp = cp;
        this.ciudad = ciudad;
        this.estado = estado;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
        this.empleados = empleados;
    }

    public TallerAutomotriz(String nombre, String direccion, String cp, String ciudad, String estado, String telefono, String correo_electronico, Empleados empleados) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cp = cp;
        this.ciudad = ciudad;
        this.estado = estado;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
        this.empleados = empleados;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
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

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
}
