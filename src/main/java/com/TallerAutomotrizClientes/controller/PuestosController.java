package com.TallerAutomotrizClientes.controller;

import com.TallerAutomotrizClientes.entity.Empleados;
import com.TallerAutomotrizClientes.entity.Puestos;
import com.TallerAutomotrizClientes.entity.TallerAutomotriz;
import com.TallerAutomotrizClientes.repository.EmpleadoRepository;
import com.TallerAutomotrizClientes.repository.PuestosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PuestosController {
    @Autowired
    private PuestosRepository puestosRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping ("/puestos")
    public String listarPuestos(Model modelo){
        List<Puestos> listaPuestos = puestosRepository.findAll();
        modelo.addAttribute("listaPuestos",listaPuestos);
        return "puestos";
    }

    @GetMapping("/puestos/registro")
    public String mostrarFormularioNuevoPuesto(Model modelo){
        modelo.addAttribute("puesto", new Puestos());
        return "puestos_form";
    }

    @PostMapping("/puestos/guardar")
    public String guardarPusto(Puestos puestos){
        puestosRepository.save(puestos);
        return "redirect:/puestos";
    }

    @GetMapping("/puestos/editar/{id}")
    public String mostrarFormularioModificarPuesto(@PathVariable("id") Integer id, Model modelo){
        Puestos puestos = puestosRepository.findById(id).get();
        modelo.addAttribute("puesto", puestos);
        return  "puestos_form";
    }

    @GetMapping("/puestos/eliminar/{id}")
    public String eliminarpuesto(@PathVariable("id") Integer id, Model modelo){
        puestosRepository.deleteById(id);
        return "redirect:/puestos";
    }


}
