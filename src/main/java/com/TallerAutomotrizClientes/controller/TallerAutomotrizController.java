package com.TallerAutomotrizClientes.controller;

import com.TallerAutomotrizClientes.entity.Empleados;
import com.TallerAutomotrizClientes.entity.TallerAutomotriz;
import com.TallerAutomotrizClientes.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.TallerAutomotrizClientes.repository.TallerAutomotrizRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TallerAutomotrizController {
    @Autowired
    private TallerAutomotrizRepository tallerAutomotrizRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping("/talleres/registro")
    public String mostrarFormularioDeNuevoTaller(Model modelo){
        List<Empleados> listaEmpleados = empleadoRepository.findAll();
        modelo.addAttribute("taller", new TallerAutomotriz());
        modelo.addAttribute("listaEmpleados", listaEmpleados);
        return "talleres_form";
    }


    @GetMapping ("/talleres")
        public String ListarTalleresAutomotices(Model modelo){
            List<TallerAutomotriz> listaTalleres = tallerAutomotrizRepository.findAll();
            modelo.addAttribute("listaTalleres",listaTalleres);
            return "talleres";
        }

    @PostMapping("/talleres/guardar")
    public String guardarTaller(TallerAutomotriz tallerAutomotriz){
        tallerAutomotrizRepository.save(tallerAutomotriz);
        return "redirect:/talleres";
    }

    @GetMapping("/talleres/editar/{id}")
    public String mostrarFormularioModificarTaller(@PathVariable("id") Integer id, Model modelo){
        TallerAutomotriz tallerAutomotriz = tallerAutomotrizRepository.findById(id).get();
        modelo.addAttribute("taller", tallerAutomotriz);
        List<Empleados> listaEmpleados = empleadoRepository.findAll();
        modelo.addAttribute("listaEmpleados", listaEmpleados);
        return  "talleres_form";
    }

    @GetMapping("/talleres/eliminar/{id}")
    public String eliminarPropducto(@PathVariable("id") Integer id, Model modelo){
        tallerAutomotrizRepository.deleteById(id);
        return "redirect:/talleres";
    }
}
