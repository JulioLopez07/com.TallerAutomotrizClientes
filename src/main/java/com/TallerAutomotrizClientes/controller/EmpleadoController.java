package com.TallerAutomotrizClientes.controller;

import com.TallerAutomotrizClientes.entity.Empleado;
import com.TallerAutomotrizClientes.service.EmpleadoService;
import com.TallerAutomotrizClientes.util.paginacion.PageRender;
import jakarta.validation.Valid;
import org.hibernate.Session;
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

import java.util.Map;

@Controller
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/verDetalles/{id}")
    public String verDetallesDelEmpleado(@PathVariable(value="id") Integer id, Map<String,Object> modelo, RedirectAttributes flash){
        Empleado empleado = empleadoService.findOne(id);
        if(empleado == null){
            flash.addFlashAttribute("error", "El empleado no existe en la base de datos");
            return "redirect:/listar";
        }
        modelo.put("empleado", empleado);
        modelo.put("titulo", "Detalles del empleado " + empleado.getNombre());
        return "verDetalles";
    }

    @GetMapping({"/","/listar",""})
    public String listarEmpleados(@RequestParam(name = "page",defaultValue = "0")int page, Model model){
        Pageable pageRequest = PageRequest.of(page, 20);
        Page<Empleado> empleados = empleadoService.findAll(pageRequest);
        PageRender<Empleado> pageRender = new PageRender<>("/listar", empleados);
        model.addAttribute("titulo","Listado de empleados");
        model.addAttribute("empleados",empleados);
        model.addAttribute("page",pageRender);

        return  "listar";
    }

    @GetMapping("/formEmpleado")
    public String mostrarFormularioDeRegistroEmpleado(Map<String, Object> modelo){
        Empleado empleado = new Empleado();
        modelo.put("empleado", empleado);
        modelo.put("titulo", "Registro de empleados");
        return "formEmpleado";
    }

    @PostMapping("/formEmpleado")
    public String guardarEmpleado(@Valid Empleado empleado, BindingResult result, Model modelo, RedirectAttributes flash, SessionStatus status){
        if(result.hasErrors()){
            modelo.addAttribute("titulo", "Registro de empleados");
            return "formEmpleado";
        }
        String mensaje = (empleado.getId() != null) ? "El empleado ha sido editado con exito" : "Empleado registrado con exito";
        empleadoService.save(empleado);
        status.setComplete();
        flash.addFlashAttribute("succes", mensaje);
        return "redirect:listar";
    }

    @GetMapping("/formEmpleado/{id}")
    public String editarEmpleado(@PathVariable(value = "id") Integer id, Map<String, Object> modelo, RedirectAttributes flash){
        Empleado empleado = null;
        if(id > 0){
            empleado = empleadoService.findOne(id);
            if(empleado == null){
                flash.addFlashAttribute("error", "Id del empleado no existente");
                return "redirect:/listar";
            }
        }else{
            flash.addFlashAttribute("error", "Id del empleado no puede ser cero");
            return "redirect:/listar";
        }
        modelo.put("empleado", empleado);
        modelo.put("titulo", "Edición de empleado");
        return  "formEmpleado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable(value = "id") Integer id, RedirectAttributes flash){
        if(id > 0){
            empleadoService.delete(id);
            flash.addFlashAttribute("success", "Cliente eliminado con exito");
        }
        return "redirect:/listar";
    }




}
