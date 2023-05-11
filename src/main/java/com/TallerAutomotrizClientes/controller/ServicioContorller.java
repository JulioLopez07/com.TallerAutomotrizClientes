package com.TallerAutomotrizClientes.controller;

import com.TallerAutomotrizClientes.entity.*;
import com.TallerAutomotrizClientes.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
@Controller
public class ServicioContorller {

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private TipoServicioRepository tipoServicioRepository;

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private AutomovilRepository automovilRepository;

    @GetMapping("/servicios")
    public String listarServicios(Model modelo) {
        List<Servicio> listaServicios = servicioRepository.findAll();
        modelo.addAttribute("listaServicios", listaServicios);
        return "servicios";
    }

    @GetMapping("empleados/{idEmpleado}/servicios")
    public String listarServiciosPorEmpleado(Model modelo, @PathVariable Integer idEmpleado) {
        Empleados empleados = empleadoRepository.findById(idEmpleado).orElse(null);
        List<Servicio> listaServicios = servicioRepository.findByEmpleadosId(idEmpleado);
        modelo.addAttribute("listaServicios", listaServicios);
        return "serviciosEmpleado";
    }

    @GetMapping("/clientes/{id}/servicios")
    public String mostrarServiciosDeCliente(@PathVariable("id") Integer id, Model modelo){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        List<Servicio> listaServicios = servicioRepository.findByCliente(cliente);
        modelo.addAttribute("cliente", cliente);
        modelo.addAttribute("listaServicios", listaServicios);
        return "serviciosCliente";
    }

    @GetMapping("/clientes/{id}/automoviles/{idAuto}/servicios")
    public String mostrarServiciosDeAutomovil(@PathVariable("id") Integer id, @PathVariable("idAuto") Integer idAuto, Model modelo) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        Automovil automovil = automovilRepository.findById(idAuto).orElse(null);
        List<Servicio> listaServicios = servicioRepository.findByAutomovil(automovil);
        modelo.addAttribute("cliente", cliente);
        modelo.addAttribute("automovil", automovil);
        modelo.addAttribute("listaServicios", listaServicios);
        return "serviciosAutomovil";
    }

    @GetMapping("/clientes/{id}/servicios/registro")
    public String mostrarFormularioDeNuevoServicio(@PathVariable("id") Integer id, Model modelo){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        List<TipoServicio> tiposDeServicio = tipoServicioRepository.findAll();
        List<MetodoPago> metodosDePago = metodoPagoRepository.findAll();
        modelo.addAttribute("cliente", cliente);
        modelo.addAttribute("servicio", new Servicio());
        modelo.addAttribute("tiposDeServicio", tiposDeServicio);
        modelo.addAttribute("metodosDePago", metodosDePago);
        return "servicios_form";
    }

    @GetMapping("/servicios/{id}")
    public String mostrarDetallesDeServicio(@PathVariable("id") Integer id, Model modelo) {
        Servicio servicio = servicioRepository.findById(id).orElse(null);
        modelo.addAttribute("servicio", servicio);
        return "servicio_detalles";
    }

    @DeleteMapping("/servicios/eliminar/{id}")
    public String eliminarServicio(@PathVariable("id") Integer id) {
        servicioRepository.deleteById(id);
        return "redirect:/servicios";
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Servicio> servicios = servicioRepository.findTop5ByOrderByIdDesc();
        model.addAttribute("servicios", servicios);
        return "index";
    }

    @GetMapping("/clientes/{idCliente}/automoviles/{idAutomovil}/servicios/registro")
    public String mostrarFormularioDeNuevoServicioConAutomovil(@PathVariable("idCliente") Integer idCliente, @PathVariable("idAutomovil") Integer idAutomovil, Model modelo) {
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        Automovil automovil = automovilRepository.findById(idAutomovil).orElse(null);
        if (cliente == null || automovil == null) {
            return "redirect:/error";
        }
        List<TipoServicio> tiposDeServicio = tipoServicioRepository.findAll();
        List<MetodoPago> metodosDePago = metodoPagoRepository.findAll();
        List<Empleados> empleados = empleadoRepository.findAll();
        modelo.addAttribute("cliente", cliente);
        modelo.addAttribute("automovil", automovil);
        modelo.addAttribute("servicio", new Servicio());
        modelo.addAttribute("tiposDeServicio", tiposDeServicio);
        modelo.addAttribute("metodosDePago", metodosDePago);
        modelo.addAttribute("empleados", empleados);
        return "servicios_form";
    }

    @PostMapping("/clientes/{idCliente}/automoviles/{idAutomovil}/servicios/nuevo")
    public String guardarServicio(@PathVariable Integer idCliente, @PathVariable Integer idAutomovil, @ModelAttribute Servicio servicio,
                                  @RequestParam("fecha") String fecha,
                                  @RequestParam("manoObra") Double manoObra,
                                  @RequestParam("otrosMateriales") Double otrosMateriales, @RequestParam("empleados") Empleados empleados) {

        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        Automovil automovil = automovilRepository.findById(idAutomovil).orElse(null);
        servicio.setAutomovil(automovil);
        servicio.setCliente(cliente);
        servicio.setFecha(fecha);
        servicio.setEmpleados(empleados);
        servicio.setManoObra(BigDecimal.valueOf(manoObra));
        servicio.setOtrosMateriales(BigDecimal.valueOf(otrosMateriales));
        servicioRepository.save(servicio);

        return "redirect:/clientes/" + idCliente + "/automoviles/" + idAutomovil + "/servicios";
    }



}
