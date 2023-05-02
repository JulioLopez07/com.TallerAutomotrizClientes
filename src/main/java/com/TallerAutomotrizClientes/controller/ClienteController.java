package com.TallerAutomotrizClientes.controller;

import com.TallerAutomotrizClientes.entity.Cliente;
import com.TallerAutomotrizClientes.entity.Empleados;
import com.TallerAutomotrizClientes.entity.Puestos;
import com.TallerAutomotrizClientes.entity.TallerAutomotriz;
import com.TallerAutomotrizClientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes/registro")
    public String mostrarFormularioDeNuevoCliente(Model modelo){
        modelo.addAttribute("cliente", new Cliente());
        return "clientes_form";
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

}
