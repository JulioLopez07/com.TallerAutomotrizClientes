package com.TallerAutomotrizClientes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "empleados")
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(nullable = false)
    private String nombre;
    @NotEmpty
    @Email
    @Column(nullable = false)
    private String correo_electronico;
    @NotEmpty
    @Column(nullable = false)
    private String telefono;
    @NotEmpty
    @Column(nullable = false)
    private String rfc;

    //Muchos empleados pueden tener un puesto
    @ManyToOne
    @JoinColumn(name = "puesto_id")
    private Puestos puestos;



    public Empleados(Integer id, String nombre, String correo_electronico, String telefono, String rfc, Puestos puestos) {
        this.id = id;
        this.nombre = nombre;
        this.correo_electronico = correo_electronico;
        this.telefono = telefono;
        this.rfc = rfc;
        this.puestos = puestos;
    }

    public Empleados(String nombre, String correo_electronico, String telefono, String rfc, Puestos puestos) {
        this.nombre = nombre;
        this.correo_electronico = correo_electronico;
        this.telefono = telefono;
        this.rfc = rfc;
        this.puestos = puestos;
    }

    public Empleados() {
        super();
    }


    public Empleados(Integer id) {
        this.id = id;
    }


    public Empleados(String nombre) {
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

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Puestos getPuestos() {
        return puestos;
    }

    public void setPuestos(Puestos puestos) {
        this.puestos = puestos;
    }
}
