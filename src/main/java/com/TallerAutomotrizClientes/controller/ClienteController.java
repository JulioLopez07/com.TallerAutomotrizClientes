package com.TallerAutomotrizClientes.controller;

import com.TallerAutomotrizClientes.entity.*;
import com.TallerAutomotrizClientes.repository.AutomovilRepository;
import com.TallerAutomotrizClientes.repository.ClienteRepository;
import com.TallerAutomotrizClientes.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AutomovilRepository automovilRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/clientes/registro")
    public String mostrarFormularioDeNuevoCliente(Model modelo){
        modelo.addAttribute("cliente", new Cliente());
        return "clientes_form";
    }

    @GetMapping("/clientes/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable("id") Integer id, Model modelo){
        Cliente cliente = clienteRepository.findById(id).get();
        modelo.addAttribute("cliente", cliente);
        return "clientes_form";
    }

    @GetMapping("/clientes/{id}/automoviles/{idAuto}/editar")
    public String editarAutomovil(@PathVariable("id") Integer id, @PathVariable("idAuto") Integer idAuto, Model modelo){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        Automovil automovil = automovilRepository.findById(idAuto).orElse(null);
        if (cliente != null && automovil != null && automovil.getCliente().equals(cliente)) {
            modelo.addAttribute("cliente", cliente);
            modelo.addAttribute("automovil", automovil);
            return "automovil_form";
        } else {
            return "redirect:/clientes/" + id + "/automoviles";
        }
    }

    @GetMapping ("/clientes")
    public String ListarClientes(Model modelo){
        List<Cliente> listaClientes = clienteRepository.findAll();
        modelo.addAttribute("listaClientes",listaClientes);
        return "clientes";
    }

    @PostMapping("/clientes/guardar")
    public String guardarClientes(Cliente cliente){
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") Integer id){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            clienteRepository.delete(cliente);
        }
        return "redirect:/clientes";
    }


    @GetMapping("/clientes/{id}/automoviles")
    public String mostrarAutomovilesDeCliente(@PathVariable("id") Integer id, Model modelo){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        List<Automovil> listaAutomoviles = automovilRepository.findByCliente(cliente);
        modelo.addAttribute("cliente", cliente);
        modelo.addAttribute("listaAutomoviles", listaAutomoviles);
        return "autosCliente";
    }

    @GetMapping("/clientes/{id}/automoviles/registro")
    public String mostrarFormularioDeNuevoAutomovil(@PathVariable("id") Integer id, Model modelo){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        modelo.addAttribute("cliente", cliente);
        modelo.addAttribute("automovil", new Automovil());
        return "automovil_form";
    }

    @PostMapping("/clientes/{id}/automoviles/guardar")
    public String guardarAutomovil(@PathVariable("id") Integer id, Automovil automovil){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        automovil.setCliente(cliente);
        automovilRepository.save(automovil);
        return "redirect:/clientes/" + id + "/automoviles";
    }

    @GetMapping("/clientes/{id}/automoviles/eliminar/{idAuto}")
    public String eliminarAutomovil(@PathVariable("id") Integer id, @PathVariable("idAuto") Integer idAuto){
        Automovil automovil = automovilRepository.findById(idAuto).orElse(null);
        if (automovil != null) {
            automovilRepository.delete(automovil);
        }
        return "redirect:/clientes/" + id + "/automoviles";
    }



}
