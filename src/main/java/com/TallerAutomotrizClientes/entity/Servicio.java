package com.TallerAutomotrizClientes.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String diagnostico;

    @Column(name = "total_refacciones")
    private BigDecimal totalRefacciones;

    @Column(name = "mano_obra")
    private BigDecimal manoObra;

    @Column(name = "otros_materiales")
    private BigDecimal otrosMateriales;

    private BigDecimal subtotal;

    private BigDecimal iva;

    private String fecha;
    private String descripcion;

    private BigDecimal total;

    private BigDecimal anticipo;

    private BigDecimal saldo;

    @Column(name = "detalles_refacciones")
    private String detallesRefacciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "automovil_id")
    private Automovil automovil;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empleado_id")
    private Empleados empleados;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_metodo_pago")
    private MetodoPago metodoPago;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_servicio")
    private TipoServicio tipoServicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Servicio() {
    }

    public Servicio(Integer id, String diagnostico, BigDecimal totalRefacciones, BigDecimal manoObra, BigDecimal otrosMateriales, BigDecimal subtotal, BigDecimal iva, String fecha, String descripcion, BigDecimal total, BigDecimal anticipo, BigDecimal saldo, String detallesRefacciones, Automovil automovil, Empleados empleados, MetodoPago metodoPago, TipoServicio tipoServicio, Cliente cliente) {
        this.id = id;
        this.diagnostico = diagnostico;
        this.totalRefacciones = totalRefacciones;
        this.manoObra = manoObra;
        this.otrosMateriales = otrosMateriales;
        this.subtotal = subtotal;
        this.iva = iva;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.total = total;
        this.anticipo = anticipo;
        this.saldo = saldo;
        this.detallesRefacciones = detallesRefacciones;
        this.automovil = automovil;
        this.empleados = empleados;
        this.metodoPago = metodoPago;
        this.tipoServicio = tipoServicio;
        this.cliente = cliente;
    }

    public Servicio(String diagnostico, BigDecimal totalRefacciones, BigDecimal manoObra, BigDecimal otrosMateriales, BigDecimal subtotal, BigDecimal iva, String fecha, String descripcion, BigDecimal total, BigDecimal anticipo, BigDecimal saldo, String detallesRefacciones, Automovil automovil, Empleados empleados, MetodoPago metodoPago, TipoServicio tipoServicio, Cliente cliente) {
        this.diagnostico = diagnostico;
        this.totalRefacciones = totalRefacciones;
        this.manoObra = manoObra;
        this.otrosMateriales = otrosMateriales;
        this.subtotal = subtotal;
        this.iva = iva;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.total = total;
        this.anticipo = anticipo;
        this.saldo = saldo;
        this.detallesRefacciones = detallesRefacciones;
        this.automovil = automovil;
        this.empleados = empleados;
        this.metodoPago = metodoPago;
        this.tipoServicio = tipoServicio;
        this.cliente = cliente;
    }

    public String getDetallesRefacciones() {
        return detallesRefacciones;
    }

    public void setDetallesRefacciones(String detallesRefacciones) {
        this.detallesRefacciones = detallesRefacciones;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public BigDecimal getTotalRefacciones() {
        return totalRefacciones;
    }

    public void setTotalRefacciones(BigDecimal totalRefacciones) {
        this.totalRefacciones = totalRefacciones;
    }

    public BigDecimal getManoObra() {
        return manoObra;
    }

    public void setManoObra(BigDecimal manoObra) {
        this.manoObra = manoObra;
    }

    public BigDecimal getOtrosMateriales() {
        return otrosMateriales;
    }

    public void setOtrosMateriales(BigDecimal otrosMateriales) {
        this.otrosMateriales = otrosMateriales;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(BigDecimal anticipo) {
        this.anticipo = anticipo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
}