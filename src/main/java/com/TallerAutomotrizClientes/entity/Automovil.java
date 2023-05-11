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
    private String anio;
    @NotEmpty
    @Column(nullable = false)
    private String ultima_kilometraje;
    @NotEmpty
    @Column(nullable = false)
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    public Automovil(Integer id, String marca, String modelo, String placa, String anio, String ultima_kilometraje, String color, Cliente cliente) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.anio = anio;
        this.ultima_kilometraje = ultima_kilometraje;
        this.color = color;
        this.cliente = cliente;
    }

    public Automovil(String marca, String modelo, String placa, String anio, String ultima_kilometraje, String color, Cliente cliente) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.anio = anio;
        this.ultima_kilometraje = ultima_kilometraje;
        this.color = color;
        this.cliente = cliente;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Automovil() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAnio() {
        return anio;
    }

    public void setAño(String anio) {
        this.anio = anio;
    }

    public String getUltima_kilometraje() {
        return ultima_kilometraje;
    }

    public void setUltima_kilometraje(String ultima_kilometraje) {
        this.ultima_kilometraje = ultima_kilometraje;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
