package com.TallerAutomotrizClientes.service;

import com.TallerAutomotrizClientes.entity.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmpleadoService {
    List<Empleado> findAll();

    Page<Empleado> findAll(Pageable pageable);

    public void save(Empleado empleado);

    public Empleado findOne(Integer id);

    public void delete(Integer id);
}
