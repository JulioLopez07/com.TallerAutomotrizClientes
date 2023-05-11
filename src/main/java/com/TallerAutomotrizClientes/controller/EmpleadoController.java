package com.TallerAutomotrizClientes.controller;

import com.TallerAutomotrizClientes.entity.Empleados;
import com.TallerAutomotrizClientes.entity.Puestos;
import com.TallerAutomotrizClientes.entity.TallerAutomotriz;
import com.TallerAutomotrizClientes.repository.EmpleadoRepository;
import com.TallerAutomotrizClientes.repository.PuestosRepository;
import com.TallerAutomotrizClientes.repository.TallerAutomotrizRepository;
import com.TallerAutomotrizClientes.util.paginacion.PageRender;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmpleadoController {
    private final TallerAutomotrizRepository tallerAutomotrizRepository;
    private final PuestosRepository puestosRepository;
    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoController(TallerAutomotrizRepository tallerAutomotrizRepository,
                              PuestosRepository puestosRepository,
                              EmpleadoRepository empleadoRepository) {
        this.tallerAutomotrizRepository = tallerAutomotrizRepository;
        this.puestosRepository = puestosRepository;
        this.empleadoRepository = empleadoRepository;
    }

    @GetMapping("/empleados")
    public String listarEmpleados(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 20);
        Page<Empleados> empleados = empleadoRepository.findAll(pageRequest);
        PageRender<Empleados> pageRender = new PageRender<>("/empleados", empleados);
        model.addAttribute("titulo", "Listado de empleados");
        model.addAttribute("empleados", empleados);
        model.addAttribute("page", pageRender);

        return "listar";
    }

    @GetMapping("/empleados/registro")
    public String mostrarFormularioDeRegistroEmpleado(Model modelo) {
        List<TallerAutomotriz> listaTalleres = tallerAutomotrizRepository.findAll();
        List<Puestos> listaPuestos = puestosRepository.findAll();
        Empleados empleados = new Empleados();
        modelo.addAttribute("empleados", new Empleados());
        modelo.addAttribute("listaTalleres", listaTalleres);
        modelo.addAttribute("listaPuestos", listaPuestos);
        return "formEmpleado";
    }

    @PostMapping("/empleados/guardar")
    public String guardarEmpleado(@Valid Empleados empleados, BindingResult result, Model modelo, RedirectAttributes flash, SessionStatus status) {
        if (result.hasErrors()) {
            modelo.addAttribute("titulo", "Registro de empleados");
            return "formEmpleado";
        }
        String mensaje = (empleados.getId() != null) ? "El empleado ha sido editado con exito" : "Empleado registrado con exito";
        empleadoRepository.save(empleados); // Actualizado
        status.setComplete();
        flash.addFlashAttribute("success", mensaje);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/editar/{id}")
    public String editarEmpleado(@PathVariable(value = "id") Integer id, Model modelo, RedirectAttributes flash) {
        Empleados empleados = empleadoRepository.findById(id).orElse(null);
        if (empleados == null) {
            flash.addFlashAttribute("error", "El empleado no existe en la base de datos");
            return "redirect:/empleados";
        }
        List<TallerAutomotriz> listaTalleres = tallerAutomotrizRepository.findAll();
        List<Puestos> listaPuestos = puestosRepository.findAll();
        modelo.addAttribute("empleados", empleados);
        modelo.addAttribute("titulo", "Edición de empleado");
        modelo.addAttribute("listaTalleres", listaTalleres);
        modelo.addAttribute("listaPuestos", listaPuestos);
        return "formEmpleado";
    }

    @GetMapping("/empleados/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable(value = "id") Integer id, RedirectAttributes flash) {
        Empleados empleados = empleadoRepository.findById(id).orElse(null);
        if (empleados != null) {
            empleadoRepository.delete(empleados);
            flash.addFlashAttribute("success", "Empleado eliminado con éxito");
        } else {
            flash.addFlashAttribute("error", "El empleado no existe en la base de datos");
        }
        return "redirect:/empleados";
    }
}