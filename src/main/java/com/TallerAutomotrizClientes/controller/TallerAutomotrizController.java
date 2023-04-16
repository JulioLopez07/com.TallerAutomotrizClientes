package com.TallerAutomotrizClientes.controller;

import com.TallerAutomotrizClientes.entity.TallerAutomotriz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.TallerAutomotrizClientes.repository.TallerAutomotrizRepository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TallerAutomotrizController {
    @Autowired
    private TallerAutomotrizRepository tallerAutomotrizRepository;

    @GetMapping("/taller/agregar")
    public String mostrarFormularioDeNuevoTaller(Model modelo){
        modelo.addAttribute("taller", new TallerAutomotriz());
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
}
